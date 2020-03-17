package abstractLearn;

public class Test {
    public static void main(String[] args) {
        // 接口使用过程中，也以来“多态”这样的语法
        // 与单继承无关，可实现多个接口
        IShape shape = new Circle() ;
        shape.draw();
    }
}
