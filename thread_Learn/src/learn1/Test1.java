package learn1;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(9999999999999L);

        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(9999999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "练习1").start();

        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(9999999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "练习1").start();
        Thread.sleep(9999999999999L);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(9999999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "练习1");
        t.run();

        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("练习1");
            }
        }, "练习1").start();
        System.out.println("main");
    }
}
