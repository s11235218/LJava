package reflect;

import java.util.*;

//class MyComp implements Comparator<Integer> {
//    @Override
//    public int compare(Integer o1, Integer o2) {
//        // 重新定义什么是小
//        // 返回 < 0 o1 小 o1在前
//        // 返回 > 0 o2 小 o2在前
//        // 返回 = 0 一样小
//
//        // 如果降序 定义谁的数值大 定义为小
//
//        return o2 - o1;
//    }
//}

// 与 @Override 用法类似
@FunctionalInterface
interface TwoIntParamReturnInt {
    Integer func(Integer a, Integer b);
}

public class TestLambda {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(9);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(7);

        // 默认升序排序 要想降序 需要给sort 第二个参数指定一个比较器对象
        // (o1, o2) -> (o2 - o1)
//        TwoIntParamReturnInt func = (Integer o1, Integer o2) -> {
//            return o2 - o1;
//        };
//
//        Integer ret = func.func(10, 20);
//        System.out.println(ret);

        String str=  "test";
        Collections.sort(arrayList, (o1, o2) -> {
            // 变量捕获
            System.out.println(str);
            return o2 - o1;
        });

        System.out.println(arrayList);

        // Iterator<HashMap.Entry<String, Integer>> it;
    }
}
