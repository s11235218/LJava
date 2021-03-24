package servlet;

import model.Response;
import util.JSONUtil;
import util.ThreadLocalHolder;

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
        req.setCharacterEncoding("UTF-8");// 设置请求数据的编码格式
        resp.setCharacterEncoding("UTF-8");// 设置响应数据的编码格式
        resp.setContentType("application/json");// 设置响应数据格式

        Response response = new Response();
        try {
            Object o = process(req, resp);
            response.setSuccess(true);
            response.setCode("200");
            response.setData("设置成功！");
            // 第一个get是自己写的方法，表示获取一个ThreadLocal变量
            // 再使用Thread Local的get方法获取到之前访问的变量
            // 获取当前线程设置的count变量
            response.setTotal(ThreadLocalHolder.get().get());
            response.setData(o);
        } catch (Exception e) {
            response.setCode("500");
            response.setMessage(e.getMessage());
            // 打印异常堆栈，到输出流里
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            System.err.println(stackTrace);
            response.setStackTrace(stackTrace);
        } finally {
            // 使用完ThreadLocal在线程结束前调用remove()方法删除变量值, 否则容易导致内存泄漏
            ThreadLocalHolder.get().remove();
        }
        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.write(response));
        // 将缓冲区的数据强制输出，用于清空缓冲区，
        // 若直接调用close()方法，则可能会丢失缓冲区的数据
        // 所以通俗来讲它起到的是刷新的作用
        pw.flush();
    }

    public abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
