package Thread2;

public class StartVsRun {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("MyFirst");
            }
        }, "子线程").start();
        System.out.println("main");

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
            }).start();
        }
    }
}
