package Serein.util;

import Serein.model.Article;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Response;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONTest {

    /**
     * 模拟http接收http请求的json数据：json格式解析/反序列化为Java对象
     * 响应http的json格式数据：Java对象封装/序列化为json数据类型
     * 使用jackson框架做json的序列化/反序列化
     * */
    @Test
    public void t1() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Article a1 = new Article();
        a1.setId(1);
        a1.setTitle("标题1");
        a1.setContent("内容1");

        Article a2 = new Article();
        a2.setId(2);
        a2.setTitle("标题2");
        a2.setContent("内容2");
        List<Article> articles = new ArrayList<>();
        articles.add(a1);
        articles.add(a2);
        Response r = new Response();
        r.setData(articles);

        /*Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");*/

        String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(articles);
        System.out.println(s);
       /* Map m = mapper.readValue(s, Map.class);
        System.out.println(m);*/
    }
}
