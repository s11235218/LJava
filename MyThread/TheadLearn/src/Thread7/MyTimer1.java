package Thread7;

import java.util.concurrent.*;

public class MyTimer1 {

    private static BlockingDeque<Runnable> queue = (BlockingDeque<Runnable>) new PriorityBlockingQueue();

    public MyTimer1(int count) {
        for (int i = 0; i < count; i++) {
            new Thread(new MyWorker(queue)).start();
        }
    }

    private static class MyWorker implements Runnable {

        private BlockingDeque<Runnable> queue;

        public MyWorker(BlockingDeque<Runnable> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    // 本身就是线程安全，所以这里方法调用不用放在同步代码块
                    MyTimerTask task = (MyTimerTask) queue.take();
                    synchronized (queue) {
                        long current = System.currentTimeMillis();
                        if (task.next > current) {
                            // 阻塞当前线程 等待时间差
                            queue.wait(task.next - current);
                            queue.put(task);
                        }else{
                            task.task.run();
                            if (task.period > 0){
                                task.next = task.next + task.period;
                                queue.put(task);
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void schedule(Runnable task, long delay, long period) {

        try {
            queue.put(new MyTimerTask(task, System.currentTimeMillis() + delay, period));
            synchronized (queue) {
                queue.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(4);// 正式员工

        pool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("起床！");
            }
        },1, 1, TimeUnit.SECONDS);
    }

    private static class MyTimerTask implements Runnable, Comparable<MyTimerTask> {
        // 定时任务
        private Runnable task;
        // 下一次执行时间
        private long next;
        private long period;

        public MyTimerTask(Runnable task, long next, long period) {
            this.task = task;
            this.next = next;
            this.period = period;
        }

        @Override
        public void run() {

        }

        @Override
        public int compareTo(MyTimerTask o) {
            return Long.compare(next, o.next);
        }
    }
}
