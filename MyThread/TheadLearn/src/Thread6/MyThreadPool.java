package Thread6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPool {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("送快递到BJ, A");
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("送快递到XJ, B");
            }
        });

        System.out.println("在做事情");
    }
}
