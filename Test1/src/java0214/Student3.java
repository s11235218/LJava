package java0214;

public class Student3 {
    //成员变量/字段/属性
    private String id = "";
    private String name = "";
    private double score = 0.0;

    public Student3(){
        id = "200000";
        name = "李四";
        score = 4.5;
        System.out.println("构造方法");
    }

    public Student3(String id, String name, double score){
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    //static
    public void print(){
        System.out.println("id: " + this.id + ", name: " + this.name + ", score: " + this.score);
    }

    //静态代码块
//    static{
//        id = "100000";
//        name = "张三";
//        score = 5.0;
//    }

    //构造块
    {
        id = "100000";
        name = "张三";
        score = 5.0;
    }
}
