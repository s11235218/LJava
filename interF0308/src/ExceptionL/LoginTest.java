package ExceptionL;

import ExceptionL.Exception.PasswordException;
import ExceptionL.Exception.UserException;

public class LoginTest {
    // 自定义异常
    // 创建出来的异常类，没有实质性代码，为了增加一些异常类型，更灵活进行异常处理
    // 如果继承自 Exception ，受查异常（建议）
    // 如果继承自 RuntimeException ，非受查异常
    private static String username = "zhangsan";
    private static String password = "123456";

    public static void main(String[] args) throws UserException, PasswordException {
        // 用户输入
        login("zhangsan", "11111");
    }

    public static void login(String username, String password) throws UserException, PasswordException {
        if(!LoginTest.username.equals(username)){
            // 错误处理
            throw new UserException("用户名错误");
        }
        if(!LoginTest.password.equals(password)){
            // 错误处理
            throw new PasswordException("密码错误");
        }
        System.out.println("登陆成功！");
    }
}