package SortL;

import java.util.Arrays;

public class TestSort {
    // 1. 插入排序 稳定排序
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

    // 2. 希尔排序 不稳定排序
    // 步长 + 插入排序
    public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 1) {
            insertSortGap(array, gap);
            gap = gap / 2;
        }
        insertSortGap(array, gap);
    }

    // 步长不定的希尔排序
    private static void insertSortGap(int[] array, int gap) {
        for (int bound = gap; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - gap; // 已排序区间最后一个下标
            for (; cur >= 0; cur -= gap) {
                if(array[cur] > v) {
                    array[cur + gap] = array[cur];
                } else {
                    // 不需要搬运
                    break;
                }
            }
            array[cur + gap] = v;
        }
    }

    // 3. 选择排序 不稳定排序
    public static void selectSort(int[] array) {
        int size = array.length;
        for (int bound = 0; bound < size; bound++) {
            for (int cur = bound + 1; cur < size; cur++) {
                if(array[bound] > array[cur]) {
                    int tmp = array[bound];
                    array[bound] = array[cur];
                    array[cur] = tmp;
                }
            }
        }
    }

    // 4. 堆排序 不稳定排序
    public static void heapSort(int[] array) {
        // 建堆
        createHeap(array);
        // 循环交换堆顶元素和最后元素 调整堆
        // 循环次数 当堆中只剩一个元素，就不需调整
        for (int i = 0; i < array.length - 1; i++) {
            // 交换
            // 堆元素个数相当于 array.length - 1
            // 堆最后一个下标 array.length - 1 - i
            swap(array, 0, array.length - 1 - i);

            // 交换后删除最后一个元素
            // 堆长度减小
            // 待排序[0, array.length - 1 - i)
            // 已排序[array.length - 1 - i, array.length)
            shiftDown(array, array.length - 1 - i, 0);
        }
    }

    // 向下调整
    private static void shiftDown(int[] array, int heapLength, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < heapLength) {
            if(child + 1 < heapLength && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if(array[child] > array[parent]) {
                swap(array, child, parent);
            } else {
                break;
            }
            parent = child;
            child = 2 * child + 1;
        }
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    // 建堆
    private static void createHeap(int[] array) {
        // 从最后一个非叶子节点出发 向前循环
        for (int i = (array.length - 1 - 1) / 2; i >= 0 ; i++) {
            shiftDown(array, array.length, i);
        }
    }

    // 5. 冒泡排序 稳定排序
    public static void bubbleSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = array.length - 1; cur > bound; cur--) {
                if(array[cur - 1] > array[cur]) {
                    swap(array, cur - 1, cur);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 3, 6, 8};
        // insertSort(arr);
        // selectSort(arr);
        heapSort(arr);
        // bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
