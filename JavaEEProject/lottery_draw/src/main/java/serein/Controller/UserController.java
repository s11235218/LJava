package serein.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import serein.model.Setting;
import serein.model.User;
import serein.service.SettingService;
import serein.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    // 注意在类型上加@Service注解，注册到容器中，不然是空指针异常错误
    @Autowired
    private UserService userService;

    @Autowired
    private SettingService settingService;

    @PostMapping("/login")
    public Object login(@RequestBody User user, HttpServletRequest req) {
        // 如果用户名密码校验失败，在service中抛异常，这里exist一定不为null
        User exist = userService.login(user);
        Setting setting = settingService.query(exist.getId());
        exist.setSettingId(setting.getId());
        HttpSession session = req.getSession();
        session.setAttribute("user", exist);
        return null;
    }

    @PostMapping("/register")
    public Object register(User user,
                           // 上传的头像：1.保存在本地文件夹（web服务器需要加载到）
                           // 2.url存放在注册用户的head字段
                           @RequestPart(value = "headFile", required = false) MultipartFile headFile) {
        // 服务器请求数据校验，实现方法：1.手动校验2.使用validation框架（很多注解）
        // TODO
        userService.register(user, headFile);
        return null;
    }

    /**
     * TODO
     * 注销功能：get api/user/logout
     *
     */
}
