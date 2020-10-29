package serein.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public Map<Integer, Integer> test() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 200);
        map.put(2, 400);
        return map;
    }
}
