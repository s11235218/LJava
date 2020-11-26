package serein.base;

import java.util.List;

public interface BaseMapper<T extends BaseEntity> {

    T selectByPrimaryKey(Integer id);

    int insert(T t);

    int insertSelective(T t);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

    int deleteByPrimaryKey(Integer id);

    T selectOne(T t);

    List<T> selectAll();

    List<T> selectByCondition(T t);

    int deleteByIds(List<Integer> ids);
}
