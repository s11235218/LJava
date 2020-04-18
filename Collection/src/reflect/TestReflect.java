package reflect;

class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void eat(String food) {
        System.out.println(this.name + "eating" + food);
    }
}

public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1. 如何获取类对象
        // 1). 通过字符串获取到类 参数是类的全限定类名
        //     通过字符串获取 可以是控制台输入、读取文件、网络获取
        Class catClass = Class.forName("reflect.Cat");

        // 2). 通过实例获取 实例 getClass 方法获取
        Cat cat = new Cat("hehe");
        Class catClass2 = cat.getClass();

        // 得到的类对象在内存只有一份
        System.out.println(catClass == catClass2);

        // 3) 通过类获取
        Class catClass3 = Cat.class;

    }
}
