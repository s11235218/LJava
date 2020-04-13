package Set;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestInterview {
    // 1. Map
    public int singleNumber(int[] nums) {
        // 1. 创建一个map key表示数字 value 表示出现次数
        Map<Integer, Integer> map = new HashMap<>();
        // 2. 遍历数组 完成统计
        for (int x : nums) {
            Integer value = map.get(x);
            if (value == null) {
                map.put(x, 1);
            } else {
                map.put(x, value + 1);
            }
        }
        // 3. 遍历 map
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            // getValue 得到的是Integer 包装类 通过equals 判定相当于对1自动装箱比较两个Integer
//            // 如果写成 == 1 相当于对 Integer 自动拆箱
//            if (entry.getValue().equals(1)) {
//                return entry.getKey();
//            }
//        }
        Iterator<HashMap.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    // 2. 按位异或 a ^ b ^ b => a 相同为 0 相异为 1
    public int singleNumber1(int[] nums) {
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }
        return ret;
    }

    public int[] singleNumber2(int[] nums) {
        // 1. 异或
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }
        // 2. 此时相当于 a ^ b
        int bit = 1;
        int i = 0;
        for (; i < 32; i++) {
            if ((ret & (bit << i)) != 0) {
                bit = bit << i;
                break;
            }
        }
        // 循环后 bit 值就是某位为 1 的值
        // 分组
        int a = 0;
        int b = 0;
        for (int x : nums) {
            if ((x & (bit << i)) != 0) {
                a ^= x;
            } else {
                b ^= x;
            }
        }
        int[] array = {a, b};
        return array;
    }

    public static void main(String[] args) {
        TestInterview interview = new TestInterview();
        int[] array = {2, 2, 3, 3, 4, 7};
        System.out.println(interview.singleNumber1(array));
        System.out.println(Arrays.toString(interview.singleNumber2(array)));
    }
}
