package ExceptionL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionTest1 {
    // Java 异常体系
    // 1. 最顶层的父类 Throwable，派生出 Error （JVM 内部使用）Exception （程序员使用）
    // 2. 当前异常分为两类
    //     a. Error 和 Runtime Exception，非受查异常（没以下限制）
    //     b. 剩下都是受查异常（当代码中可能出现的异常，显示处理：try catch / throws）
    public static void main(String[] args) throws FileNotFoundException {
        // throw 抛出一个异常对象
        // 在合适时机抛出合适类型的异常（throw 关键字）
        // 创建异常对象时，可借助构造方法，写入提示性日志
//        try {
//            int result = divide(10, 0);
//        } catch (Exception e) {
//            System.out.println("捕捉到异常了");
//            e.printStackTrace();
//        }
        String res = readFile();
        System.out.println(res);
    }

    public static String readFile() throws FileNotFoundException {
        // 创建一个 File 对象
        File file = new File("d:/test.txt");
        // Scanner 完成读文件操作
        try {
            Scanner scanner = new Scanner(file);
            return scanner.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("捕捉到异常！");
        }
        return "";
    }

    public static int divide(int x, int y) throws Exception {
        if(y == 0){
            throw new Exception("除数为 0");
        }
        return x / y;
    }
}
