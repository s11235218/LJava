package serein.controller;


import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import serein.mapper.RecordMapper;
import serein.model.Record;
import serein.model.Stu;
import serein.service.RecordService;

import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping("/query")
    public Object query(Integer id) { // Controller===>Service===>Mapper
        Record record = recordService.query(id);
        return record;
    }

    @PostMapping("/test")
    public Object test(Stu stu) {
        List<Record> records = recordService.test(stu);
        return records;
    }

}
