package serein.Test;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class HttpGetParamTest {

    public static void main(String[] args) throws Exception {
        // 1.创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 设置请求的地址是：http://yun.itheima.com/search?keys=java
        // 创建URIBuilder
        URIBuilder uriBuilder = new URIBuilder("http://yun.itheima.com/search");

        // 设置参数
        uriBuilder.setParameter("keys", "java");

        // 2. 创建HttpGet对象，设置url访问地址
        HttpGet httpGet = new HttpGet(uriBuilder.build());

        System.out.println("发起请求的信息：" + httpGet);

        CloseableHttpResponse response = null;
        try {
            // 3. 使用HttpClient发起请求，获取响应
            response = httpClient.execute(httpGet);
            // 4. 解析响应
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "utf8");
                System.out.println(content.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 释放资源 response
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
