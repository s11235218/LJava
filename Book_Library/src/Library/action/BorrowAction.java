package Library.action;

import Library.book.Book;
import Library.book.BookList;

import java.util.Scanner;

public class BorrowAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("执行借书操作");
        System.out.println("请输入你要借的书名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                if(!book.isBorrowed()){
                    book.setBorrowed(true);
                    System.out.println("借书成功！");
                    return;
                } else{
                    continue;
                }
            }
        }
        System.out.println("没找到匹配的书籍！");
    }
}
