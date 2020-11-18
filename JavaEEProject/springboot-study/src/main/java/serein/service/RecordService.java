package serein.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import serein.mapper.RecordMapper;
import serein.model.Record;
import serein.model.Stu;

import java.util.List;

@Service
public class RecordService {

    @Autowired

    private RecordMapper recordMapper;

    public Record query(Integer id) {
        return recordMapper.selectByPrimaryKey(id);
    }

    public List<Record> test(Stu stu) {
        return recordMapper.test(stu);
    }
}
