package dao;

import model.DictionaryTag;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BuildingDAO {
    public static List<DictionaryTag> query() {
        List<DictionaryTag> list = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            String sql = "select id, building_name from building";
            ps = c.prepareStatement(sql); // 数据库连接对象获取连接

            rs = ps.executeQuery(); // 执行后获得结果集
            // 处理结果集
            while (rs.next()) {
                DictionaryTag tag = new DictionaryTag();
                tag.setDictionaryTagKey(rs.getString("id"));
                tag.setDictionaryTagValue(rs.getString("building_name"));
                list.add(tag);
            }

        } catch (Exception e) {
            throw new RuntimeException("查询宿舍楼数据字典出错!", e);
        } finally {
            DBUtil.close(c, ps, rs);
        }
        return list;
    }
}
