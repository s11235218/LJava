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
        List<Student> list = new ArrayList<>();
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
                    "       s.dorm_id," +
                    "       s.create_time," +
                    "       d.dorm_no," +
                    "       b.id building_id," +
                    "       b.building_name" +
                    "   from student s" +
                    "         join dorm d on s.dorm_id = d.id" +
                    "         join building b on d.building_id = b.id";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setStudentName(rs.getString("student_name"));
                s.setStudentGraduateYear(rs.getString("student_graduate_year"));
                s.setStudentMajor(rs.getString("student_major"));
                s.setStudentEmail(rs.getString("student_email"));
                s.setDormId(rs.getInt("dorm_id"));
                s.setDormNo(rs.getString("dorm_no"));
                s.setBuildingId(rs.getInt("building_id"));
                s.setBuildingName(rs.getString("building_name"));
                list.add(s);
            }

        } catch (Exception e) {
            throw new RuntimeException("查询学生列表出错!", e);
        } finally {
            DBUtil.close(c, ps, rs);
        }
        return list;
    }


}
