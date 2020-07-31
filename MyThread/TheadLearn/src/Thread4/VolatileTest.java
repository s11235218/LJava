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

public class VolatileTest {

    private static int SUM;

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        synchronized (VolatileTest.class) {
                            if (SUM < 100000) {
                                SUM++;
                            }
                        }
                    }
                }
            }).start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(SUM);
    }
}
