package jd.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

@Component
public class HttpUtils {

    private PoolingHttpClientConnectionManager cm;

    public HttpUtils() {
        this.cm = new PoolingHttpClientConnectionManager();

        // 设置最大连接数
        this.cm.setMaxTotal(100);
        // 设置每个主机的最大连接数
        this.cm.setDefaultMaxPerRoute(10);
    }

    /**
     * @param url
     * 根据请求地址下载页面数据
     * @return java.lang.String 页面数据
     * @author Sssserein
     * @creed: Talk is cheap,show me the code
     * @date 2021/3/9 20:01
     */
    public String doGetHtml(String url) {
        // 获取HttpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();
        // 创建HttpClient请求对象，设置url地址
        HttpGet httpGet = new HttpGet(url);

        // 设置请求信息
        httpGet.setConfig(this.setConfig());

        CloseableHttpResponse response = null;
        try {
            // 使用HttpClient发起请求，获取相应
            response = httpClient.execute(httpGet);

            // 解析响应，返回结果
            if (response.getStatusLine().getStatusCode() == 200) {
                // 判断响应体Entity是否不为空，如果不为空就可以使用EntityUtils
                if (response.getEntity() != null) {
                    String content = EntityUtils.toString(response.getEntity(), "utf8");
                    return content;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭response
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 获取失败，返回空串
        return "";
    }

    // 设置请求信息
    private RequestConfig setConfig() {
        return RequestConfig.custom()
                .setConnectTimeout(10000) // 创建连接的最长时间
                .setConnectionRequestTimeout(5000)  // 获取连接的最长时间
                .setSocketTimeout(100000) // 数据传输的最长时间
                .build();
    }

    /**
     *
     * @param
     * 下载图片
     * @return java.lang.String 图片名称
     * @author Sssserein
     * @creed: Talk is cheap,show me the code
     * @date 2021/3/9 20:04
     */

    public String doGetImage(String url) {
        // 获取HttpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();
        // 创建HttpClient请求对象，设置url地址
        HttpGet httpGet = new HttpGet(url);

        // 设置请求信息
        httpGet.setConfig(this.setConfig());

        CloseableHttpResponse response = null;
        try {
            // 使用HttpClient发起请求，获取相应
            response = httpClient.execute(httpGet);

            // 解析响应，返回结果
            if (response.getStatusLine().getStatusCode() == 200) {
                // 判断响应体Entity是否不为空，如果不为空就可以使用EntityUtils
                if (response.getEntity() != null) {
                    // 下载图片
                    // 获取图片后缀
                    String extName = url.substring(url.lastIndexOf("."));
                    // 创建图片名，重命名图片
                    String picName = UUID.randomUUID().toString() + extName;
                    // 下载图片声明OutPutSteam
                    OutputStream outputStream = new FileOutputStream(new File("E:\\git\\SpiderPic" + picName));
                    response.getEntity().writeTo(outputStream);
                    // 返回图片名称
                    return picName;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭response
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 如果下载失败，返回空串
        return "";
    }
}
