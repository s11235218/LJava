package serein.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import serein.model.Stu;
import serein.model.StuExample;

import java.util.List;
@Mapper
public interface StuMapper {
    long countByExample(StuExample example);

    int deleteByExample(StuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Stu record);

    int insertSelective(Stu record);

    List<Stu> selectByExample(StuExample example);

    Stu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Stu record, @Param("example") StuExample example);

    int updateByExample(@Param("record") Stu record, @Param("example") StuExample example);

    int updateByPrimaryKeySelective(Stu record);

    int updateByPrimaryKey(Stu record);
}