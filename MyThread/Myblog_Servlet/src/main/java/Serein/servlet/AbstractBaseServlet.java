package Serein.servlet;

import Serein.util.JSONUtil;

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
        req.setCharacterEncoding("UTF-8"); // 请求体编码
        resp.setCharacterEncoding("UTF-8"); // 响应体编码
        resp.setContentType("application/json, charset=UTF-8"); // 浏览器接收数据解析方式

        model.Response response = new model.Response();
        try {
            response.setSuccess(true); // 出现异常，返回success=false，并设置错误消息，异常堆栈
            response.setData(process(req, resp));
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            StringWriter sw = new StringWriter();
            PrintWriter writer = new PrintWriter(sw);
            e.printStackTrace();
            response.setStackTrace(sw.toString());
        }
        // 响应数据，json数据
        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.serialize(response));
        pw.flush();
    }

    public abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
