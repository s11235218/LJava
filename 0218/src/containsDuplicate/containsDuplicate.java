package containsDuplicate;

import java.util.Arrays;


public class containsDuplicate {
    //双重循环，超时！
    public static boolean containsDuplicate(int[] nums){
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    //先排序，后判断元素与其前一个元素是否相等
    //如果相等，返回true，如果不相等，返回false
    //BubbleSort是一个冒泡排序
    public static boolean containsDuplicate1(int[] nums){

        int[] new_nums = BubbleSort(nums);
        for(int i = 0; i < new_nums.length - 1; i++){
            if(new_nums[i] == new_nums[i+1]){
                return true;
            }
        }
        return false;
    }
    //先排序，后判断元素是否相等
    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }
    //冒泡排序
    //双重循环排列相邻元素大小，并按顺序排序
    //写这个单纯为了练手
    public static int[] BubbleSort(int[] array)
    {
        int a = array.length;
        for(int i = 0; i < a; i++) {
            for (int j = 0; j < a - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(BubbleSort(nums)));
        System.out.print(containsDuplicate2(nums));
    }
}
