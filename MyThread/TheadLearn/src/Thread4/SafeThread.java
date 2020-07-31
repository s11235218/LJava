package Thread4;

/**synchronized 关键字语法：
 * 1.静态方法
 * 2.实例方法
 * 3.代码块：synchronized（对象） {  // new 对象、class对象
 *     // TODO
 * }
 *
 * 进入 synchronized 代码行时，需要获取对象锁：
 * 1.获取成功：往下执行
 * 2.获取失败：阻塞在 synchronized 代码行
 *
 * 退出 synchronized 代码块，或 synchronized 方法：
 * 1.退回对象锁
 * 2.通知Java虚拟机及系统，其他线程可以竞争这把锁
 *
 * 注意：
 * 1.对哪个对象加锁
 * 2.只有同一对象，才会有同步互斥作用
 * 3.对于synchronized内代码来说，在同一时间点，只有一个线程在运行（没有并发、并行）
 * */

public class SafeThread {

    private static final int NUM = 20;
    private static final int COUNT = 10000;
    private static int SUM;

    public static void main(String[] args) {
        // 同时启动20个线程，每个线程对同一个变量执行操作：循环1000次，每次循环++操作
        // 预期结果20 * 10000
        for (int i = 0; i < NUM; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < COUNT; j++) {
                        // increment();
                        synchronized (SafeThread.class) {
                            SUM++;
                        }
//                        synchronized (this) { // 对runnable对象进行加锁
//                            SUM++;
//                        }
                    }
                }
            }).start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        // 1.不是预期结果
        // 2.每次运行结果不同
        System.out.println(SUM);
    }

    // 等同于synchronized(SafeThread.class){}
    public static synchronized void increment() {// 对当前类进行加锁
        SUM++;
    }

//    public static void increment() {
//        synchronized (SafeThread.class) {
//
//        }
//    }

    // 等同于 synchronized (this) {}
    // new SafeThread().increment2();
    public synchronized void increment2() { // 对 this 对象加锁

    }
//    public void increment2() {
//        synchronized (this) {
//
//        }
//    }
}
