package MyIO1;

import java.util.Scanner;

/**
 * Java中IO流的分类：
 *    1.字符（字符串）、字节流（二进制）：Stream字节流、OutputStream字节流、Writer/Reader字符流
 *    2.输入输出：Input/Reader输入、Output/Writer输出
 *    3.文件：File的IO类，作为文件操作的IO流
 *    4.二进制数组操作：ByteArray
 *    5.Java对象：Object
 *    3.特殊的：PrintWriter表示打印输出到某个设备
 *             Scanner表示接受某个设备的输入（接受控制台输入时，从System.in键盘作为输入设备）
 *             StringWriter/StringReader
 *             
 *
 * @author Sssserein
 * @creed: Talk is cheap,show me the code
 * @date 2020/9/21 9:53
 */


public class ScannerTest {

    /**
     * 1.理解要求--多个测试用例，每个测试用例完成某一块业务逻辑
     * 2.每个测试用例：先输入一行数字；
     *                再输入一行数字（一组数字）
     * @return
     * @author Sssserein
     * @creed: Talk is cheap,show me the code
     * @date 2020/9/20 11:49
     */
    public static void main(String[] args) {
        // 10组测试用例
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            // 每个测试用例要测试的问题
            /**
             *  多线程阻塞也是需要满足一定条件：
             *       synchronized满足线程对象锁竞争成功；
             *       join当前线程执行完毕、到时间；
             *       sleep休眠一定时间；
             *       wait满足其他线程通知
             *  IO：
             *  1.都是阻塞式方法：造成当前线程阻塞
             *  2.满足一定条件才返回
             *       hasNext满足换行符或空格等特殊字符
             *       hasNextLine满足换行符
             *       hasNextInt读取到不满足Int数值的字符
             * @return void
             * @author Sssserein
             * @creed: Talk is cheap,show me the code
             * @date 2020/9/20 12:14
             */

//            // IO流中数据，进行读/写操作只能执行一次
//            while (sc.hasNext()) { // 非读取数据的操作
//                // sc.next();
//                System.out.println(sc.next());// 读取操作
//            }

            int count = sc.nextInt(); // 读取第一行数字
            for (int j = 0; j < count; j++) {
                int num = sc.nextInt();
                System.out.println(num);
            }
        }
    }
}