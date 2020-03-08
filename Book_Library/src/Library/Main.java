package Library;

import Library.book.BookList;
import Library.user.Admin;
import Library.user.NormalUser;
import Library.user.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. 准备数据
        BookList bookList = new BookList();
        // 2. 创建用户，登录
        User user = login();
        // 3. 进入主循环
        while(true){
            // 4. 循环内部调用 menu 方法
                int choice = user.menu();
            //5. 根据用户输入 choice 决定执行哪个 IAction 完成操作
            user.doAction(choice, bookList);
        }
    }

    public static User login(){
        // 提示用户进行登录
        System.out.println("请登陆系统！");
        System.out.println("请输入您的姓名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("请输入您的身份：1表示管理员；2表示普通用户");
        int identify = scanner.nextInt();
        if(identify == 1){
            return new Admin(name);
        }
        return new NormalUser(name);
    }
}
