package Library.action;

import Library.book.Book;
import Library.book.BookList;

import java.util.Scanner;

public class AddAction implements IAction{
    @Override
    public void work(BookList bookList) {
        System.out.println("执行添加图书操作");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入书名：");
        String name = sc.next();
        System.out.println("请输入作者：");
        String author = sc.next();
        System.out.println("请输入价格：");
        int price = sc.nextInt();
        System.out.println("请输入类型：");
        String type = sc.next();

        Book book = new Book(name, author, price, type, false);
        // 尾插
        int size = bookList.getSize();
        bookList.setBook(size, book);
        bookList.setSize(size + 1);
        System.out.println("新增图书成功！");
    }
}
