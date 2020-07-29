package Thread4;

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

    public static synchronized void increment() {
        SUM++;
    }
}
