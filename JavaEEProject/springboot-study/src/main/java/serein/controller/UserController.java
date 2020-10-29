package serein.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

// 当前类型注册实例到容器中，并指定为Web请求的处理
@Controller
// @RequestMapping可以定义请求相关配置：如路径，请求方法等
@RequestMapping("/user")
public class UserController {

    // @Autowired
    @Resource
    private Map<Integer, Integer> test;

    @RequestMapping("/login")
    @ResponseBody
    public Object login() {

        return test;
    }

}
