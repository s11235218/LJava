package Thread2;

public class ThreadYield {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
        // 等待new Thread所有线程执行完毕，否则一直等待 (线程让步)
        while (Thread.activeCount() > 1) {//用调试的方式运行
            Thread.yield();//将当前线程由运行态-->就绪态
        }
        System.out.println(Thread.currentThread().getName());
    }
}
