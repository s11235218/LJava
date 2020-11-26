package serein.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serein.exception.ClientException;
import serein.mapper.UserMapper;
import serein.model.User;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    public User login(User user) {

//        User exist = userMapper.login(user);
//        if (exist == null) {
//            throw new ClientException("USR001", "用户名密码校验失败");
//        }
        User query = new User();
        query.setUsername(user.getUsername());
        User exist = userMapper.selectOne(query);// 只根据用户名查询用户信息
        if (exist == null) {
            throw new ClientException("USR001", "用户不存在！");
        }
        if (!exist.getPassword().equals(user.getPassword()))
            throw new ClientException("USR002", "用户名密码校验失败！");
        return exist;
    }
}
