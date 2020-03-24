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
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                break;
            }
        }
        if(i >= bookList.getSize()){
            System.out.println("删除失败！");
        }
        // 尾删 size--; 中间位置删除需要搬运
        // 但可以把删除中间元素转换为删除尾部元素
        int size = bookList.getSize();
        bookList.setBook(i, bookList.getBook(size - 1));
        bookList.setSize(size - 1);
        System.out.println("删除成功！");
    }
}
