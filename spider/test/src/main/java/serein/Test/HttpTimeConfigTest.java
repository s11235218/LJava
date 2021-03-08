package serein.Test;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpTimeConfigTest {

    public static void main(String[] args) {
        // 1.创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 2. 创建HttpGet对象，设置url访问地址
        HttpGet httpGet = new HttpGet("https://www.itcast.cn");

        // 配置请求信息
        RequestConfig config = RequestConfig.custom().setConnectTimeout(1000) // 创建链接的最长时间，单位毫秒
                .setConnectionRequestTimeout(500) // 设置获取链接的最长时间，单位毫秒
                .setSocketTimeout(10 * 1000)  // 设置数据传输的最长时间，单位毫秒
                .build();

        // 给请求设置请求信息
        httpGet.setConfig(config);

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
