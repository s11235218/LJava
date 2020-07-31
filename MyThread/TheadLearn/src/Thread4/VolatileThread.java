package Thread4;

/**volatile
 * 1.可见性
 * 2.有序性
 *
 * 注意：
 * 1.不能保证原子性
 * 2.volatile修饰的变量，进行赋值不能依赖变量（常量赋值可以保证线程安全）
 *
 * 使用场景：
 * volatile可结合线程加锁的一些手段，提高线程效率
 * 变量读取、常量赋值，可以不加锁，而是使用volatile，提高效率
 * */

public class VolatileThread {

    private static final int NUM = 20;
    private static final int COUNT = 10000;
    private volatile static int SUM;

    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < COUNT; j++) {
                        // SUM++分解为三条指令：
                        // 1.读取主内存SUM变量
                        // 2.SUM++
                        // 3.写回主内存
                        // volatile不能保证原子性，所以不能保证n++、n--操作的线程安全
                        // volatile对变量进行赋值操作时，需要是常量（不能依赖变量）
                        SUM++;
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
}
