package sortArrayByParity;

import java.util.Arrays;

public class sortArrayByParity {
    public static int[] sortArrayByParity(int[] A){
        int[] res = new int[A.length];
        int tmp = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] % 2 == 0){
                res[tmp++] = A[i];
            }
        }
        for (int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 1){
                res[tmp++] = A[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 4, 6, 4, 3, 5, 8};
        System.out.println(Arrays.toString(sortArrayByParity(A)));
    }
}
