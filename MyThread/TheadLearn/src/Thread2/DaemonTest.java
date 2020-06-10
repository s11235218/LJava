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
        t.setDaemon(true);
        t.start();
    }
}
