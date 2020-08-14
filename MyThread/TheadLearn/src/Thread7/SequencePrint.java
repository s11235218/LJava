package Thread7;

/**
 * 有三个线程，分别打印A，B，C
 * 打印结果：循环打印ABC，打印十次
 * */

public class SequencePrint {
    private static volatile int INDEX;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        synchronized (SequencePrint.class) {
                            while (INDEX % 3 != 0) {
                                SequencePrint.class.wait();
                            }
                            INDEX++;
                            System.out.println("A");
                            SequencePrint.class.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        synchronized (SequencePrint.class) {
                            while (INDEX % 3 != 1) {
                                SequencePrint.class.wait();
                            }
                            INDEX++;
                            System.out.println("B");
                            SequencePrint.class.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        synchronized (SequencePrint.class) {
                            while (INDEX % 3 != 2) {
                                SequencePrint.class.wait();
                            }
                            INDEX++;
                            System.out.println("C");
                            SequencePrint.class.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
