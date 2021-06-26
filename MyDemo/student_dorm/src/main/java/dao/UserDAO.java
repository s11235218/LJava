package dao;

import model.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public static User query(User user) {
        User queryUser = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = "select id, nickname, email from user where username=? and password=?";
            ps = c.prepareStatement(sql); // 数据库连接对象获取连接
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            rs = ps.executeQuery(); // 执行后获得结果集
            // 处理结果集
            while (rs.next()) {
                queryUser = user;
                queryUser.setId(rs.getInt("id"));
                queryUser.setNickname(rs.getString("nickname"));
                queryUser.setEmail(rs.getString("email"));
            }

        } catch (Exception e) {
            throw new RuntimeException("登录校验用户名密码出错!", e);
        } finally {
            DBUtil.close(c, ps, rs);
        }
        return queryUser;
    }
}
