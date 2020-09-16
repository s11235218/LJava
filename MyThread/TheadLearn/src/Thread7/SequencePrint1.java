package Thread7;

/*动态代码*/
public class SequencePrint1 {

    public static void print(final String[] array, final int count) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            final int finalI = i;
            new Thread(new Print()).start();
        }
    }

    private static class Print implements Runnable {

        @Override
        public void run() {
            try {
                for (int j = 0; j < count; j++) {
                    synchronized (SequencePrint.class) {
                        while (INDEX % array.length != finalI) {
                            SequencePrint.class.wait();
                        }
                        INDEX++;
                        System.out.print(array[finalI]);
                        if (finalI == array.length - 1){
                            System.out.println("====" + j);
                        }
                        SequencePrint.class.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        print(new String[]{"A", "B", "C", "D"}, 10);
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        print(new String[]{"A", "B", "C", "D"}, 10);

    }
}
