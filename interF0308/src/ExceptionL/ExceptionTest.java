package ExceptionL;

import java.util.Scanner;

public class ExceptionTest {
    // 异常处理流程
    // 1. 程序先执行 try 中的代码
    // 2. 如果 try 中代码出现异常，结束 try中其他代码。检查当前异常和 catch 中声明的异常类型是否匹配
    // 3. 如果找到匹配的异常类型，这个异常就被当前 catch 捕获，就执行 catch 中代码
    // 4. 如果没找到匹配的异常类型，这个异常就会沿着调用栈，传递给方法的调用者
    // 5. 无论是否找到匹配的类型 catch 语句，finally 都一定在方法结束前被执行
    // 6. 如果上层调用者没有合适 catch 代码，异常还是要继续传递给调用者
    // 7. 如果一直向上传到 main 方法，都没有合适 catch 语句，最终交给 JVM
    public static void main(String[] args) {
        System.out.println(10 / 0);
        int[] arr = {1, 2, 3, 4 ,5};
        System.out.println(arr[100]);

        // 异常是程序运行时出现错误之后的通知机制
        // 如果程序正常结束，进程退出码是 0
        // 如果是出现异常结束，此时退出码非 0

        // 代码中产生的异常，会沿着调用栈，向调用者方向传递
        // 直到传递到某个方法具有合适的 try catch 语句（catch 中要捕获的异常类型和实际）来捕获异常
        // 如果一直传递到 main 方法都没有合适的 try catch ，交给 JVM 处理（程序强制终止，并打印出异常调用栈）
        try{
            func1();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        System.out.println("结束日志");

        Test1();
        System.out.println(func3());

        Scanner sc = new Scanner(System.in);
        try{
            int num = sc.nextInt();
            System.out.println(num);
        } catch(Exception e){
            e.printStackTrace();
        }finally {
            sc.close();
        }

        // 当 try catch 执行完后，会自动执行 try() 中的 close 方法
        // try() 中的对象，必须实现Closeable 接口
//        try(Scanner sc = new Scanner(System.in)){
//            int num = sc.nextInt();
//            System.out.println(num);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
    }

    public static void Test1(){
        try{
            int[] arr = {1, 2, 3};
            System.out.println(arr[100]);

            String str = null;
            System.out.println(str.length());
            System.out.println("执行完 str.length()");
        } catch(NullPointerException | ArrayIndexOutOfBoundsException e) {
            // 使用精准类型捕捉异常，避免误伤
            System.out.println("捕捉到异常");
            return;
        } finally {  // 无论 try 中是否触发异常，都一定会执行 finally 中的代码，通常用来收尾
            // 文件关闭、释放资源、释放锁...
            // 保证收尾工作可靠
            System.out.println("finally 中的代码");
        }
        System.out.println("一行日志");
    }

    public static void func1(){
        func2();
    }

    public static void func2(){
        // IDEA surround 功能：把某个代码包裹一些其他逻辑（ctrl + alt + t）
        String str = null;
        System.out.println(str.length());
    }

    public static int func3(){
        // 如果 try catch 中有 return，finally 会在 return 生效之前就执行
        // 不要在 finally 中写 return
        try{
            return 1;
        } catch (NullPointerException e) {
            return 2;
        } finally {
            return 3;
        }
    }
}
