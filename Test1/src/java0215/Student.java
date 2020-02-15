package java0215;

public class Student {
    private String id = "100000";
    private String name = "zhang";

    public void print(){
        System.out.println(this.id + ", " + this.name);
    }

    @Override
    public String toString(){
        System.out.println("执行toString方法");
        return id + ", " + this.name;
    }

    {
        //构造块
        System.out.println("构造块");
    }

    //静态块
    static
    {
        System.out.println("静态块");
    }

    //构造方法
    public Student(){
        System.out.println("构造方法");
    }
}
