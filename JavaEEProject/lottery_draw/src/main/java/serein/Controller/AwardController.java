package serein.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import serein.model.Award;
import serein.model.User;
import serein.service.AwardService;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/award")
public class AwardController {

    @Autowired
    private AwardService awardService;

    @PostMapping("/add")
    public Object add(@RequestBody Award award, HttpSession session){// 插入时，请求数据不带id
        User user = (User) session.getAttribute("user");
        award.setSettingId(user.getSettingId());
        awardService.add(award);
        return award.getId();// 数据库插入时，自动设置id为自增主键：返回给前端，否则有bug
    }

    @PostMapping("/update")
    public Object update(@RequestBody Award award){// 修改时id 修改
        awardService.update(award);
        return null;
    }

    @GetMapping("/delete/{id}")
    // @PathVariable中的值绑定路径变量，如果@PathVariable没有值，绑定为变量名
    public Object delete(@PathVariable Integer id){
        awardService.delete(id);
        return null;
    }
}
