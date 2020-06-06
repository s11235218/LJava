package Thread2;

public class MyRunnable implements Runnable {
    @Override
    // 任务描述
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();
    }
}
