package LinkedList;

public class LinkedList2 {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public int listSize(ListNode head){
        int size = 0;
        ListNode cur = head;
        while(cur != null){
            size++;
            cur = cur.next;
        }
        return size;
    }

    public boolean chkPalindrome(ListNode A) {
        //找到中间节点
        int size = listSize(A);
        int steps = size / 2;
        ListNode B = A;
        for(int i = 0; i < steps; i++){
            B = B.next;
        }
        //逆置B后面的链表
        ListNode prev = null;
        ListNode cur = B;
        while(cur != null){
            ListNode next = cur.next;
            if(next == null){
                B = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // 判断A、B是否相等
        while(B != null){
            if(A.val != B.val){
                return false;
            }
            A = A.next;
            B = B.next;
        }
        return true;
    }

    public ListNode newList(){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;

        return a;
    }

}
