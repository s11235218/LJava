package Merge;

import java.util.Arrays;

public class merge {
    public static int[] merge(int[] nums1, int m, int[] nums2, int n){
        int right1 = m - 1;
        int right2 = n - 1;
        int len = m + n - 1;
        while(right1 >= 0 && right2 >= 0)
        {
            if(nums1[right1] >= nums2[right2]) {
                nums1[len--] = nums1[right1--];
            }else {
                nums1[len--] = nums2[right2--];
            }
        }
        while(right2 >= 0) {
            nums1[len--] = nums2[right2--];
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 4, 0, 0, 0};
        int[] nums2 = new int[]{2, 3, 5};
        System.out.println(Arrays.toString(merge(nums1, 3, nums2, 3)));
    }
}
