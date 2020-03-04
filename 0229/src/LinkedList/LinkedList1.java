package LinkedList;

public class LinkedList1 {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead){
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        for(ListNode cur = pHead; cur != null; cur = cur.next){
            if (cur.next != null && cur.val == cur.next.val){
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
            }else{
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
            }
        }
        return newHead.next;
    }

    public boolean hasCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
