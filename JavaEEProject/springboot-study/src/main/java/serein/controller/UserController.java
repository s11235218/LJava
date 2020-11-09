package serein.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import serein.model.User;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

// 当前类型注册实例到容器中，并指定为Web请求的处理
@Controller
// @RequestMapping可以定义请求相关配置：如路径，请求方法等
@RequestMapping("/user")
public class UserController {

    @Autowired
    // @Resource
    private Map<Integer, Integer> test1;

//    @Autowired
    // 变量名和bean的名称要一致，否则报错
//    private User user;


//    @Autowired
//    @Qualifier("user1")
//    // 变量名和bean的名称不一致，@Autowired要搭配@Qualifier指定bean的名称
//    private User user;

    @Resource(name = "user1")
    // 变量名和bean的名称不一致，@Resource要指定bean的名称
    private User user;

    @RequestMapping("/login")
    @ResponseBody
    public Object login(User user, HttpServletRequest req) {
        // return test;
        // 模拟用户登录，在数据库校验用户名及密码
        if (!"abc".equals(user.getName())) {
            throw new RuntimeException("用户失败！");
        }
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        return user;
    }

    @RequestMapping("/m")
    public String m() {
        return "/main.html";
    }

    @RequestMapping("/l1")
    public String l1() {
        // 返回路径不带/，以当前请求路径为相对位置，
        // 返回路径带/，会去掉当前路径，以项目的部署路径为相对位置
        return "forward:login";// 以当前请求路径/user/l1,转发到/user同一级查找资源路径
        // return "forward:/login"; // 带/，以项目路径查找/login
    }

    @RequestMapping("/l2")
    public String l2() {
        return "redirect:/user/login";
    }

    // url为rest风格的请求
    @RequestMapping("/test/{key}") // 路径中使用变量占位符
    @ResponseBody
    public Object test1(@PathVariable("key") Integer k) {// 如果类型不匹配，抛出异常

        System.out.println("==========" + test1.get(k));
        return test1;
    }

    // 请求GET/user/test2/?k1=v1&k2=v2&k3=v3
    @RequestMapping(value = "/test2", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object test2(
            // 可以匹配url中的参数，请求体k1=v1&k2=v2格式的数据
            @RequestParam String k1, // 写全的做法
            @RequestParam String k2, // 省略注解值，默认变量为key查找请求数据
            String k3//默认@RequestParam注解
    ) {
        System.out.println("========" + k1 + ", " + k2 + ", " + k3);
        return test1;
    }

    @RequestMapping("/test3")
    @ResponseBody
    // 请求数据自动映射到参数类型的属性中：username=xxx&password=xxx
    public Object test3(User user) {
        System.out.println(user);
        return test1;
    }

    @RequestMapping("/test4")
    @ResponseBody
    public Object test4() {
        return null;// 响应体为空==>配置ControllerAdvice时，不会进入重写响应体方法
    }

    @RequestMapping("/test5")
    @ResponseBody
    public Object test5() {
        return "ok";// 返回字符串，响应数据格式不再是application/json,而是text/plain,字符串内容
    }

    @RequestMapping("/test6")
    @ResponseBody
    // http请求是基于Servlet的，Spring已经生成request和response对象，可以直接传入参数使用
    public Object test6(HttpServletRequest req, HttpServletResponse res) {// Spring自动将对象注入到参数
        System.out.println("=========" + req.getParameter("name") + ", "
                + req.getParameter("password"));
        return null;
    }

    @RequestMapping("/test7")
    @ResponseBody
    // 请求数据类型为application/json时，解析请求体中的json字符串为Java对象
    public Object test7(@RequestBody User user) {
        System.out.println("======" + user);
        return null;
    }

    /**
     * web开发一般需求：
     * 1.统一处理异常
     * 2.统一返回数据格式
     * 3.统一管理会话管理（登录的敏感资源权限控制）
     *
     * @author Sssserein
     * @creed: Talk is cheap,show me the code
     * @date 2020/10/29 20:55
     */

    @RequestMapping("/test8")
    @ResponseBody
    public Object test8() {
        throw new RuntimeException("数据库报错！");
    }
}

