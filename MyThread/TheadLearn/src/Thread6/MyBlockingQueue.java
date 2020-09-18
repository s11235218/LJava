package Thread6;

/**实现阻塞式队列：
 * 1.满足线程安全的生产、消费功能
 * 2.生产、消费达到上限/下限时，需要阻塞等待
 * */

public class MyBlockingQueue<E> {

    private Object[] items;

    private int takeIndex; // 弹出元素索引
    private int putIndex; // 添加元素索引
    private volatile int size; // 有效容量

    public MyBlockingQueue(int capacity) {
        items = new Object[capacity];
    }

    public synchronized void put(E e) throws InterruptedException {
        while (size == items.length) { // 达到上限，需要等待
            wait();
        }
        putIndex = (putIndex + 1) % items.length; // 存放元素的索引++，需要满足循环队列索引>数组长度
        items[putIndex] = e; // 存放元素
        size++;
        notifyAll();
    }

    /** 线程间通信，推荐做法：
     *  1.while 判断，不使用if
     *  （因为在判断代码中进行wait释放锁以后，其他线程会修改变量，再次wait被通知恢复时，条件已经不满足了）
     *  2.使用notifyAll方法，通知所有wait被阻塞的线程
     *
     *  */
    public synchronized E take() throws InterruptedException {
        while (size == 0) { // 达到下限，需要等待
            wait();
        }
        takeIndex = (takeIndex + 1) % items.length;
        size--;
        return (E) items[takeIndex];
    }

    private static int SUM;

    private static class Producer implements Runnable {

        @Override
        public void run() {
            SUM++;
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            SUM--;
            System.out.println("消费，库存为；" + SUM);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(100);
        for (int i = 0; i < 5; i++) {
            final int k = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int j = 0; j < 100; j++) {
                            queue.put(k * 100 + j);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        while (true) {
            int num = queue.take();
            System.out.println(num);
        }
    }
}
