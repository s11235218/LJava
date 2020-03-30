package Map;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        // 1. 创建 Map 实例，泛型参数有两个
        //    Map 结构主要目的是根据 key 值找到相应的 value
        Map<String, String> map = new HashMap<>();
        // 2. 使用 size 获取到键值对个数
        System.out.println(map.size());
        // 3. 使用 isEmpty 方法查看是否为空
        System.out.println(map.isEmpty());
        // 4. 使用 put 方法插入键值对
        map.put("及时雨", "宋江");
        map.put("玉麒麟", "卢俊义");
        map.put("智多星", "吴用");
        map.put("入云龙", "公孙胜");
        // 5. 使用 get 方法根据 key 来查找对应 value，如果 key 不存在，返回 null
        System.out.println(map.get("智多星"));
        System.out.println(map.get("大刀"));
        System.out.println(map.getOrDefault("行者", "武松"));
        // 6. 通过 containsKey（执行效率较高） 和 containsValue（执行效率不高） 判定某个值是否存在
        System.out.println(map.containsKey("智多星"));
        System.out.println(map.containsValue("公孙胜"));
        // 7. 使用 isEmpty 和 size
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        // 8. foreach 遍历 Map 中所有键值对
        //    Entry: 表示一个条目，一个键值对map.entrySet 获取到所有键值对
        // Map 中的元素顺序和插入顺序无关，取决于具体实现方式
        for (Map.Entry<String, String>entry: map.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        map.remove("入云龙");
        System.out.println("删除元素后：");
        for(Map.Entry<String, String>entry: map.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        map.clear();
        System.out.println(map.isEmpty());

        // 如果插入键值对 key 存在，则覆盖原有 value
        map.put("及时雨", "晁盖");
        System.out.println(map);
    }
}
