package servlet.dormServlet;

import dao.BuildingDAO;
import dao.DormDAO;
import model.Building;
import model.Dorm;
import servlet.AbstractBaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/dorm/query")
public class DormQueryWebServlet extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Dorm> dorms = DormDAO.queryWeb();
        return dorms;
    }
}
