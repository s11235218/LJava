package learn3;

public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
//        // 片段1
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    while (!Thread.interrupted()) {
//                        System.out.println(Thread.currentThread().getName());
//                        Thread.sleep(10000);
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();
//        Thread.sleep(2000);
//        // 特殊情况出现 中断线程
//        thread.interrupt();
//
//
//        // 片段2
//        // 线程初始时 中断标志位 = false
//        // 调用线程的interrupt()方法 中断标志位 = true
//        // 如果线程处于阻塞状态，中断抛出 InterruptedException 时会重置线程的中断标志位
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (!Thread.interrupted()) {
//                    System.out.println(Thread.currentThread().getName());
//                    try {
//                        // sleep 线程阻塞时 也可中断
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        // 线程阻塞时 抛出InterruptedException中断线程isInterrupted = false
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        thread1.start();
//        Thread.sleep(2000);
//        // 特殊情况出现 中断线程
//        thread1.interrupt(); //thread1.isInterrupted = true;

//        // 片段3
//        Thread thread = new Thread(new Runnable() { // isInterrupted = true
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    // Thread.interrupted():返回当前的中断标志位，并重置
//                    //  boolean tmp = isInterrupted;
//                    //  isInterrupted = false;
//                    //  return tmp;
//                    System.out.println(Thread.interrupted());
//                }
//            }
//        });
//        thread.start();
//        // 特殊情况出现 中断线程
//        thread.interrupt();

        // 片段4 线程对象.isInterrupt() 作用 只返回中断标志位 不做任何修改
        Thread thread = new Thread(new Runnable() { // isInterrupted = true
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    // Thread.interrupted():返回当前的中断标志位，并重置
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        // 特殊情况出现 中断线程
        thread.interrupt();
    }
}
