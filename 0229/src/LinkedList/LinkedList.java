package LinkedList;

public class LinkedList {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ListNode(ListNode head, int val){
        //判空
        if(head == null){
            return null;
        }
        //先删除中间节点 prev 始终指向 cur 前一个位置
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
        //最后考虑删除头节点
        if(head.val ==val){
            head = head.next;
        }
        return head;
    }

    public ListNode reverseList(ListNode head){
        //判空
        if (head == null){
            return null;
        }
        //当只有一个节点时
        if(head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        ListNode newHead = null;
        while(cur != null){
            ListNode next = cur.next;
            if(next == null){
                newHead = cur;
            }
            //逆置操作
            cur.next = prev;
            //更新指向位置
            prev = cur;
            cur = next;
        }
        return newHead;
    }

    public int size(ListNode head){
        int size = 0;
        ListNode cur = head;
        while(cur != null){
            size++;
            cur = cur.next;
        }
        return size;
    }

    public ListNode FindKthToTail(ListNode head, int k){
        if(head == null){
            return null;
        }
        int size = size(head);
        if(k <= 0 || k > size){
            return null;
        }
        int steps = size - k;
        ListNode cur = head;
        for(int i = 0; i < steps; i++){
            cur = cur.next;
        }
        return cur;
    }

    public ListNode middleNode(ListNode head){
        int steps = size(head) / 2;
        ListNode cur = head;
        for(int i = 0; i < steps; i++){
            cur = cur.next;
        }
        return cur;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != cur2 && cur2 != null){
            if(cur1.val < cur2.val){
                newTail.next = cur1;
                newTail = newTail.next;
                cur1 = cur1.next;
            }else{
                newTail.next = cur2;
                newTail = newTail.next;
                cur2 = cur2.next;
            }
            //循环结束
            if(cur1 == null){
                newTail.next = cur2;
            }else{
                newTail.next = cur1;
            }
        }
        return newHead.next;
    }

    public ListNode partition(ListNode pHead, int x){
        if(pHead == null){
            return null;
        }
        if(pHead.next == null){
            return pHead;
        }
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;

        for(ListNode cur = pHead; cur != null; cur = cur.next){
            if(cur.val < x){
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            }else{
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }

    public ListNode newList(){
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(7);
        ListNode e = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;

        return a;
    }

    public void partitionTest(){
        int x = 4;
        ListNode res = partition(newList(), x);
        for (ListNode cur = res; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }

    public void chkPalindromeTest(){
        LinkedList2 test2 = new LinkedList2();
        System.out.println(test2.chkPalindrome(test2.newList()));
    }

    public static void main(String[] args){
        LinkedList test = new LinkedList();
        //test.partitionTest();
        test.chkPalindromeTest();
    }
}