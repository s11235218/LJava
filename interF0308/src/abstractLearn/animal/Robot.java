package abstractLearn.animal;

public class Robot implements IRunning {
    public Robot() {
    }

    @Override
    public void run() {
        System.out.println("机器人使用轮子跑");
    }
}
