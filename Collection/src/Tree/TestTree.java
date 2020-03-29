package Tree;

public class TestTree {
    static class Node{
        private char val;
        private Node right;
        private Node left;

        public Node(char val) {
            this.val = val;
        }
    }

    public static Node buildTree(){
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        g.right = h;
        c.right = f;

        return a;
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }

    public static void afterOrder(Node root){
        if(root == null){
            return;
        }
        afterOrder(root.left);
        afterOrder(root.right);
        System.out.print(root.val);
    }

    public static int size(Node root){
        if(root == null){
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    public static int leafSize(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);
    }

    // 求二叉树第 k 层节点个数
    // 如果 k < 1 只能是空树，返回 0
    // 如果 k == 1 求根节点个数，返回 1
    // k 层节点个数 = 左子树的 k - 1 层节点个数 + 右子树的 k - 1 层节点个数
    public static int kLevelSize(Node root, int k){
        if(k < 1 || root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return kLevelSize(root.left, k - 1) + kLevelSize(root.right, k - 1);
    }

    // 在二叉树中查找指定元素
    // 如果存在就返回该节点引用，如果不存在，就返回 null
    public static Node find(Node root, char toFind){
        if(root == null){
            return null;
        }
        // 此处访问是比较操作
        if(root.val == toFind){
            return root;
        }
        // 分别在左右子树遍历
        Node res = find(root.left, toFind);
        if(res != null) {
            return res;
        }
        return find(root.right, toFind);
    }

    public static void main(String[] args) {
        Node root = buildTree();
        System.out.print("先序遍历：");
        preOrder(root);
        System.out.println();

        System.out.print("中序遍历：");
        inOrder(root);
        System.out.println();

        System.out.print("后序遍历：");
        afterOrder(root);
        System.out.println();

        System.out.println(leafSize(root));
    }
}
