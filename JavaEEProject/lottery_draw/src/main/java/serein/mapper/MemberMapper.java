package serein.mapper;

import org.apache.ibatis.annotations.Mapper;
import serein.base.BaseMapper;
import serein.model.Member;

@Mapper
public interface MemberMapper extends BaseMapper<Member> {
}