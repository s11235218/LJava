package Thread2;

public class MultiThreadVsSingleThread {

    private static int SUM;

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SUM++;
                }
            }).start();
        }

        for (int i = 0; i < 20; i++) {
            SUM++;
        }
    }
}
