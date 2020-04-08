package SortL;

import java.util.Arrays;

public class TestSort {
    // 插入排序
    public static void insertSort(int[] array) {
        // [0, bound) 已排序区间
        for (int bound = 1; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - 1; // 已排序区间最后一个下标
            for (; cur >= 0; cur--) {
                if(array[cur] > v) {
                    array[cur + 1] = array[cur];
                } else {
                    // 不需要搬运
                    break;
                }
            }
            array[cur + 1] = v;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 3, 6, 8};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
