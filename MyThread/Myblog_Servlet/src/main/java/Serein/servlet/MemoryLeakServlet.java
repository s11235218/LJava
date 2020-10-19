package Serein.servlet;

import Serein.model.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet("/leak")
public abstract class MemoryLeakServlet extends HttpServlet {

    private static ConcurrentHashMap<String , Article> SESSION = new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 模拟用户登陆以后，保存用户的session信息
        if ("/login".equalsIgnoreCase(req.getContextPath())) {
            SESSION.put(UUID.randomUUID().toString(), new Article());
        }
        // 确实了一段SESSION数据结构的维护代码：用户很长时间没有操作，就应该清理掉该用户的session
    }

    protected abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}

