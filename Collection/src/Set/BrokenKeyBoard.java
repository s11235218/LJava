package Set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BrokenKeyBoard {
    public static void main(String[] args) {
        // 1. 循环读入两个字符串 第一个字符串是预期输入 第二个是实际输出
        // 2.把读入的字符串统一转成大写（题目结果输出大写）
        // 3. 题目中的主要任务是判定预期其输出的那些字符不在实际输出的字符串中
        //    set 把实际输出的每个字符存进去 遍历预期数组 看看 set中
        //  注意：预期：7_This_is_a_test 实际：_hs_s_a_es
        //  最后输出结果不重复（去重） 用 set 去重
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 1. 输入字符串
            String excepted = scanner.next();
            String actual = scanner.next();
            // 2. 全部转大写
            excepted = excepted.toUpperCase();
            actual = actual.toUpperCase();
            // 3. 创建 set
            Set<Character> actualSet = new HashSet<>();
            for (int i = 0; i < actual.length(); i++) {
                // set 中的元素不能重复 如果add 时发现元素存在 add 失败 无任何影响
                actualSet.add(actual.charAt(i));
            }
            // 4. 遍历预期输出字符串，看那个字符没被实际输出
            Set<Character> brokenKeySet = new HashSet<>();
            for (int i = 0; i < excepted.length(); i++) {
                char c = excepted.charAt(i);
                if (actualSet.contains(c)) {
                    // 当前字符被输出 没坏的按键
                    continue;
                }
                // 没被输出 就是坏了的键
                // 当前坏键去重
                if (brokenKeySet.contains(c)) {
                    continue;
                }
                System.out.print(c);
                brokenKeySet.add(c);
            }
        }
    }
}
