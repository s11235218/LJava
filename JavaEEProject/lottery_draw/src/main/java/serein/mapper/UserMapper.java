package serein.mapper;

import org.apache.ibatis.annotations.Mapper;
import serein.base.BaseMapper;
import serein.model.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}