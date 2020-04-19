package reflect;

import java.lang.reflect.Field;
import java.util.Scanner;

class Animal {
    public void eat(String food) {

    }
}

class Cat extends Animal {
    private String name;

    public Cat() {
        this.name = "小猫";
    }

    public Cat(String name) {
        this.name = name;
    }

    public void eat(String food) {
        System.out.println(this.name + " 正在吃 " + food);
    }
}

class Bird extends Animal {
    private String name;

    public Bird() {
        this.name = "haha";
    }

    public Bird(String name) {
        this.name = name;
    }

    public void eat(String food) {
        System.out.println(this.name + " 正在吃 " + food);
    }

}

public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
//        // 1. 如何获取类对象
//        // 1). 通过字符串获取到类 参数是类的全限定类名
//        //     通过字符串获取 可以是控制台输入、读取文件、网络获取
//        Class catClass = Class.forName("reflect.Cat");
//
//        // 2). 通过实例获取 实例 getClass 方法获取
//        Cat cat = new Cat("hehe");
//        Class catClass2 = cat.getClass();
//
//        // 得到的类对象在内存只有一份
//        System.out.println(catClass == catClass2);
//
//        // 3) 通过类获取
//        Class catClass3 = Cat.class;

        // 2. 通过类对象创建实例
        //  平时通过 new 创建实例
        //  catClass 表示 Cat 类的类对象 也是 Cat 类的图纸
        //  newInstance 创建对应实例
        //  以下代码运行出现异常，Cat 没有无参数构造方法造成的

//        Scanner scanner = new Scanner(System.in);
//        String className = scanner.next();
//        System.out.println("您要创建的实例类型为：" + className);
//
//        Class animalClass = Class.forName("reflect.Cat");
//        Animal cat = (Animal) animalClass.newInstance();
//        cat.eat("鱼");

        // 3. 通过反射获取/修改属性（可以修改 private 属性）
        Class catClass = Class.forName("reflect.Cat");
        // Cat 类包含 name 属性 private
        // catClass 类对象是整个类的图纸 此处想关注图纸上一个局部信息
        // 通过 getDeclaredField 能得到局部内容 通过 Field 对象F表示
        Field field = catClass.getDeclaredField("name");

        Cat cat = new Cat();
        // 拿出图纸的局部信息 拆开看 cat 对象
        String name = (String) field.get(cat); // 相当于 cat.name
        System.out.println(name);
    }
}
