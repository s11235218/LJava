package Animal;

public class Animal implements Cloneable{
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat(String food){
        System.out.println("Animal.eat");
        System.out.println(this.name + "正在吃" + food);
    }

    @Override
    public Animal clone() throws CloneNotSupportedException {
        // Object.clone 就在深拷贝

        return (Animal)super.clone();
    }
}
