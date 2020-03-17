package Animal;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Animal animal = new Bird("小黑");
        animal.eat("谷子");



//        //Animal animal1 = animal;
//        Animal animal1 = animal.clone();
//        //是否引用同一个对象
//        System.out.println(animal == animal1);
    }

    public static void Test1(){
        Animal animal1 = new Animal("小白");
        animal1.eat("bread");
        //动态绑定，执行结果看bird对应什么类型对象
//        Animal1 bird = new Bird("haha");
//        bird.eat("谷子");

        animal1 = new Bird("haha");
        animal1.eat("谷子");

//        Animal animal = new Bird("球球");
//        // 向下转型,有风险，取决于实际指向的类型
//        Bird bird = (Bird)animal;
//        bird.fly();

        Animal animal2 = new Cat("小黑");
        // 向下转型，风险抛出异常ClassCastException
        if(animal2 instanceof Bird){
            ((Bird) animal2).fly();
            Bird bird = (Bird)animal2;
            bird.fly();
        }else{
            System.out.println("animal2不是Bird类型");
        }
    }
}
