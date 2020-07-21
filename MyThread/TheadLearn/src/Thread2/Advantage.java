package Thread2;

public class Advantage {

    // private static final int COUNT = 10_1000_1000;

    private static final int NUM = 5;

    private static void increment() {
        int count = 10_1000_1000;
        int r = 0;
        for (int i = 0; i < count; i++) {
            r++;
        }
    }

    // 串行（代码行依次执行）
    private static void serial(){
        long start = System.currentTimeMillis();// 1970-01-01开始，到当前的毫秒数
        for (int i = 0; i < NUM; i++) {
            increment();
        }
        long end = System.currentTimeMillis();
        System.out.printf("串行执行时间：%s毫秒\n", end - start);
    }

    // 并行（有时Java语义中，并发既表达并发，也表达并行）
    private static void parallel(){
        long start = System.currentTimeMillis();// 1970-01-01开始，到当前的毫秒数
        for (int i = 0; i < NUM; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    increment();
                }
            }).start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();// 将当前线程由运行态-->就绪态
        }
        long end = System.currentTimeMillis();
        System.out.printf("并发执行时间：%s毫秒\n", end - start);
    }

    public static void main(String[] args) {
        serial();
        parallel();
    }
}
