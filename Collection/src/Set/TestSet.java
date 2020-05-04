package Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        // 1.实例化 set
        Set<String> set = new HashSet<>();
        // 2. 插入元素
        set.add("hello");
        set.add("world");
        set.add("java");
        // 3. 判断元素存在
        System.out.println(set.contains("world"));

        set.remove("world");
        System.out.println(set.contains("world"));

        // 5. 遍历
        // System.out.println(set);
        // 迭代器的泛型参数 要和集合类中保存的元素参数保持一致
        // 集合类内部自己实现自己版本的迭代器类 不同集合类
        // 内部迭代器类型不同迭代方式也不同（实现细节不同）
        System.out.println();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
