package serein.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import serein.model.Award;
import serein.service.RecordService;

import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @PostMapping("/add/{awardId}")
    public Object add(@PathVariable Integer awardId, @RequestBody List<Integer> memberIds) {
        recordService.add(awardId, memberIds);
        return null;
    }

    // 业务上一个人只能抽一个奖
    // 如果业务允许一个人抽多个奖====>通过memberId+awardId删除
    @GetMapping("/delete/member")
    public Object deleteByMemberId(Integer id) {
        recordService.deleteByMemberId(id);
        return null;
    }

    @GetMapping("/delete/award")
    public Object deleteByAwardId(Integer id) {
        recordService.deleteByAwardId(id);
        return null;
    }

    /**
    * TODO
     * 需要实现：根据setting_id删除中奖记录
    *
    */
}
