public class ToLowerCase {
     static public String ToLowerCase(String str) {
        //把字符串转为char字符数组
        char[] s = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (s[i] >= 'A' && s[i] <= 'Z') {
                s[i] += 32;
            }
        }
        return new String(s);
    }
}
