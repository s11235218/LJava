package Stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    public void push(int x) {
        A.push(x);
        if (B.isEmpty()) {
            B.push(x);
            return;
        }
        int min = B.peek();
        if (x < min) {
            min = x;
        }
        B.push(min);
    }

    public Integer pop() {
        if (A.isEmpty()) {
            return null;
        }
        B.pop();
        return A.pop();
    }

    public Integer top() {
        if (A.isEmpty()) {
            return null;
        }
        return A.peek();
    }

    public Integer getMin() {
        if (B.isEmpty()) {
            return null;
        }
        return B.peek();
    }
}
