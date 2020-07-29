package review.se;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Child());
        System.out.println(new Child());
    }
}

class Parent{
    static{
        System.out.println("Parent静态代码块");
    }

    Parent(){
        System.out.println("Parent构造方法");
    }
    {
        System.out.println("Parent实例代码块");
    }
}

class Child extends Parent{
    static{
        System.out.println("Child静态代码块");
    }

    Child(){
        System.out.println("Child构造方法");
    }
    {
        System.out.println("Child实例代码块");
    }
}