import Animal.Duck;
import Animal.Duck2;
import Animal.Duck3;
import Animal.DuckStore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Spring开启容器的方式：ApplicationContext 应用上下文（可以配置并管理Bean对象，及其他工作）
        // ClassPathXmlApplicationContext根据class path路径，指定一个xml文件，
        //       并根据配置文件完成配置工作（如Bean实例化对象）
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applications.xml");

        String serein = (String) context.getBean("serein");
        String serein2 = (String) context.getBean("java.lang.String#0");
        System.out.println(serein);

        // 该类型有多个对象，报错
        // context.getBean(String.class);

        Duck duck1 = (Duck) context.getBean("duck1");
        System.out.println(duck1);

        Duck2 duck2 = (Duck2) context.getBean("duck2");
        System.out.println(duck2);

        Duck3 duck3 = (Duck3) context.getBean("duckList");
        System.out.println(duck3);

        DuckStore duckStore = (DuckStore) context.getBean("store");
        System.out.println(duckStore);
    }
}