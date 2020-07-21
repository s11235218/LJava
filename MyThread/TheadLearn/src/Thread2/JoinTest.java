package Thread2;

/**线程等待：
 * （1） join
 * （2) 结合activeCount() + yield() 使用
 *         while (Thread.activeCount() > 1) {//用调试的方式运行
 *             Thread.yield();//将当前线程由运行态-->就绪态
 *         }
 * */

public class JoinTest {

    public static void without() throws InterruptedException {
        // 打印顺序 main--->thread-0
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t.start();
        t.join();
        System.out.println(Thread.currentThread().getName());
    }

    public static void withoutSleep() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t.start();
        t.join(2000);
        System.out.println(Thread.currentThread().getName());
    }

    public static void withSleep() throws InterruptedException {
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
        t.join(2000); // 调整参数 不传、1000、5000
        System.out.println("main");
    }

    public static void main(String[] args) throws InterruptedException {
        // 等待线程死亡
        // 当前线程：代码执行的时候，所在的线程
        // t线程：线程引用对象
        // 当前线程进行阻塞（运行态-->阻塞态）等待（满足一定条件），t线程（不做任何处理，让t执行运行）
        // 条件：（哪个条件先执行完，先满足）
        //       a.传入时间（时间值+时间单位毫秒）
        //       b.线程引用对象执行完毕

    }
}
