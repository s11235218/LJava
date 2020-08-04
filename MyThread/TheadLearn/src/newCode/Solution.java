package newCode;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (input.length <= 0 || k <= 0) {
            return result;
        }
        if (input.length < k) {

            for (int i = 0; i < input.length - 1; i++) {
                for (int j = 0; j < input.length - i - 1; j++) {
                    if (input[j + 1] < input[j]) {
                        int tmp = input[j + 1];
                        input[j + 1] = input[j];
                        input[j] = tmp;
                    }
                }
            }

            for (int i = 0; i < k; i++) {
                result.add(input[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetLeastNumbers_Solution(input, 4));
    }
}
