package linkedListTest;

public class LinkedList {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null) {
            return pHead;
        }
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;

        for (ListNode cur = pHead; cur != null; cur = cur.next) {
            if (cur.val < x) {
                // 插入到 smallTail 后面, 创建崭新的节点(新节点的 next 一定是 null)
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            } else {
                // 插入到 bigTail 的后面
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
        }

        // 将两个链表收尾相接到一起
        smallTail.next = bigHead.next;
        return smallHead.next;
    }
}
