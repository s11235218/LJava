package servlet;

import dao.BuildingDAO;
import dao.DormDAO;
import model.Building;
import model.Dorm;
import util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dorm/add")
public class DormAddServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Dorm d = JSONUtil.read(req.getInputStream(), Dorm.class);
        int num = DormDAO.insert(d);
        return null;
    }
}
