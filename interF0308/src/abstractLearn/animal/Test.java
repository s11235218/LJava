package abstractLearn.animal;

import shape.Rectangle;

public class Test {
    public static void main(String[] args) {
        Frog frog = new Frog("小青蛙");
        walk(frog);

        Cat cat = new Cat("小猫咪");
        walk(cat);

        Insect insect = new Insect("昆虫");
        walk(insect);
        fly(insect);

        Robot robot = new Robot();
        walk(robot);
    }

    // 不是所有动物都会散步
    public static void walk(IRunning animal){
        animal.run();
    }

    public static void fly(IFlying animal){
        animal.fly();
    }
}
