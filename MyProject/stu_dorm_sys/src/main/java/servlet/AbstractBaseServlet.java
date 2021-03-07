package servlet;

import model.Response;
import util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public abstract class AbstractBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");// 设置请求数据的编码格式：
        resp.setCharacterEncoding("UTF-8");// 设置响应数据的编码格式
        resp.setContentType("application/json");// 设置响应数据格式

        Response response = new Response();
        try {
            Object o = process(req, resp);
            response.setSuccess(true);
            response.setCode("200");
            response.setData("设置成功！");
            response.setData(o);
        } catch (Exception e) {
            response.setCode("500");
            response.setMessage(e.getMessage());
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            System.err.println(stackTrace);
            response.setStackTrace(stackTrace);
        }
        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.write(response));
        pw.flush();
    }

    public abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
