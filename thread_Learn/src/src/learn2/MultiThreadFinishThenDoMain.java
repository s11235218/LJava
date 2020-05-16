package learn2;

// 同时运行多个线程 等所有执行完毕 再执行 main 后边的方法
public class MultiThreadFinishThenDoMain {
    public static void main(String[] args) throws InterruptedException {
        // 目前 main 先打印 0-19 随即同时打印
        // 期望结果，先打印 0-19 ，全部打印完之后 在打印 main
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
