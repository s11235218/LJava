package serein.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import serein.mapper.AwardMapper;
import serein.model.Award;

import java.util.List;

@Service
public class AwardService {

    @Autowired
    private AwardMapper awardMapper;

    public List<Award> query(Award award) {
        return awardMapper.query(award);

    }

    // 1.session获取user，通过userId查询setting_id，再设置插入的award对象
    // 2.登录时setting信息设置到会话
    @Transactional
    public void add(Award award) {
        awardMapper.insertSelective(award);
    }

    @Transactional
    public void update(Award award) {
        awardMapper.updateByPrimaryKeySelective(award);
    }

    @Transactional
    public void delete(Integer id) {
        awardMapper.deleteByPrimaryKey(id);
    }
}
