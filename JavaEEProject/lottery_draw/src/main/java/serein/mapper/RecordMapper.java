package serein.mapper;

import org.apache.ibatis.annotations.Mapper;
import serein.base.BaseMapper;
import serein.model.Record;

@Mapper
public interface RecordMapper extends BaseMapper<Record> {
}