package Library.action;

import Library.book.BookList;

public class ExitAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("成功退出系统！");
        System.exit(0);
    }
}
