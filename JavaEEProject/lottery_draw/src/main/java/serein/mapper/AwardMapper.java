package serein.mapper;

import org.apache.ibatis.annotations.Mapper;
import serein.base.BaseMapper;
import serein.model.Award;

import java.util.List;

@Mapper
public interface AwardMapper extends BaseMapper<Award> {
    List<Award> query(Award award);
}