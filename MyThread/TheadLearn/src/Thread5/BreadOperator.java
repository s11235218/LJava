package Thread5;

public class BreadOperator {
    
    // 库存面包数量：上限100，下限0
    public static volatile int SUM;

    public static void main(String[] args) {
        // 启动5个生产者生产
        for (int i = 0; i < 5; i++) {
            new Thread(new Producer(), "面包师傅" + i).start();
        }
        // 启动20个消费者
        for (int i = 0; i < 5; i++) {
            new Thread(new Consumer(), "消费者" + i).start();
        }
    }
    
    // 默认生产者：一个面包师傅一次生产3个面包，每个人生产20次
    private static class Producer implements Runnable {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 20; i++) {
                    synchronized(BreadOperator.class) {
                        // 生产完 库存大于100 则不能生产
                        while (SUM + 3 > 100) {
                            // 释放对象锁，需要其他线程进入同步代码块，当前线程需进入阻塞
                            BreadOperator.class.wait();
                        }
                        SUM += 3;// 生产面包
                        Thread.sleep(10);
                        BreadOperator.class.notify();
                        System.out.println(Thread.currentThread().getName() + "生产了，库存为：" + SUM);
                    }
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    // 默认消费者：一个消费者消费一个面包，一直消费
    private static class Consumer implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized(BreadOperator.class) {
                        // 库存不够，不能继续消费，阻塞当前线程
                        while (SUM == 0) {
                            BreadOperator.class.wait();
                        }
                        SUM--;
                        Thread.sleep(10);
                        // notify()/notifyAll()都是通知调用wait()被阻塞的线程
                        // notify()随机唤醒一个wait()阻塞的线程
                        // notifyAll()唤醒全部wait()阻塞的线程
                        // 在synchronized代码块结束后，也就是释放锁之后，才会唤醒
                        // synchronized结束后，wait()和synchronized代码行阻塞的线程，都会被唤醒
                        BreadOperator.class.notify();
                        System.out.println(Thread.currentThread().getName() + "消费了，库存为：" + SUM);
                    }
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
