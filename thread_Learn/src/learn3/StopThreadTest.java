package learn3;

public class StopThreadTest {

    private volatile static boolean IS_STOP;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!IS_STOP) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Thread.sleep(2000);
        // 特殊情况，中断线程
        IS_STOP = true;
    }
}
