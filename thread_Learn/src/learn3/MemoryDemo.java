package learn3;

public class MemoryDemo {

    public static class Node {
        private String name;
        private Node next;

        public Node(String name) {
            this.name = name;
        }
    }

    public static int Fib(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fib(n) - Fib(n - 1);
    }

    public static void t2(Node node) {
        node.next = new Node("B");
        node = new Node("C");
    }

    public static void main(String[] args) {
        Node node = new Node("A");
        t2(node);
        System.out.println(node.name);
        System.out.println(node.next.name);
    }

}
