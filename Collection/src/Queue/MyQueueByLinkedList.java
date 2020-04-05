package Queue;

public class MyQueueByLinkedList {
    // 内部类 创建 Node
    // 不依赖 MyQueueLinkedList 这个类的实例
    static class Node {
        public int val;
        Node next = null;

        public Node(int val) {
            this.val = val;
        }
    }

    // 创建链表
    private Node head = null;
    private Node tail = null;

    // 入队列
    public void offer(int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = tail.next;
    }

    // 出队列
    public Integer poll() {
        if(head == null) {
            // 返回错误值
            return null;
        }
        int ret = head.val;
        head = head.next;
        if(head == null) {
            // 删除当前元素后，队列变成空队列
            tail = null;
        }
        return ret;
    }

    // 取队首元素
    public Integer peek() {
        if(head == null) {
            return null;
        }
        return head.val;
    }
}
