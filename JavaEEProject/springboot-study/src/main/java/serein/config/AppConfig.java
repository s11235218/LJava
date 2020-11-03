package serein.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import serein.config.interceptor.LoginInterceptor;
import serein.model.User;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig implements WebMvcConfigurer { // web框架，执行初始化工作时，会调用接口方法

    /**
     * 添加web配置：添加拦截器（根据路径拦截）
     *     /*：代表一级路径，如/user/*，可以匹配到/user/abc，不能匹配到/user/abc/1
     *     /**：代表多级路径
     * 注意：静态资源也会被拦截
     *
     * @param registry
     *
     * @author Sssserein
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/3 20:29
     */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 实现用户会话管理功能
        registry.addInterceptor(new LoginInterceptor())// 链式方法调用，当前类型的方法，返回值就是this
                .addPathPatterns("/user/**")// 添加拦截的路径
                .excludePathPatterns("/user/login");// 添加要排除的路径
    }

    @Bean
    public Map<Integer, Integer> test() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 200);
        map.put(2, 400);
        return map;
    }

    @Bean
    public User user1() {
        User u = new User();
        u.setName("小新");
        u.setPassword("123");
        return u;
    }

    @Bean
    public User user2() {
        User u = new User();
        u.setName("正南");
        u.setPassword("456");
        return u;
    }

}
