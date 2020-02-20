package isPalindrome;

public class isPalindrome {
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x > 0 && x < 10){
            return true;
        }
        int tmp = 0;
        int num = x;
        while (num!=0){
            tmp = tmp * 10 + num % 10;
            num = num / 10;
        }
        if(tmp == x){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        System.out.print(isPalindrome(121));

    }
}
