package Animal;

public class Bird extends Animal {
    private int age = 2;

    public Bird(String name) {
        //调用父类构造方法
        super(name);
        //super.eat("meat");
    }
    @Override
    public void eat(String food){
        System.out.println("Bird.eat");
        System.out.println(super.name + "正在吃" + food);
    }

    public void fly(){
        System.out.println(this.name + "正在飞");
    }
}
