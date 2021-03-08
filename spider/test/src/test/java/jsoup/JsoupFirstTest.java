package jsoup;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.net.URL;

/**
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

    // 解析url
    @Test
    public void testUrl() throws Exception {
        // 解析url地址, 第一个参数是访问的url，第二个参数是访问时候的超时时间
        Document doc = Jsoup.parse(new URL("https://www.baidu.com"), 10000);

        // 使用标签选择器，获取title标签中的内容
        String title = doc.getElementsByTag("title").first().text();

        // 打印
        System.out.println(title);
    }

    // 解析字符串
    @Test
    public void testString() throws Exception {
        // 使用工具类读取文件，获取字符串
        String content = FileUtils.readFileToString(new File("E:\\git" +
                "\\test.html"), "utf8");
        // 解析字符串
        Document doc = Jsoup.parse(content);

        String title = doc.getElementsByTag("title").first().text();

        System.out.println(title);
    }

    // 解析文件
    @Test
    public void testFile() throws Exception {
        // 解析文件
        Document doc = Jsoup.parse(new File("E:\\git\\test.html"), "utf8");

        String title = doc.getElementsByTag("title").first().text();

        System.out.println(title);
    }

    // 使用Dom方式获取元素
    @Test
    public void testDOM() throws Exception {

        // 解析文件，获取Document对象
        Document doc = Jsoup.parse(new File("E:\\git\\test.html"), "utf8");
        // 1. 根据id查询元素getElementById
        Element content_Id = doc.getElementById("city_bj");
        // 2. 根据标签查询元素getElementByTag
        Element content_Tag = doc.getElementsByTag("span").first();
        // 3. 根据class查询元素getElementByClass
        Element content_Class = doc.getElementsByClass("class_a class_b").first();
//        Element content_Class = doc.getElementsByClass("class_a").first();
//        Element content_Class = doc.getElementsByClass("class_b").first();

        // 4. 根据属性查询元素getElementByAttribute
//        Elements content_Attribute = doc.getElementsByAttribute("abc");
        Elements content_Attribute = doc.getElementsByAttributeValue("href", "http://www.sina.com");


        System.out.println("获取到的元素内容是：" + content_Id.text());
        System.out.println("获取到的元素内容是：" + content_Tag.text());
        System.out.println("获取到的元素内容是：" + content_Class.text());
        System.out.println("获取到的元素内容是：" + content_Attribute.text());
    }
}
