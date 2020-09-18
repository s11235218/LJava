package Thread7;

import java.util.concurrent.*;

public class MyTimer1 {

    private static BlockingDeque<Runnable> queue = (BlockingDeque<Runnable>) new PriorityBlockingQueue();

    public MyTimer1() {

    }

    public static void schedule(Runnable task, long delay, long period) {

        try {
            queue.put(new MyTimerTask(task, System.currentTimeMillis() + delay, period));
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
