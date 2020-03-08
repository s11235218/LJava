package LinkedList;
import LinkedList.LinkedList.ListNode;

public class LinkedList0308 {

    public ListNode deleteDuplication(ListNode pHead){
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;

        ListNode cur = pHead;
        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                cur = cur.next;
            }else{
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}
