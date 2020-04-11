package SortL;

import java.util.Arrays;
import java.util.Stack;

import static SortL.TestSort.swap;

public class TestSort1 {
    // 快速排序 不稳定排序（递归）
    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if(left >= right) {
            // 有 0 个或 1 个元素 直接返回
            return;
        }
        // index 是 left 和 right 重合的位置
        int index = partition(array, left, right);
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int base = array[right];

        while (i < j) {
            // 从左往右找到比基准值大的
            // 循环结束时，i 要么和 j 重合，要么 i 指向一个大于 base 的值
            while (i < j && array[i] <= base) {
                i++;
            }
            // System.out.println("");

            // 从右往左找比基准值小的
            // 循环结束时，i 要么和 j 重合，要么 i 指向一个大于 base 的值
            while (i < j && array[j] >= base) {
                j--;
            }
            swap(array, i, j);
        }
        // System.out.println("");

        // i j 重合后 把重合位置元素和基准值元素交换
        swap(array, i, right);
        return i;
    }

    public static void quickSortByLoop(int[] array) {
        // 借助栈 stack 用来存放数组下标 通过下标表示接下来需调整的区间
        Stack<Integer> stack = new Stack<>();
        // 初始情况下 先右侧边界下标入栈 后左侧边界下标入栈
        stack.push(array.length - 1);
        stack.push(0);

        while (!stack.isEmpty()) {
            // 这个取元素与 push 顺序相反
            int left = stack.pop();
            int right = stack.pop();
            if(left >= right) {
                continue;
            }

            // [index + 1, right]
            int index = partition(array, left, right);
            stack.push(right);
            stack.push(index + 1);

            // [left, index - 1]
            stack.push(index - 1);
            stack.push(left);
        }
    }

    // [low, mid)
    // [mid, high)
    // 归并排序 稳定排序
    public static void merge(int[] array, int low, int mid, int high) {
        int[] output = new int[high - low];
        int outputIndex = 0; // 记录当前 output 数组中放入多少个元素
        int cur1 = low;
        int cur2 = mid;

        while (cur1 < mid && cur2 < high) {
            // = 是为了保证稳定性
            if (array[cur1] <= array[cur2]) {
                output[outputIndex] = array[cur1];
                outputIndex++;
                cur1++;
            } else {
                output[outputIndex] = array[cur2];
                outputIndex++;
                cur2++;
            }
        }
        // 当循环结束，cur1 cur2 有一个先结束 另一个剩下的直接 copy 到 output 中
        while (cur1 < mid) {
            output[outputIndex] = array[cur1];
            outputIndex++;
            cur1++;
        }

        while (cur2 < high) {
            output[outputIndex] = array[cur2];
            outputIndex++;
            cur2++;
        }
        // output 搬运回去
        for (int i = 0; i < high - low; i++) {
            array[low + i] = output[i];
        }
    }

    public static void mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length);
    }

    // [low, high) high - low <= 1 区间只有 0 或 1 个元素
    private static void mergeSortHelper(int[] array, int low, int high) {
        if (high - low <= 1) {
            return;
        }
        int mid = (low + high) / 2;
        // 递归完 就分别认为 [low, mid) [mid, high) 有序
        mergeSortHelper(array, low, mid);
        mergeSortHelper(array, mid, high);

        merge(array, low, mid, high);
    }

    // 非递归 归并排序
    public static void mergeSortByLoop(int[] array) {
        // 引入 gap 变量进行分组（步长）
        // 当 gap = 1 时 [0][1]   [2][3]   [4][5]   [6][7] ...分别合并
        // 当 gap = 2 时 [0, 1][2, 3]   [4, 5][6, 7] ...分别合并
        // 当 gap = 4 时 [0, 1, 2, 3]   [4, 5, 6, 7] ...分别合并
        for (int gap = 0; gap < array.length; gap *= 2) {
            // 具体分组合并
            for (int i = 0; i < array.length; i += 2 * gap) {
                // 当前相邻组
                // [beg, mid)[mid, end)
                // beg => i  mid => i + gap  end => i + 2 * gap
                int beg = i;
                int mid = i + gap;
                int end = i + 2 * gap;
                if (mid > array.length) {
                    mid = array.length;
                }
                if (end > array.length) {
                    end = array.length;
                }
                merge(array, beg, mid, end);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        // quickSort(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
