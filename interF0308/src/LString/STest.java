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

    public static void Stest1(){
        // 字符串以特定字串开头/结尾
        String str1 = "hello, world";
        System.out.println(str1.startsWith("he"));
        System.out.println(str1.endsWith("ld"));

        // 替换操作
        // 没有修改原串，字符串是不可变对象
        System.out.println(str1.replaceAll("l", "-"));
        System.out.println(str1);
    }

    public static void Stest2(){
        String str = "hello world hehe haha";
        String str1 = "hello:world::hehe:haha";
        String[] res = str1.split(":");
        int size = 0;
        for(String x : res){
            size++;
            System.out.println(x);
        }
        System.out.println("原串为: " + str1);
        System.out.println("有" + size + "个部分");

        // ip 地址表示方式为“点分十进制”
        // . 在正则表达式中，是一种特殊符号
        // 需要转义字符（两个\\，一个在 Java 中转义，一个在正则中转义）
        // | * + 也需要转义 \\
        String str2 = "192.168.1.0";
        String[] res1 = str2.split("\\.");
        for(String x : res1){
            System.out.println(x);
        }

        String str3 = "name=zahngsan&age=18&sex=male";
        // 1. 先按照 & 切分
        String[] res3 = str3.split("&");
        for(String tmp : res3){
            // tmp 形如 name=zhangsan
            // 2. 再按照 = 切分
            String[] tokens = tmp.split("=");
            if(tokens.length != 2){
                continue;
            }
            System.out.println(tokens[0] + ": " + tokens[1]);
        }
    }

    public static void Stest3(){
        // 字符串截取
        String str = "hello world";
        System.out.println(str.substring(5));
        // 前闭后开
        // Linux Shell 前闭后闭
        System.out.println(str.substring(5, 7));

        // 去掉左右空白字符
        // 空格 VS 空白字符（\t \n \f \v...）
        String str1 = "    hello    ";
        System.out.println("[" + str.trim() + "]");

        // 字符串转大写、小写
        String str2 = "HEllo";
        System.out.println(str2.toUpperCase());
        System.out.println(str2.toLowerCase());

        // 首字母大写
        // 先处理首字母
        String res = str2.substring(0, 1).toUpperCase() + str2.substring(1).toLowerCase();
        System.out.println(res);

        // 判空 空字符串
        String str11 = "";
        System.out.println(str11.isEmpty());

        // 空引用
        String str12 = null;
        System.out.println(str12.isEmpty());
    }

    public static void Stest4(){
//        String s = "hello";
//        s += "x";

        // StringBuilder 线程不安全
        // StringBuffer 线程安全（同步机制）加锁
        // 一旦代码加锁，代码性能较低
        // 结论：不使用多线程的场景下，推荐使用 StringBuilder；
        //      如果使用多线程，推荐使用StringBuffer
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello");
        stringBuilder.append("x");
        stringBuilder.append("x");
        stringBuilder.append("x");
        stringBuilder.append("x");

        // stringBuild 支持链式调用方法
        // 核心在于 append 返回值是 this
        //stringBuilder.append("hello").append("x").append("x").append("x");
        System.out.println(stringBuilder);

        // 逆置字符串
        StringBuilder stringBuilder1 = new StringBuilder("abcd");
        stringBuilder1.reverse().reverse();
        System.out.println(stringBuilder1);

        // 插入操作
        stringBuilder1.insert(1, "hehe");
        System.out.println(stringBuilder1);
        // 删除操作
        stringBuilder1.delete(1, 5);
        System.out.println(stringBuilder1);

        // 针对 String 往下标为 1 的位置插入一个 hehe
        String str = "abcd";
        String result = str.substring(0, 1) + "hehe" + str.substring(1);
        System.out.println(result);

        // 针对 String 删除 [1, 2) 范围内容
        String result1 = str.substring(0, 1) + str.substring(2);
        System.out.println(result1);
    }

    public static void main(String[] args) {
//        toCompare();
//        toFind();
//        Stest1();
        //Stest2();
        //Stest3();
        Stest4();
    }
}
