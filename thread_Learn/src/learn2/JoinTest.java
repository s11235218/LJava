package learn2;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程");

//                try {
//                    Thread.sleep(3000);
//                    System.out.println("子线程");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });
        thread.start();
        thread.join(1000);
        System.out.println("main");
    }
}
