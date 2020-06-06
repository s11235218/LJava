package Thread2;

public class MyThread extends Thread {
    @Override
    // 任务代码描述
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        new MyThread().start();
    }
}
