package learn2;

public class MultiThreadVsSingleThread {
    private static int SUM;

    public static void main(String[] args) {
//        for (int i = 0; i < 20; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    SUM++;
//                }
//            }).start();
//        }

//        for (int i = 0; i < 20; i++) {
//            new Thread(()->{
//                SUM++;
//            }, "练习").start();
//        }

//        new Thread(()-> {
//            for(int i = 1 ; i<100 ; i++){
//                System.out.println("It is a lambda function!");
//            }
//
//        }).start();


        for (int i = 0; i < 20; i++) {
            SUM++;
        }
    }
}
