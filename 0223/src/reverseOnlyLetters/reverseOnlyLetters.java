package reverseOnlyLetters;

public class reverseOnlyLetters {
    public static String reverseOnlyLetters(String S) {
        //当只有0个和一个字符时，直接返回
        if (S == null || S.length() < 2) {
            return S;
        }
        char[] chars = S.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (left < right && (chars[left] < 'A' || (chars[left] > 'Z'
                    && chars[left] < 'a') || chars[left] > 'z')) {
                left++;
            }
            while (left < right && (chars[right] < 'A' || (chars[right] > 'Z'
                    && chars[right] < 'a') || chars[right] > 'z')) {
                right--;
            }
            if(left < right) {
                chars[left] ^= chars[right];
                chars[right] ^= chars[left];
                chars[left++] ^= chars[right--];
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
    }
}
