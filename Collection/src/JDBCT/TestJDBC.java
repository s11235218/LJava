package JDBCT;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC {
    private  static void test() throws SQLException {
        // 1. 创建 DataSource 对象
        DataSource dataSource = new MysqlDataSource();
        // 2. 设置 dataSource 的属性，为和数据库建立连接做准备
        //  MySql 是个服务器，要想访问 就要知道 MySql 的 IP 地址，端口号
        //  以及要访问的数据库名，以及用户名和密码
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/test1?characterEncoding=utf8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("0707");
        // 3. 创建 Connection 对象，用来表示和数据库建立了一次链接
        Connection connection = dataSource.getConnection();
        // 4. 如果链接没问题,就可以操作数据库，拼装 SQL 语句
        //    ? 是占位符 可以把具体变量替换到 ? 位置上
        //    此处 SQL 是可以没有 ；的
        //    拼装 SQL 并没有真正的执行 SQL
        String sql = "insert into student1 values(?, ?)";
        // statement 用来辅助拼装 Sql的 setXXX 的类型需要和数据库表的类型匹配
        // ? 的下标是从 1 开始计算
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "ss");
        statement.setInt(2, 20);
        System.out.println(statement);

        // 5. 执行 SQL
        int ret = statement.executeUpdate();
        System.out.println(ret);

        // 6. 释放相关资源 一定先释放 statement 再释放 Connection 有序释放
        statement.close();
        connection.close();
    }

    private static void testSelect() throws SQLException {
        // 1. 创建 DataSource 对象
        DataSource dataSource = new MysqlDataSource();
        // 2. 设置 dataSource 的属性，为和数据库建立连接做准备
        //  MySql 是个服务器，要想访问 就要知道 MySql 的 IP 地址，端口号
        //  以及要访问的数据库名，以及用户名和密码
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/test1?characterEncoding=utf8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("0707");
        // 3. 创建 Connection 对象，用来表示和数据库建立了一次链接
        Connection connection = dataSource.getConnection();
        // 4. 如果链接没问题,就可以操作数据库，拼装 SQL 语句
        //    ? 是占位符 可以把
        String sql = "select * from student1";
        PreparedStatement statement = connection.prepareStatement(sql);
        // 5. 此处没有 ? 不需要替换 直接执行
        ResultSet resultSet = statement.executeQuery();
        // 6. 遍历结果集合
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(name + ": " + age);
        }

        // 6. 执行 SQL
        int ret = statement.executeUpdate();
        System.out.println(ret);

        // 7. 释放相关资源
        resultSet.close();
        statement.close();
        connection.close();
    }

    public static void main(String[] args) throws SQLException {
        testSelect();

    }
}
