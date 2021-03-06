package Thread3;

/** 线程安全问题：
 * 原子性：操作不具有原子性，导致在代码行之间插入了并发/并行
 *    特殊的原子性代码（分解执行存在编译为class文件时，也可能存在于CPU执行指令）：
 *    （1）n++, n--, ++n, --n都不是原子性：步骤分为从内存读取变量到CPU，修改变量，写回内存
 *    （2）对象new操作 Object obj = new Object(): 步骤分为对象内存，初始化对象，将对象赋值给变量
 * 可见性：
 * 重排序：线程内代码是JVM、CPU进行重排序，给我们感觉是有序的，是因为重排序优化方案会保证线程内代码执行的依赖关系
 *    （1）线程内看自己代码运行，有序，但看其他线程代码运行，无序
 *
 */

public class UnsafeThread {

    private static final int NUM = 20;
    private static final int COUNT = 10000;
    private static int SUM;

    public static void main(String[] args) {
        // 同时启动20个线程，每个线程对同一个变量执行操作：循环1000次，每次循环++操作
        // 预期结果20 * 10000
        // int数据类型，值处于-128到127之间，存在于常量池中，超出范围，处于堆

        for (int i = 0; i < NUM; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < COUNT; j++) {
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
