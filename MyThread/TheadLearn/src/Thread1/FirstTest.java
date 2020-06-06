package Thread1;

public class FirstTest {
    public static void main(String[] args) throws InterruptedException {

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(9999999999999l);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "FirstTest1").start();
//        Thread.sleep(9999999999999l);

//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(9999999999999l);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "FirstTest1");
//        t.run();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("FirstTest1");
            }
        }, "FirstTest1").start();
        System.out.println("main");
    }
}
