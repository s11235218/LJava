package servlet;

import dao.StudentDAO;
import model.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

// 输入流解析json
// 传过来的数据格式请求头里的content/type字段: application/json
// 请求体里是json数据字符串
@WebServlet("/student/query")
public class StudentQueryServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Student> students = StudentDAO.query();
        return students;
    }
}
