package LinkedList;

public class LinkedList1 {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseElement(ListNode head, int val){
        if(head == null){
            return null;
        }

        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == val){
                prev.next = cur.next;
                cur = prev.next;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        if(head.val == val){
            head = head.next;
        }
        return head;
    }

    public boolean hasCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
