package learn4;

public class SynchronizedDemo {
    // 1. 静态方法上
    public static synchronized void test1(){

    }

    // 2. 实例方法上
    public synchronized void test2() {

    }

    // 3. 代码块
    public static void main(String[] args) {
        /**
         * 1. 对象锁🔒：每个对象都有对象头，包含锁
         * 2. synchronized 获取对象锁的操作：
         *     （1） 申请对象锁
         *     （2） 申请成功：进入代码块
         *     （3） 申请失败：进入一个同步队列阻塞
         */
        Object o = new Object();
        synchronized (o) {

        }
    }
}
