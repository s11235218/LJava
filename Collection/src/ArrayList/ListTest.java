package ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        // 1. 创建 List 实例
        List<String> list = new ArrayList<>();
        // 2. 新增元素
        list.add("C");
        list.add("C++");
        list.add("Java");
        list.add("Python");
        // 3. 打印整个 list
        System.out.println(list);
        // 4. 按照下标访问元素
        System.out.println(list.get(0));
        // 5. 根据下标修改元素
        list.set(0, "PHP");
        System.out.println(list);
        // 6. 使用 for 循环访问每个元素
//        for(String s: list){
//            System.out.println(s);
//        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        // 7. 使用 subList 获取子序列
        System.out.println(list.subList(1, 3));
        // 8. 可以使用构造方法构造出新的 List 对象
        List<String> list2 = new ArrayList<>(list);
        System.out.println(list2);
        list.set(0, "C#");
        System.out.println(list2);
        // 验证是否为深拷贝，给 List 泛型参数填一个可变对象类型
    }
}
