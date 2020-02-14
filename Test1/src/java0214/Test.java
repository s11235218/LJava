package java0214;

public class Test {
    public static void main(String[] args){
        Student student1 = new Student();
        student1.id = "100000";
        student1.name = "张三";
        student1.score = 5.0;
        student1.print();

        Student2 student2 = new Student2();
        Student2.id = "300000";
        Student2.name = "王五";
        Student2.score = 3.0;
        Student2.print();

        Student3 student3 = new Student3("500000","赵六", 3.4);

        System.out.println(student3.getId());
    }
}
