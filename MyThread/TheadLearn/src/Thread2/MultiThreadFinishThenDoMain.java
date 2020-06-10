package Thread2;

public class MultiThreadFinishThenDoMain {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            final int j = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(j);
                }
            });
            t.start();
            threads[i] = t;
        }
        for (int i = 0; i < 20; i++) {
            threads[i].join();
        }
        System.out.println("main");
    }
}
