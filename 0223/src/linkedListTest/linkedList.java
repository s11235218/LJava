//package linkedListTest;
//
//public class LinkedList {
//    static class Node{
//        int val;
//        Node next = null;
//
//        public Node(int val) {
//            this.val = val;
//        }
//    }
//
//    public LinkedList ListNode(LinkedList head,int val){
//        if(head == null){
//            return null;
//        }
//        Node head = null;
//        Node prev = head;
//        Node cur = head.next;
//        while(cur !=null){
//            if(cur.val == val){
//                prev.next = cur.next;
//                cur = prev.next;
//            }else{
//                prev = cur;
//                cur = cur.next;
//            }
//        }
//        if(head.val ==val){
//            head = head.next;
//        }
//        return head;
//    }
//    public LinkedList reverseList(LinkedList head){
//        if (head ==null){
//            return null;
//        }
//        if(head.next == null){
//            return head;
//        }
//        LinkedList cur = head;
//        LinkedList prev = null;
//        LinkedList newHead = null;
//        while(cur != null){
//            LinkedList next = cur.next;
//            if(next == null){
//                newHead = cur;
//            }
//            cur.next = prev;
//            prev = cur;
//            cur = next;
//        }
//        return newHead;
//    }
////    public LinkedList FindKthToTail(LinkedList head, int k){
////        if(head == null){
////            return null;
////        }
////
////    }
//}