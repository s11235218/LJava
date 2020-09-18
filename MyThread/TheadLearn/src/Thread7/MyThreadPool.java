package Thread7;

import Thread6.MyBlockingQueue;

public class MyThreadPool {

    private MyBlockingQueue<Runnable> queue;

    public MyThreadPool(int size, int capacity) {
        // 创建正式员工
        queue = new MyBlockingQueue<>(capacity);
        for (int i = 0; i < size; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {// 一直执行
                            // 从仓库取包裹：
                            // 1.成功取出，方法返回
                            // 2.仓库里取不出包裹（其他员工正在取，阻塞在synchronized代码行，仓库没有包裹wait方法阻塞）
                            Runnable task = queue.take();
                            // 当前线程（正式员工送快递）通过实例方法调用执行任务
                            task.run();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public void execute(Runnable task) {
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(5, 100);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("B");
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("C");
            }
        });
    }
}
