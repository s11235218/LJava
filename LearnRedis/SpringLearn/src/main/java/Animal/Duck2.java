package Animal;

public class Duck2 {

    private String Name;
    private Integer age;

    public Duck2(String n, Integer a) {
        Name = n;
        this.age = a;
    }

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

    @Override
    public String toString() {
        return "Duck{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                '}';
    }
}
