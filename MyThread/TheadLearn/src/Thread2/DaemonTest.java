package Thread2;

public class DaemonTest {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(99999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "FirstTest");
        // 设置守护线程：后台进程
        // 非守护线程：工作线程
        t.setDaemon(true);
        t.start();
    }
}
