package Thread6;

public class Test {

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("送快递到BJ, A");
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("送快递到XJ, B");
            }
        });
        System.out.println("在做事情");
    }
}
