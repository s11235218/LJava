package serein.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import serein.mapper.RecordMapper;
import serein.model.Record;

import java.rmi.server.RMIClassLoader;
import java.util.List;

@Service
public class RecordService {
    
    @Autowired
    private RecordMapper recordMapper;
    
    @Transactional    
    public void add(Integer awardId, List<Integer> memberIds) {
        /**
         * 批量更新：
         * 1.循环遍历中更新===>简单粗暴，不推荐
         * 2.mybatis批量操作（扩展）===>推荐做法，效率更高
         * 提供mapper自定义方法：注意两个参数@Param
         * List遍历参考deleteByIds生成方法AwardMapper.xml
         * xml中insert....select....
         */
        for (Integer memberId : memberIds) {
            Record record = new Record();
            record.setMemberId(memberId);
            record.setAwardId(awardId);
            recordMapper.insertSelective(record);
        }
    }

    @Transactional
    public void deleteByMemberId(Integer id) {
        Record record = new Record();
        record.setMemberId(id);
        recordMapper.deleteByCondition(record);
    }

    @Transactional
    public void deleteByAwardId(Integer id) {
        Record record = new Record();
        record.setAwardId(id);
        recordMapper.deleteByCondition(record);
    }
}
