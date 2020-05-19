package learn;

public class SafeThread {
    private static int SUM;

    public static synchronized void increment(int n) {
        SUM++;
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increment(j);
                    }
                }
            }).start();
        }
        // 所有子线程执行完之后 打印SUM
        while (Thread.activeCount() > 1) {
            Thread.yield();// 当前线程由运行状态转变为就绪态
        }
        System.out.println(SUM);
    }
}
