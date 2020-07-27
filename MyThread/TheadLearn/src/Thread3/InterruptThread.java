package Thread3;

public class InterruptThread {

    // 中断一个线程，但是线程没有处理中断
    public static void test1() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                }
            }
        });
        t.start();
        t.interrupt();
    }

    //
    public static void test2() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
//                for (int i = 0; i < 50; i++) {
//                    System.out.println(i + "=" + Thread.currentThread().isInterrupted());
//                }

                // 线程运行状态时，需要自行判断中断标志位，处理中断操作
                // while (!Thread.currentThread().isInterrupted()) {
                while (!Thread.interrupted()) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        });
        t.start();// t 线程中的中断标志位=false
        t.interrupt();// t线程的中断标志位=true
    }

    public static void test3() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().isInterrupted());// true

                    // 线程调用wait()/join()/sleep()阻塞时，如果中断了当前线程，会直接抛一个异常
                    // 阻塞状态时，通过捕获及处理异常，来处理线程的中断逻辑
                    // 抛出异常后，线程中断标志位会进行重置
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().isInterrupted());// false
                }
            }
        });
        t.start();// t 线程中的中断标志位=false
        t.interrupt();// t线程的中断标志位=true
    }

    public static void main(String[] args) throws InterruptedException {
        test3();
    }
}
