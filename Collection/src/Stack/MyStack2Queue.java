package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack2Queue {
    private Queue<Integer> A = new LinkedList<>();
    private Queue<Integer> B = new LinkedList<>();

    public void push(int x) {
        A.offer(x);
    }

    public Integer pop() {
        if (empty()) {
            return null;
        }
        while (A.size() > 1){
            Integer front = A.poll();
            B.offer(front);
        }
        int ret = A.poll();
        swapAB();
        return ret;
    }

    private void swapAB() {
        Queue<Integer> tmp = A;
        A = B;
        B = tmp;
    }

    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }

    public Integer top() {
        if (empty()) {
            return null;
        }
        while (A.size() > 1){
            Integer front = A.poll();
            B.offer(front);
        }
        int ret = A.poll();
        B.offer(ret);
        swapAB();
        return ret;
    }
}
