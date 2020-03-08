package Library.user;

import Library.action.*;

import java.util.Scanner;

public class Admin extends User {
    public Admin(String name) {
        this.name = name;
        this.actions = new IAction[]{
                new ExitAction(),
                new FindAction(),
                new AddAction(),
                new DelAction(),
                new DisplayAction(),
        };
    }

    @Override
    public int menu() {
        System.out.println("=====================");
        System.out.println("欢迎 " + this.name + " 使用图书馆管理系统，您是管理员身份");
        System.out.println("1.查询图书");
        System.out.println("2.添加图书");
        System.out.println("3.删除图书");
        System.out.println("4.显示所有图书");
        System.out.println("0.退出");
        System.out.println("=====================");
        System.out.println("请输入您的选择：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

}
