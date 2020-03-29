package Tree;

import java.util.ArrayList;
import java.util.List;

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
}
