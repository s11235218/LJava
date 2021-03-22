package util;

import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class JSONUtilTest {

    // 写
    @Test
    public void t1() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        map.put("4", "D");
        System.out.println(JSONUtil.write(map));
    }

    // 读
    @Test
    public void t2() {
        // 类加载器加载需要解析的json文件
        InputStream is = getClass().getClassLoader().getResourceAsStream("t2.json");
        HashMap map = JSONUtil.read(is, HashMap.class);
        System.out.println(map);
    }


}
