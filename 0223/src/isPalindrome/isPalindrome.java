package isPalindrome;

public class isPalindrome {
    public static boolean isPalindrome(String s) {
        int length = s.length();
        StringBuilder new_s = new StringBuilder();
        for(int i = 0;i < length;i++){
            char ch = s.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                ch += 32;
            }
            if(ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9'){
                new_s.append(ch);
            }
        }
        for(int i = 0, j = new_s.length() - 1; i < j; i++, j--){
            if(new_s.charAt(i) != new_s.charAt(j))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
