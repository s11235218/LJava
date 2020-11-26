package serein.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import serein.model.User;
import serein.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    // 注意在类型上加@Service注解，注册到容器中，不然是空指针异常错误
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Object login(@RequestBody User user, HttpServletRequest req) {
        // 如果用户名密码校验失败，在service中抛异常，这里exist部位null
        User exist = userService.login(user);
        HttpSession session = req.getSession();
        session.setAttribute("user", exist);
        return null;

    }
}
