package Animal;

public class Duck3 {

    private String Name;
    private Integer age;
    private Duck3 next;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Duck3 getNext() {
        return next;
    }

    public void setNext(Duck3 next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Duck3{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                ", next=" + next +
                '}';
    }
}
