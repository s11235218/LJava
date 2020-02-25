package plusOne;

import java.util.Arrays;

public class plusOne {
    public static int[] plusOne(int[] digits){
        int len = digits.length;
        for(int i = len - 1;i >= 0;i--) {
            if(digits[i] != 9) {
                digits[i] += 1;
                break;
            }else {
                digits[i] = 0;
                if(i == 0) {
                    digits = new int[len + 1];
                    digits[0] = 1;
                }
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{1, 2, 3};
        System.out.println(plusOne(digits));
    }
}
