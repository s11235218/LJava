package dao;

import model.Student;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public static List<Student> query() {
        List<Student> students = new ArrayList<>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = "select s.id," +
                    "       s.student_name," +
                    "       s.student_graduate_year," +
                    "       s.student_major," +
                    "       s.student_email," +
                    "       s.dorm_id,\n" +
                    "       s.create_time,\n" +
                    "       d.dorm_no,\n" +
                    "       b.id building_id,\n" +
                    "       b.building_name\n" +
                    "from student s\n" +
                    "         join dorm d on s.dorm_id = d.id\n" +
                    "         join building b on d.building_id = b.id";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

            }

        } catch (Exception e) {
            throw new RuntimeException("查询学生列表出错!", e);
        } finally {
            DBUtil.close(c, ps, rs);
        }
        return students;
    }
}
