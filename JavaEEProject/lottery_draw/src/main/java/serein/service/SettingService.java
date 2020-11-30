package serein.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serein.exception.BusinessException;
import serein.mapper.SettingMapper;
import serein.model.Award;
import serein.model.Member;
import serein.model.Setting;

import java.util.ArrayList;
import java.util.List;

@Service
public class SettingService {

    @Autowired
    private SettingMapper settingMapper;

    @Autowired
    private AwardService awardService;

    @Autowired
    private MemberService memberService;

    public Setting query(Integer id) {
        Setting query = new Setting();
        query.setUserId(id);
        // 注册用户时间，需要生成一个setting数据，1对1，如果没有生成，业务有问题
        Setting setting = settingMapper.selectOne(query);
        if (setting == null) {
            throw new BusinessException("SET001", "用户设置信息出错！");
        }
        // 查询奖品列表、人员列表，设置到属性中 TODO
        // 设置查询奖品列表：通过setting_id 查询
        Award award = new Award();
        award.setSettingId(setting.getId());
        List<Award> awards = awardService.query(award);
        setting.setAwards(awards);

        // 查询人员列表：通过user_id查询
        Member member = new Member();
        member.setUserId(id);
        List<Member> members = memberService.query(member);
        setting.setMembers(members);

        return setting;
    }
}
