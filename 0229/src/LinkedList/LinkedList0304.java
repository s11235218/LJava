package LinkedList;

public class LinkedList0304 {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public int Size(ListNode head){
        int size = 0;
        for(ListNode cur = head; cur != null; cur = cur.next){
            size++;
        }
        return size;
    }

    public ListNode FindkthToTail(ListNode head, int k){
        if(head == null){
            return null;
        }
        int size = Size(head);
        if(k <= 0 || k > size){
            return null;
        }
        int steps = size - k;
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public ListNode reverseList(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode newHead = null;
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            if(cur.next == null){
                newHead = cur;
            }
            cur.next = prev;
        }
        return newHead;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != null && cur2 != null){
            if(cur1.val < cur2.val){
                newTail.next = cur1;
                newTail = newTail.next;
                cur1 = cur1.next;
            } else{
                newTail.next = cur2;
                newTail = newTail.next;
                cur2 = cur2.next;
            }
            if(cur1 == null){
                newTail.next = cur2;
            }else{
                newTail.next = cur1;
            }
        }
        return newHead.next;
    }

}
