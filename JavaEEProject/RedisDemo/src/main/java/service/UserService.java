package service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Cacheable(cacheNames = "user", key = "#id")
    public String getUser(int id) {
        // 查询数据库伪代码
        System.out.println("我进入了getUser方法！");
        return "ID" + id;
    }
}
