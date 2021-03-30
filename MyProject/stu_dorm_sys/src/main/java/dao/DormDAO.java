package dao;

import model.Building;
import model.DictionaryTag;
import model.Dorm;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DormDAO {
    public static List<DictionaryTag> query(int id) {
        List<DictionaryTag> list = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = DBUtil.getConnection();
            String sql = "select d.id," +
                    "       d.dorm_no" +
                    "   from building b" +
                    "         join dorm d on b.id = d.building_id" +
                    " where b.id = ?";
            ps = c.prepareStatement(sql); // 数据库连接对象获取连接
            ps.setInt(1, id);
            rs = ps.executeQuery(); // 执行后获得结果集
            // 处理结果集
            while (rs.next()) {
                DictionaryTag tag = new DictionaryTag();
                tag.setDictionaryTagKey(rs.getString("id"));
                tag.setDictionaryTagValue(rs.getString("dorm_no"));
                list.add(tag);
            }

        } catch (Exception e) {
            throw new RuntimeException("查询寝室数据字典出错!", e);
        } finally {
            DBUtil.close(c, ps, rs);
        }
        return list;
    }

    public static List<Dorm> queryWeb() {
        List<Dorm> list = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = ("select d.id," +
                    "       d.dorm_no," +
                    "       d.dorm_desc," +
                    "       d.create_time," +
                    "       b.building_name" +
                    "   from dorm d" +
                    "         join building b on d.building_id = b.id");
            ps  = c.prepareStatement(sql);
            rs = ps.executeQuery();
            // 处理结果集
            while (rs.next()) {
                Dorm d = new Dorm();
                d.setId(rs.getInt("id"));
                d.setBuildingName(rs.getString("building_name"));
                d.setDormNo(rs.getString("dorm_no"));
                d.setDormDesc(rs.getString("dorm_desc"));
                d.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                list.add(d);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询宿舍列表出错!", e);
        } finally {
            DBUtil.close(c, ps, rs);
        }
        return list;
    }

    public static Dorm queryById(int id) {
        Dorm d = new Dorm();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = "select d.id," +
                    "       d.dorm_no," +
                    "       d.dorm_desc," +
                    "       d.create_time," +
                    "       b.building_name" +
                    "   from dorm d" +
                    "         join building b on d.building_id = b.id" +
                    "   where d.id=?";
            ps = c.prepareStatement(sql); // 数据库连接对象获取连接
            ps.setInt(1, id);
            rs = ps.executeQuery(); // 执行后获得结果集
            // 处理结果集
            while (rs.next()) {
                d.setId(rs.getInt("id"));
                d.setBuildingName(rs.getString("building_name"));
                d.setDormNo(rs.getString("dorm_no"));
                d.setDormDesc(rs.getString("dorm_desc"));
                d.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
            }

        } catch (Exception e) {
            throw new RuntimeException("查询寝室详情出错!", e);
        } finally {
            DBUtil.close(c, ps, rs);
        }
        return d;
    }

    public static int insert(Dorm d) {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            String sql = "insert into dorm(dorm_no, " +
                    "dorm_desc) values (?,?)";
            ps = c.prepareStatement(sql);

            ps.setString(1, d.getDormNo());
            ps.setString(2, d.getDormDesc());


            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("插入寝室信息出错!", e);
        } finally {
            DBUtil.close(c, ps);
        }
    }
}
