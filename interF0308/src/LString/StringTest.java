package LString;

public class StringTest {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        char[] array = {'a', 'b', 'c'};
        String str3 = new String(array);
        String str4 = str3;

        //str3 = "haha";
        System.out.println(str4);
        System.out.println(str3 == str4);

        System.out.println(str3.equals(str4));
        StringEquals();
    }

    public static void StringEquals(){
        String str1 = null;
        System.out.println(str1.equals("hehe"));
        // 推荐使用
        System.out.println("hehe".equals(str1));

    }
}
