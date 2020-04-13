package Set;

import java.util.HashMap;
import java.util.Map;

public class TestInterview2 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        // 1. 遍历旧链表 key 是旧链表节点 value 是新链表节点
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null ; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        // 2. 再次循环
        for (Node cur = head; cur != null ; cur = cur.next) {
            // 先找到 map 中的该 cur 对应的新链表的节点
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
        }
        // 返回新链表的头节点
        return map.get(head);
    }
}
