package linkList;

public class Test {
    private static void testAddFirst(){
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
    }

    private static void testAddLast() {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.display();
    }

    private static void testAddIndex(){
        LinkedList linkedList = new LinkedList();
        //1, 4, 3, 2
        linkedList.addIndex(0, 1);
        linkedList.addIndex(1, 2);
        linkedList.addIndex(1, 3);
        linkedList.addIndex(1, 4);
        linkedList.display();
    }
    private static void testContains(){
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        System.out.println(linkedList.contains(2));
    }

    private static void testRemove(){
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.remove(3);
        //1, 2, 4
        linkedList.display();
    }
    public static void main(String[] args) {
        //testAddFirst();
        //testAddLast();
        //testAddIndex();
        //testContains();
        testRemove();
    }
}
