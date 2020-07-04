package Serein.servlet;

import Serein.dao.ArticleDAO;
import Serein.model.Article;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


//@WebServlet("/articleList")
public class ArticleListServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
        List<Article> articles = ArticleDAO.query(Integer.parseInt(id));
        return articles;
    }
}
