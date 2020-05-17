package learn3;

// 有一个共享变量，初始0 启动20个线程 每个线程循环10000次，每次循环将共享变量++
public class UnSafeThread {

    private static int SUM;

    // 线程不安全
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        SUM++;
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
