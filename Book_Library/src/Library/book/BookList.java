package Library.book;

public class BookList {
    // 顺序表
    private Book[] books = new Book[100];
    // 数组中有效元素
    private int size = 0;

    public BookList() {
        books[0] = new Book("三国演义", "罗贯中", 100,
                "古典名著", false);
        books[1] = new Book("斑羚飞渡", "沈石溪", 60,
                "儿童文学", false);
        books[2] = new Book("追风筝的人", "卡勒德·胡赛尼", 80,
                "外国文学", false);
        size = 3;
    }

    public Book getBook(int pos){
        return books[pos];
    }

    public void setBook(int pos, Book book){
        books[pos] = book;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
