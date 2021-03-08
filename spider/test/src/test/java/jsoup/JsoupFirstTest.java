package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.net.URL;

/**
 *
 * 虽然使用Jsoup可以替代HttpClient直接发起请求解析数据，
 * 但是一般不会使用，在实际开发中，需要使用多线程、连接池代理等方式
 * 而Jsoup对这些支持并不是很好，因此一般把Jsoup作为html解析工具使用
 *
 * @return
 * @author Sssserein
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/7 20:58
 */

public class JsoupFirstTest {

    @Test
    public void testUrl() throws Exception {
        // 解析url地址, 第一个参数是访问的url，第二个参数是访问时候的超时时间
        Document doc = Jsoup.parse(new URL("https://www.itcast.cn"), 1000);

        // 使用标签选择器，获取title标签中的内容
        String title = doc.getElementsByTag("title").first().text();

        // 打印
        System.out.println(title);

    }
}
