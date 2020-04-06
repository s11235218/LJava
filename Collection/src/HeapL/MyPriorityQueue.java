package HeapL;

import static HeapL.Heap.shiftDown;

public class MyPriorityQueue {
    // 堆结构
    private int[] array = new int[100];
    private int size = 0;

    public void offer(int x) {
        array[size] = x;
        size++;
        // 新加元素向上调整
        shiftUp(array, size - 1);
    }

    private static void shiftUp(int[] array, int index) {
        int child = index;
        int parent = (child - 1) / 2;
        while(child > 0) {
            if(array[parent] < array[child]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            } else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    public int poll() {
        // 下标为 0 是队首元素 删掉后 仍然是堆
        // 数组最后一个值赋值给堆顶元素 然后 size-- 然后向下调整
        int oldValue = array[0];
        array[0] = array[size - 1];
        size--;
        shiftDown(array, size, 0);
        return oldValue;
    }

    public int peek() {
        return array[0];
    }

    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue();
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        queue.offer(8);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");
        }
    }

    private boolean isEmpty() {
        return size == 0;
    }
}
