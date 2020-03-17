package Animal;

class B{
    public B(){
        func();
    }

    public void func(){
        System.out.println("B.func");
    }
}

class D extends B{
    private int num = 1;

    @Override
    public void func() {
        System.out.println("D.func " + num);
    }
}

public class BadCode {
    public static void main(String[] args){
        // 创建对象过程
        // 1. 先判断D是否在内存中，若不在，通过类加载器找到该类的. class文件，加载内容到内存中（方法区）
        // 2. 类加载时会执行这个类中的static代码块中内容
        // 3. 根据该类描述的信息，申请内存空间（申请大小与该类密切相关）
        // 4. 申请到的内存空间先初始化全0操作
        // 5. 创建父类对象（执行父类代码中的就地初始化，构造块，构造方法）
        // 6. 继续构造子类对象（执行子类代码中的就地初始化，构造块，构造方法）
        D d = new D();
    }
}
