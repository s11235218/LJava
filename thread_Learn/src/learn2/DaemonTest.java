package learn2;

public class DaemonTest {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(9999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "练习");
        t.setDaemon(true);
        t.start();
    }
}
