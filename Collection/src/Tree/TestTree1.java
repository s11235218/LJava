package Tree;

public class TestTree1 {
    class TreeNode{
        private int val;
        private TreeNode right;
        private TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode Ica = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        findNode(root, p, q);
        return Ica;
    }

    private boolean findNode(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        int left = findNode(root.left, p, q) ? 1 : 0;
        int right = findNode(root.left, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        // 如果结果 == 0 当前 root 一定不是 p q 的最近公共祖先
        // == 1 当前 root 可能是 p 也可能是 q 的公共节点 但一定不是最近公共节点
        // == 2 当前 root 是 p q 的最近公共祖先
        // == 3 不可能出现的结果
        if(left + right + mid == 2){
            Ica = root;
        }
        return (left + right + mid) > 0;
    }

    // 二叉排序树
    public TreeNode Convert(TreeNode pRootOfTree){
        // 基于递归的方式完成双向链表 保证有序性 需要中序遍历
        if(pRootOfTree == null){
            return null;
        }
        if(pRootOfTree.left == null && pRootOfTree.right == null){
            return pRootOfTree;
        }
        // 最终链表 = 左子树链表 + 根节点 + 右子树链表

        // 1. 首先递归处理左子树
        TreeNode left = Convert(pRootOfTree.left);
        // 2. 找到左子树链表的尾节点
        TreeNode leftTail = left;
        while(leftTail != null && leftTail.right != null){
            leftTail = leftTail.right;
        }
        // 循环结束后 leftTail 就指向了左侧链表的尾部
        // 3. 把左子树和当前节点连在一起
        if(left != null){
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        // 4. 递归转换右子树，把右子树变成双向链表
        TreeNode right = Convert(pRootOfTree.right);
        // 5. 把当前节点和右子树连在一起
        if(right != null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        // 6. 最终返回头节点
        return left == null ? pRootOfTree : left;
    }

    private int index; // 当前访问到先序遍历的第几个结果
    public TreeNode buildTree(int[] preorder, int[] inorder){
        index = 0;
        return buildTreeHelper(preorder, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right) {
        if(left >= right){
            // 中序遍历结果为空
            return null;
        }
        if(index >= preorder.length){
            // 遍历元素结束
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        index++;

        int pos = find(inorder, left, right, root.val);
        root.left = buildTreeHelper(preorder, inorder, left, pos);
        root.right = buildTreeHelper(preorder, inorder, pos + 1, right);
        return root;
    }

    private int find(int[] inorder, int left, int right, int toFind){
        for (int i = 0; i < right; i++) {
            if(inorder[i] == toFind){
                return i;
            }
        }
        return -1;
    }

    private StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode t){
        if(t == null){
            return "";
        }
        helper(t);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void helper(TreeNode t) {
        if(t == null){
            return;
        }
        // 访问根节点，此处访问操作追加字符串 sb 中
        sb.append("(");
        sb.append(t.val);
        helper(t.left);
        if(t.left == null && t.right != null){
            // 左子树为空，右子树非空
            // 加上（）占位
            sb.append("()");
        }
        helper(t.right);
        sb.append(")");
    }

}
