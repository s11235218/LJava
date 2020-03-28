import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) {
        //System.out.println(10 / 0);
//        int[] arr = {1, 2, 3, 4 ,5};
//        System.out.println(arr[100]);
        // 异常是程序运行时出现错误之后的通知机制
        // 如果程序正常结束，进程退出码是 0
        // 如果是出现异常结束，此时退出码非 0
//        try{
//            func1();
//        }catch(NullPointerException e){
//            e.printStackTrace();
//        }
//        System.out.println("结束日志");
        //Test1();
        //System.out.println(func3());

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
