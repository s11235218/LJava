package Stack;

import java.util.Stack;

public class MyQueueBy2Stack {
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    public void push(int x) {
        while (!B.isEmpty()) {
            int tmp = B.pop();
            A.push(tmp);
        }
        A.push(x);
    }

    public Integer pop() {
        if (empty()) {
            return null;
        }
        while (!A.isEmpty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        return B.pop();
    }

    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }

    public Integer peek() {
        if (empty()) {
            return null;
        }
        while (!A.isEmpty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        return B.peek();
    }
}
