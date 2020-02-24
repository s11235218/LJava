package sortedSquares;

import java.util.Arrays;

public class sortedSquares {
    public static int[] sortedSquares(int[] A){
        for(int i = 0; i < A.length; i++){
            //当元素大于0时，元素平方后不改变递增顺序
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public static void main(String[] args) {
        int[] A = new int[]{-1, 0, 1, 2, 4, 5, 6};
        sortedSquares(A);
    }
}