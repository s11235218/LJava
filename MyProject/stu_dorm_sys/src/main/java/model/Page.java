package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.servlet.http.HttpServletRequest;

@Setter
@Getter
@ToString
public class Page {
    private String searchText; // 搜索的内容
    private String sortOrder; // 排序的方式：升序、降序
    private Integer pageSize; // 每页的数量
    private Integer pageNumber; // 当前页码

    /**
     *
     * @param req
     * request输入流只能获取请求体的数据,依赖程序自己解析
     * request.getParameter可以获取url和请求体中的数据：k1=v1&k2=v2...
     *
     * @return model.Page
     * @author Sssserein
     * @creed: Talk is cheap,show me the code
     * @date 2021/3/23 20:59
     */

    public static Page parse(HttpServletRequest req) { // 不用json的方式解析
        Page p = new Page();
        p.searchText = req.getParameter("searchText");
        p.sortOrder = req.getParameter("sortOrder");
        p.pageSize = Integer.parseInt(req.getParameter("pageSize"));
        p.pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
        return p;

    }
}
