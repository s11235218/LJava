package serein.mapper;

import org.apache.ibatis.annotations.Mapper;
import serein.model.User;

@Mapper
public interface Test {

    User query(Integer id);
}
