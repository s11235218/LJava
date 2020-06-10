package Thread2;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("Thread baby");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        // 等待线程死亡
        t.join(2000); // 调整参数 不传、1000、5000
        System.out.println("main");
    }
}
