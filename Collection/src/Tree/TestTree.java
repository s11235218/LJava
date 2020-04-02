package Tree;

public class TestTree {
    static class TreeNode{
        private char val;
        private TreeNode right;
        private TreeNode left;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree(){
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');
        TreeNode h = new TreeNode('H');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        g.right = h;
        c.right = f;

        return a;
    }

    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }

    public static void afterOrder(TreeNode root){
        if(root == null){
            return;
        }
        afterOrder(root.left);
        afterOrder(root.right);
        System.out.print(root.val);
    }

    public static int size(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    public static int leafSize(TreeNode root){
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
    public static int kLevelSize(TreeNode root, int k){
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
    public static TreeNode find(TreeNode root, char toFind){
        if(root == null){
            return null;
        }
        // 此处访问是比较操作
        if(root.val == toFind){
            return root;
        }
        // 分别在左右子树遍历
        TreeNode res = find(root.left, toFind);
        if(res != null) {
            return res;
        }
        return find(root.right, toFind);
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();
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
