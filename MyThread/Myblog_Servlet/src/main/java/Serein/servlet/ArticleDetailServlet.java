package Serein.servlet;

import Serein.dao.ArticleDAO;
import Serein.model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/articleDetail")
public class ArticleDetailServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
        Article article = ArticleDAO.queryById(Integer.parseInt(id));
        if (article == null) {
            throw new RuntimeException("文章详情出错，id=" + id);
        }
        return null;
    }
}
