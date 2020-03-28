package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class TestCollection {
    // 向上转型
    // 泛型：写一个方法和类，可同时支持多种不同类型的数据
    //   <String> 泛型参数，collection 里包含了若干个String对象
    //   new ArrayList<>();其中<>中的 String 可有可无  也可写成 new ArrayList()（不推荐）
    // 泛型参数只能是包装类
    public static void main(String[] args) {
        // 1. 创建 Collection
        Collection<String> collection = new ArrayList<>();
        // 2. 使用 size 方法
        System.out.println(collection.size());
        // 3. 使用 isEmpty 方法
        System.out.println(collection.isEmpty());
        // 4. 使用 add 方法插入元素尾插
        collection.add("hello");
        collection.add("world");
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
        // 5. 可以 toArray 把Collection 转换成数组
        Object[] array = collection.toArray();
        System.out.println(Arrays.toString(array));
        // 6. 可以直接使用 for 循环遍历集合中元素
        for(String s: collection){
            System.out.println(s);
        }
        // 7. 使用 contains 方法判定元素是否存在
        System.out.println(collection.contains("hello"));
        // 8. 使用 remove 删除元素
        collection.remove("world");
        System.out.println("删除之后：");
        for (String s: collection) {
            System.out.println(s);
        }
        // 9. 使用 clear 方法清空所有元素
        collection.clear();
        System.out.println("清空之后：");
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
    }
}
