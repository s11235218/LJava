package LString;

import java.lang.reflect.Field;

public class StringTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        try{
            StringEquals();
        }catch(Exception e){
            System.out.println("空指针异常");
        }
        StringTest2();
        StringTest3();
        StringTest5();
    }

    public static void StringEquals(){
        String str1 = null;
        System.out.println(str1.equals("hehe"));
        // 推荐使用
        System.out.println("hehe".equals(str1));

    }

    public static void StringTest1(){
        String str1 = "hello";
        String str2 = new String("hello");
        char[] array = {'a', 'b', 'c'};
        String str3 = new String(array);
        String str4 = str3;

        //str3 = "haha";
        System.out.println(str4);
        System.out.println(str3 == str4);

        System.out.println(str3.equals(str4));
    }

    public static void StringTest2(){
        // 常用方式
        String str1 = "hehe";
        // String.intern 可以重复利用池中的对象
        String str2 = new String("hehe").intern();
        // true    String 字符常量池 共享设计模式
        // 执行 intern 方法，此时在池中查找内容相同的字符串常量。
        // 如果没找到，就把当前字符串加入常量池中
        // 如果已经找到，就返回这个池中对象的引用
        System.out.println(str1 == str2);
    }

    public static void StringTest3() throws NoSuchFieldException, IllegalAccessException {
        // String 不可变，很大程度上为了实现常量池
        // 假设 String 是可变对象，通过修改了 str1 ，也会影响 str2 的值
        // 1. 避免相互影响，设计成不可变
        // 2. 不可变对象是线程安全的
        // 3. 不可变对象的 hash code 也是不可变的
        // public final class String 中 final 关键字表示当前类不能被继承
        // 不可变实现方法：给这个类不提供相关的 setter 方法
        // 可以有特殊手段修改 String 对象内容：反射
        // 反射在 Java 中通过一组类和方法完成，起到效果能让一个对象更详细了解到一些特性
        String str = "hehe";
        // 对引用进行赋值 而不是内容

        // 反射能够破坏对象的封装(少用)：复杂、风险大

        // Field 对象对应到某个对象中的一个具体字段
        // String.class 获取到 String 这个类对象
        // 类加载：把 .class文件中的二进制指令，加载到内存中，同时生成一个对应类的对象，在这个类中包含一些关于这个类的信息
        // 每个类都有一个自己对应的类对象
        Field field = String.class.getDeclaredField("value");
        // 由于 String 中的 value 这个字符数组是 private 的，不可直接访问
        // 先将这个字段改为可访问的
        field.setAccessible(true);
        // 获取到 str 中的 value 数组的内容
        char[] value = (char[])field.get(str);

        value[0] = 'a';

        System.out.println(str);

//        for (int i = 0; i < value.length; i++) {
//            System.out.println(value[i]);
//        }
    }

    public static void StringTest4(){
        // 一共多少个字符串对象：
        String str = "hello";
        for(int x = 0; x < 1000; x++){
            // 每次 += 都会得到一个新的 String 对象（不可变） 比较低效、尽量避免
            str += x;
        }
    }

    public static void StringTest5(){
        String str = "hello";
        // 获取这个字符串的某个字符
        for (int i = 0; i < str.length(); i++) {
            // 下标越界也会抛出异常
            System.out.println(str.charAt(i));
        }

        // 字符串转字符数组
        // toCharArray 是把 String 中包含的字符数组给拷贝了一份
        char[] data = str.toCharArray();
        // 此时修改 data 内容不会影响到 str
        data[0] = 'a';
        System.out.println(str);

        // 字符数组转字符串
        // 借助 String 的构造方法
        char[] arrays = {'a', 'b', 'c'};
        String str1 = new String(arrays);
        System.out.println(str1);

        // 实现 判断某个字符是否全部由数字构成 123-true
        System.out.println(isNumber("1234"));
        System.out.println(isNumber("123a"));
    }

    // 实现 判断某个字符是否全部由数字构成 123-true
    public static boolean isNumber(String str){
        // 获取到每一个字符
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c < '0' || c > '9'){
                return false;
            }
        }
        return true;
    }
}
