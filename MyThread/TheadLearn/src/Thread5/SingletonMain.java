package Thread5;

public class SingletonMain {
    public static void main(String[] args) {
//        Singleton singleton = Singleton.getInstance();
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton singleton = Singleton.getInstance();
                }
            }).start();
        }
    }
}
