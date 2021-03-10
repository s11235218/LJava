package jd.task;

import jd.pojo.Item;
import jd.service.ItemService;
import jd.util.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ItemTask {

    @Autowired
    private HttpUtils httpUtils;

    @Autowired
    private ItemService itemService;

    // 当下载任务完成后，间隔多长时间进行下一次任务
    @Scheduled(fixedDelay = 100*1000)
    public void itemTask() throws Exception {

        // 声明需要解析的初始地址
        String url = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&wq=%E6%89%8B%E6%9C%BA&s=1&click=1page=";

        // 按照页面对手机的搜索结果进行遍历解析
        for (int i = 0; i < 10; i += 2) {
            String html = httpUtils.doGetHtml(url + i);

            // 解析页面，获取商品数据并储存
            this.parse(html);
        }

        System.out.println("手机数据抓取完成！");

    }

    // 解析页面，获取商品数据并储存
    private void parse(String html) {
        // 解析 html 获取Document
        Document doc = Jsoup.parse(html);
        // 获取spu
        Elements spuEles = doc.select("div#J_goodsList > ul > li");

        for (Element spuEle : spuEles) {
            // 获取spu
            long spu = Long.parseLong(spuEle.attr("data-spu"));
            // 获取sku信息
            Elements skuEles = spuEle.select("li.ps-item");

            for (Element element : skuEles) {
                // 获取sku
                long sku = Long.parseLong(skuEles.select("[data-sku]").attr("data-sku"));

                // 根据sku查询商品数据
                Item item = new Item();
                item.setSku(sku);
                // 如果商品存在，就进行下一个循环，该商品不保存，因为数据库中已存在
            }
        }


    }
}
