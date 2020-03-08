package Library.action;

import Library.book.Book;
import Library.book.BookList;

import java.util.Scanner;

public class ReturnAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("执行归还图书操作");
        System.out.println("请输入你要还的书名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                if (book.isBorrowed()) {
                    book.setBorrowed(false);
                    System.out.println("还书成功！");
                    return;
                }
            }
        }
        System.out.println("还书失败！");
    }
}
