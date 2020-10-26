import Serein.Duck;
import Serein.Duck2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applications.xml");

        // 通过bean的名称获取bean对象，bean名称就是xml中bean对象的id
        String s1 = (String)context.getBean("Serein");
//        String s2 = (String)context.getBean("java.lang.String#0");
        System.out.println(s1);
//        System.out.println(s2);

        // 通过类型获取bean对象，如果该类型有多个对象，就会报错；只支持一个该类型的对象
//        String s3 = context.getBean(String.class);
//        System.out.println(s3);

        Duck duck = (Duck) context.getBean("duck1");
        System.out.println(duck);

        Duck2 duck1 = (Duck2) context.getBean("duck2");
        System.out.println(duck1);


    }
}