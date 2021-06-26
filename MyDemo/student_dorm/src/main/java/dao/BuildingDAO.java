package dao;

import model.Building;
import model.DictionaryTag;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
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

    public static List<Building> queryWeb() {
        List<Building> list = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = ("select b.id," +
                    "b.building_name," +
                    "b.building_desc," +
                    "b.create_time" +
                    "   from building b");
            ps  = c.prepareStatement(sql);
            rs = ps.executeQuery(); // 执行后获得结果集
            // 处理结果集
            while (rs.next()) {
                Building b = new Building();
                b.setId(rs.getInt("id"));
                b.setBuildingName(rs.getString("building_name"));
                b.setBuildingDesc(rs.getString("building_desc"));
                b.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                list.add(b);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询宿舍楼列表出错!", e);
        } finally {
            DBUtil.close(c, ps, rs);
        }
        return list;
    }

    public static int insert(Building b) {

        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            String sql = "insert into building(building_name, " +
                    "building_desc) values (?,?)";
            ps = c.prepareStatement(sql);
            ps.setString(1, b.getBuildingName());
            ps.setString(2, b.getBuildingDesc());

            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("插入宿舍楼信息出错!", e);
        } finally {
            DBUtil.close(c, ps);
        }
    }

    public static Building queryById(int id) {

        Building b = new Building();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = "select b.id," +
                    "b.building_name," +
                    "b.building_desc," +
                    "b.create_time" +
                    "   from building b" +
                    "   where b.id=?";
            ps = c.prepareStatement(sql); // 数据库连接对象获取连接
            ps.setInt(1, id);
            rs = ps.executeQuery(); // 执行后获得结果集
            // 处理结果集
            while (rs.next()) {
                b.setId(rs.getInt("id"));
                b.setBuildingName(rs.getString("building_name"));
                b.setBuildingDesc(rs.getString("building_desc"));
                b.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
            }

        } catch (Exception e) {
            throw new RuntimeException("查询宿舍楼详情出错!", e);
        } finally {
            DBUtil.close(c, ps, rs);
        }
        return b;
    }
}
