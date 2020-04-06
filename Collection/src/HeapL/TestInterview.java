package HeapL;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    public int n1;
    public int n2;
    public int sum;

    public Pair(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
        this.sum = n1 + n2;
    }

    @Override
    public int compareTo(Pair o) {
        // this < other return < 0
        // this > other return > 0
        // this = other return = 0
        return this.sum - o.sum;
    }
}

public class TestInterview {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }
        // 前 k 小元素 建小堆
        PriorityQueue<Pair> queue = new PriorityQueue<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                queue.offer(new Pair(nums1[i], nums2[j]));

            }
        }
        // 循环结束后 所有数对都在优先级队列中
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            Pair cur = queue.poll();
            List<Integer> tmp = new ArrayList<>();
            tmp.add(cur.n1);
            tmp.add(cur.n2);
            result.add(tmp);
        }
        return result;
    }
}
