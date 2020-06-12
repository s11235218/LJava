package Ssserein.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");// 请求数据编码：请求体产生作用 URL中数据无效
        resp.setCharacterEncoding("UTF-8");// 服务端响应的内容设置编码
        // 告诉浏览器：1.数据类型（浏览器处理数据的方式） 2.编码（浏览器解析数据的编码）
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();

        // 测试用，演示http请求头、响应头、状态码
        // 演示400、301/302/307重定向、转发
        // 模拟方式：请求http://localhost:8080/项目部署名/test?i=
        String i = req.getParameter("i");
        if ("1".equals(i)) {// 重定向
            resp.sendRedirect("index.html");
        }else if ("2".equals(i)) {// 转发
            req.getRequestDispatcher("index.html").forward(req, resp);
        }else { // 如果是int，就正常返回，如果不是，返回400
            try {
                Integer.parseInt(i);
                // 能够解析为int正常返回
                pw.println("正常的数值" +i);
            } catch (NumberFormatException e) {
                // 非int,返回400
                resp.setStatus(400);
                pw.println("非数值"+i);
            }
        }

        pw.flush();

    }
}
