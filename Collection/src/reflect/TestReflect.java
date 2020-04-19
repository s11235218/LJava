package reflect;

import java.lang.reflect.*;
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
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
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
//        Class catClass = Class.forName("reflect.Cat");
        // Cat 类包含 name 属性 private
        // catClass 类对象是整个类的图纸 此处想关注图纸上一个局部信息
        // 通过 getDeclaredField 能得到局部内容 通过 Field 对象F表示
//        Field field = catClass.getDeclaredField("name");
//        field.setAccessible(true);
//
//        Cat cat = new Cat();
//        // 拿出图纸的局部信息 拆开看 cat 对象
//        // 修改
//        field.set(cat, "喵喵"); // cat.name = "喵喵"
//        String name = (String) field.get(cat); // 相当于 cat.name
//        System.out.println(name);

//        // 4. 通过反射获取到类中的方法
//        Class catClass = Class.forName("reflect.Cat");
//        // 方法是可以重载 可以通过后续变长参数列表指定，要获取那个版本 eat
//        // 下列代码意思 获取到只有一个参数 且类型为String 的eat 方法
//        Method method = catClass.getMethod("eat", String.class);
//
//        Cat cat = new Cat();
//        method.invoke(cat, "猫粮");

        // 5. 获取构造方法 借助构造方法实例化
        Class catClass = Class.forName("reflect.Cat");
        // 获取到 Cat 类中 只有一个参数且类型为 String 的构造方法
        Constructor constructor = catClass.getConstructor(String.class);
        Cat cat = (Cat) constructor.newInstance("小黑");
        cat.eat("鱼");
    }
}
