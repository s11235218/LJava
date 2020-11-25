package serein.mapper;

import org.apache.ibatis.annotations.Mapper;
import serein.base.BaseMapper;
import serein.model.Setting;

@Mapper
public interface SettingMapper extends BaseMapper<Setting> {
}