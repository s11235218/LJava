package jsoup;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.Set;

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

    // 获取元素中的数据
    @Test
    public void testData() throws Exception {

        // 解析文件，获取Document
        Document doc = Jsoup.parse(new File("E:\\git\\test.html"), "utf8");

        // 根据id获取元素
        Element element = doc.getElementById("test");

        String str = "";

        // 元素中获取数据
        // 1. 从元素中获取id
        str = element.id();

        // 2. 从元素中获取className
        str = element.className();
        Set<String> classNames = element.classNames();
//        for (String s:classNames) {
//            System.out.println(s);
//        }

        // 3. 从元素中获取属性的值attr
        str = element.attr("class");

        // 4. 从元素中获取所有属性Attribute
        Attributes attributes = element.attributes();
        System.out.println(attributes.toString());

        // 5. 从元素中获取文本内容text
        str = element.text();

        // 打印获取到的内容
        System.out.println("从元素中获取到的数据是：" + str);

    }

    // 使用选择器获取元素
    @Test
    public void testSelect() throws Exception {
        // 解析文件，获取document对象
        Document doc = Jsoup.parse(new File("E:\\git\\test.html"), "utf8");

        // tagname：通过标签查找元素，比如 span
        Elements elements = doc.select("span");
        for (Element element : elements) {
            System.out.println(element.text());
        }

        // #id: 通过ID查找元素，比如 #city_bj
//        Element element = doc.select("#city_bj").first();

        // .class：通过class名查找元素 比如 .class_a
//        Elements element = doc.select(".class_a");

        // [attribute]: 利用属性查找元素 比如 [abc]
        Element element = doc.select("[abc]").first();

        // [attr=value]: 利用属性值查找元素 比如[class=s_name]
        Elements elements1 = doc.select("[class = s_name]");
        for (Element element1 : elements1) {
            System.out.println(element1.text());
        }

        System.out.println("获取到的数据是：" + element.text());
    }

    // 使用组合选择器获取元素
    @Test
    public void testSelectReunion() throws Exception {
        // 解析文件，获取document对象
        Document doc = Jsoup.parse(new File("E:\\git\\test.html"), "utf8");

        // el#id: 元素 + id 比如 h3#city_bj
        Element element = doc.select("h3#city_bj").first();
        // el.class: 元素 + .class 比如 li.class_a
        element = doc.select("li.class_a").first();

        // el[attr]: 元素 + 属性名 比如 span[abc]
        element = doc.select("span[abc]").first();

        // 任意组合：span[abc].s_name
        element = doc.select("span[abc].s_name").first();
        // ancestor child: 查找某个元素下的子元素 比如 .city_con li 查找"city_con"下的所有li
        Elements elements = doc.select(".city_con li");

        // parent > child: 查找某个父元素下的直接子元素
        //  比如 .city_con > ul > li 查找city_con第一级(直接子元素)的ul,再找所有ul下的第一级li
        elements = doc.select(".city_con > ul > li");

        // parent > *: 查找某个父元素下所有子元素
        elements = doc.select(".city_con > ul > *");

//        System.out.println(element.text());

        for (Element element1 : elements) {
            System.out.println("遍历结果：" + element1.text());
        }


    }
}
