package LString;

public class STest {
    public static void toCompare(){
        // 字符串比较（比较大小）
        String str1 = "hehe";
        String str2 = "aha";
        // compareTo 是 Comparable 接口中的提供的抽象方法
        // compareTo返回值 > 0， 认为 str1 大于 str2
        // compareTo返回值 < 0， 认为 str1 小于 str2
        // compareTo返回值 == 0， 认为 str1 等于 str2
        System.out.println(str1.compareTo(str2));
        // 忽略大小写比较大小
        System.out.println(str1.equalsIgnoreCase(str2));
    }

    public static void toFind(){
        // 判定字符串字串
        String str1 = "hello";
        String str2 = "el";
        System.out.println(str1.contains(str2));
        // 不光能判定是否为字串，还能确定字串所处位置
        // str2 在 str1 中第一次出现的位置
        System.out.println(str1.indexOf(str2));
        System.out.println(str1.lastIndexOf(str2));
    }

    public static void main(String[] args) {
        toCompare();
        toFind();
    }
}
