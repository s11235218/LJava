package Thread3;

/**
 * 1.线程启动后：中断标志位=false
 * 2.在线程运行态中，处理线程中断，需要通过判断中断标志位，来进行中断的处理逻辑。
 *    thread.isInterrupted()/Thread.Interrupted()
 * 3.线程因调用wait()/join()/sleep()阻塞状态时，将线程中断，会造成：
 *    （1）在这三个阻塞方法所在行，抛出InterruptedException异常
 *    （2）抛出异常后，重置线程的中断标志位（=true）
 * 4.static void interrupted():返回中断标志位，并重置标志位
 *   void isInterrupted():返回中断标志位
 * 5.自定义的标志位满足不了线程处于阻塞状态时，中断操作
 */

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

    private static volatile boolean IS_INTERRUPTED;
    // 自定义中断标志位
    public static void test5() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
//                // 自定义的标志位能满足线程处于运行态的中断操作
//                while (!IS_INTERRUPTED) {
//                    System.out.println(Thread.currentThread().getName());
//                }
                try {
                    Thread.sleep(99999);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        IS_INTERRUPTED = false;
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

    public static void test4() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    // 返回中断标志位，并重置标志位
                    //System.out.println(Thread.interrupted());
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        t.start();
        t.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        test5();
    }
}
