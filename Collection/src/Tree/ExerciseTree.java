package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class ExerciseTree {
    // 二叉树先序遍历 把结果放在 ArrayList 中
    public List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        // 访问根节点
        result.add(root.val);
        result.addAll(preOrderTraversal(root.left));
        result.addAll(preOrderTraversal(root.right));
        return result;
    }

    public List<Integer> inOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        result.addAll(inOrderTraversal(root.left));
        result.add(root.val);
        result.addAll(inOrderTraversal(root.right));
        return result;
    }

    public List<Integer> postOrderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        result.addAll(postOrderTraversal(root.left));
        result.addAll(postOrderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    public boolean isSameTree(TreeNode p, TreeNode q){
        // 分成四种情况
        // p, q null
        // p null
        // q null
        // 都不为 null
        if(p == null && q == null){
            return true;
        }
        // if((p == null && q != null) || (p != null && q == null))
        if(p == null || q == null){
            return false;
        }
        // 都不为空的情况
        // 先判断根节点是否相同
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSubTree(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        boolean ret = false;
        if(s.val == t.val){
            // 如果两树根节点相同，就进一步判定是否相同
            ret = isSameTree(s, t);
        }
//        if(!ret){
//            // s, t 不相同，进一步看 s.left 是否包含 t
//            ret = isSubTree(s.left, t);
//        }
//        if(!ret){
//            // s, t 不相同，进一步看 s.right 是否包含 t
//            ret = isSubTree(s.right, t);
//        }
//        return ret;
        return ret || isSubTree(s.left, t) || isSubTree(s.right, t);
    }

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
         //return 1 + (Math.max(maxDepth(root.left), maxDepth(root.right)));
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }

    public static boolean isBalanced(TreeNode root) {
        // 判断一棵二叉树是否平衡
        // 1. 空树，没有子树：平衡
        // 2. 针对当前节点，求左右子树高度，看差值是否大于 1
        // 3. 递归判定该树左右子树是否平衡
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        // 看当前节点对应的子树是否平衡
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if((t2 == null) && (t1 == null)){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        if(t1.val != t2.val){
            return false;
        }
        return isMirror(t1.left, t2.right) && isMirror(t2.left, t1.right);
    }

    public void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.println(cur.val + " ");
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }

    public static TreeNode buildTree(){
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        TreeNode I = new TreeNode('I');
        TreeNode J = new TreeNode('J');
        TreeNode K = new TreeNode('K');
        TreeNode L = new TreeNode('L');
        TreeNode Z = new TreeNode('Z');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        D.left = F;
        D.right = G;
        F.left = Z;
        E.left = H;
        E.right = I;
        C.left = K;
        C.right = L;
        K.left = J;

        TreeNode root = A;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();
        System.out.println(isBalanced(root));
    }

    // 判断完全二叉树
    public boolean InterviewTree(TreeNode root){
        if(root == null){
            return true;
        }
        boolean isSecondStep = false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();

            if(!isSecondStep){
                if(cur.left != null && cur.right != null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if(cur.left == null && cur.right != null){
                    return false;
                } else if(cur.left != null && cur.right == null){
                    isSecondStep = true;
                    queue.offer(cur.left);
                } else{
                    isSecondStep = true;
                }
                // 第二阶段
                // 要求任何一个节点都没有子节点
                if(cur.left != null || cur.right != null){
                    return false;
                }
            }
        }
        return true;
    }
}
