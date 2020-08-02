package Thread5;

/**线程状态
 * 阻塞：竞争失败的线程全部放入同步队列
 * 唤醒：JVM查询同步队列竞争这个对象锁失败的线程，全部唤醒，重新竞争
 *
 * */

/**volatile 作用：
 * 1.禁止指令重排序
 * 2.建立内存屏障
 *
 * synchronized的有序性：指线程之间运行同步代码块是按序执行的
 * */

/**双重校验锁单例模式写法：
 * 1.volatile关键字修饰变量
 * 2.私有的构造方法
 * 3.双重校验锁的写法保证线程安全
 **/

public class Singleton {
    public Singleton() {
    }

//    // 饿汉模式
//    private static Singleton SINGLETON = new Singleton();
//    public static Singleton getInstance() {
//        return SINGLETON;
//    }

//    // 懒汉模式
//    private static Singleton SINGLETON;
//    public static Singleton getInstance() {
//        if (SINGLETON == null) {
//            SINGLETON = new Singleton();
//        }
//        return SINGLETON;
//    }

    // 双重校验锁
    private static volatile Singleton SINGLETON;
    // 假设不使用volatile，但能保证变量可见性
    // 如果不保证重排序会出现什么问题?d
    public static Singleton getInstance() {
        // 提高效率：变量使用volatile也可以保证可见性
        if (SINGLETON == null) {
            synchronized (Singleton.class) {
                // 为保证单例：返回同一个对象
                if (SINGLETON == null) {
                    // new 对象分解为三条指令：前两个指令是new操作
                    // 1.分配内存空间
                    // 2.初始化对象
                    // 3.赋值给变量
                    SINGLETON = new Singleton();
                }
            }
        }
        return SINGLETON;
    }
}