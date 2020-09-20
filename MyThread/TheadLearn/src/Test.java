import java.util.Scanner;

/**多线程使用场景：
 * CPU执行指令：1.计算指令 2.逻辑指令 3.数据拷贝
 * 某Java进程，程序可能偏向 1.计算密集型任务 2.IO密集型任务
 * 1. 执行比较耗时的操作时，使用多线程
 * 2. 执行阻塞代码时，会对当前线程造成阻塞
 * */

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
        }
        System.out.println("已经启动！");

    }
}
