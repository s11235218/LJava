package Thread7;

/*动态代码*/
public class SequencePrint1 {

    public static void print(String[] array, int count) {
        Print.INDEX = 0;
        for (int i = 0; i < array.length; i++) {
            final int finalI = i;
            new Thread(new Print(array, count, finalI)).start();
        }
    }

    private static class Print implements Runnable {

        private static volatile int INDEX;

        private String[] array;
        private int count;
        private int finalI;


        public Print(String[] array, int count, int finalI) {
            this.array = array;
            this.count = count;
            this.finalI = finalI;
        }

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
                            System.out.println("=" + j);
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
        print(new String[]{"E", "B", "C", "D", "G", "F"}, 10);
    }
}
