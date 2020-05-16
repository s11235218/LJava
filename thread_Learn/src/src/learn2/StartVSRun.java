package learn2;

public class StartVSRun {
    public static void main(String[] args) {
//        // 1. new Runnable 创建一个匿名内部类 只是类的定义
//        // 2. new Thread 的第二个构造参数 “子线程”
//        // 3. 调用 new Thread 对象的 start
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("练习2");
//            }
//        }, "子线程").start();
//
////        // lambda 表达式
////        new Thread(() -> {
////            System.out.println("练习2");
////        }, "子线程").start();
//        System.out.println("main");

        // 练习2
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 虽然是同一行代码，但在不同线程中运行也可以表现出并发（时间片调度）、并行
                    System.out.println(Thread.currentThread().getName());
                }
            }, "练习 " + i).start();
        }
    }
}
