package servlet;

import dao.DictionaryTagDAO;
import model.Dictionary;
import model.DictionaryTag;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * url中的键值对通过使用GetParameter方法获取数据
 * @author Sssserein
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/21 17:31
 */

@WebServlet("/dict/tag/query")
public class DictionaryTagQueryServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String key = req.getParameter("dictionaryKey");
        List<DictionaryTag> tags = DictionaryTagDAO.query(key);
        return tags;
    }
}
