package abstractLearn;

// Shape 为抽象类，与普通类基本相同，无法实例化
// 可以包括抽象方法，普通类中不能有抽象方法
abstract public class Shape {
    // 抽象方法没有方法体
    // 作用：被继承，被重写
    abstract public void draw();
}
