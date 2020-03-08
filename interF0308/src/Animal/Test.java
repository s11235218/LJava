package Animal;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Animal animal = new Animal("小白");
        //Animal animal1 = animal;
        Animal animal1 = animal.clone();
        //是否引用同一个对象
        System.out.println(animal == animal1);
    }
}
