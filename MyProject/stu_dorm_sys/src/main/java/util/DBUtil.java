package util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    private static volatile DataSource DS; // 双重校验锁 数据库连接池创建
    private static final String URL = "jdbc:mysql://localhost:3306/stu_dorm";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private DBUtil(){}
    // 数据库连接池通过这个方法连接
    private static DataSource getDS() {
        // 双重校验锁
        if (DS == null) {
            synchronized (DBUtil.class) {
                if (DS == null) {
                    DS = new MysqlDataSource();
                    ((MysqlDataSource) DS).setUrl(URL);
                    ((MysqlDataSource) DS).setUser(USERNAME);
                    ((MysqlDataSource) DS).setPassword(PASSWORD);
                }
            }
        }
        return DS;
    }

    // 获取数据库连接对象
    public static Connection getConnection () {
        try {
            return getDS().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("获取数据库连接失败！", e);
        }
    }

    // 数据库释放资源
    // 重载方法
    public static void close(Connection c, Statement s) {
        close(c, s, null);
    }

    // Connection数据库连接对象
    // Statement数据库操作命令对象
    // ResultSet数据库结果集对象
    public static void close(Connection c, Statement s, ResultSet r) {
        try {
            // 反向释放
            if (r != null) {
                r.close();
            }
            if (s != null) {
                s.close();
            }
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("释放数据库资源失败！", e);
        }
    }
}
