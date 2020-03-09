package Library.action;

import Library.book.Book;
import Library.book.BookList;

import java.util.Scanner;

public class DelAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("执行删除图书操作");
        System.out.println("请输入要删除的书名:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                for (int j = i; j < bookList.getSize(); j++) {

                }
            }
        }
    }
}
