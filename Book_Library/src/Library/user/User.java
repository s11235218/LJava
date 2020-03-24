package Library.user;

import Library.action.IAction;
import Library.book.BookList;

abstract public class User {
    protected String name;
    protected IAction[] actions = null;

    // 打印命令行菜单
    abstract public int menu();

    // 公共的 每种用户都需要的
    public void doAction(int choice, BookList bookList){
        actions[choice].work(bookList);
    }
}
