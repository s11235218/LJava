package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuildTree {
    static class TreeNode{
        private int val;
        private TreeNode right;
        private TreeNode left;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            // abc##de#g##f###
            String line = scanner.next();
            TreeNode root = build(line);
            inOrder(root);
            System.out.println();
        }
    }

    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }

    private static int index = 0;
    private static TreeNode build(String line){
        index = 0;
        return createTreePreOrder(line);
    }

    private static TreeNode createTreePreOrder(String line){
        // 获取到当前处理到哪个节点
        char cur = line.charAt(index);
        if(cur == '#'){
            return null;
        }
        // 当前字符不是 # 就创建一个节点
        TreeNode root = new TreeNode(cur);
        index++; // 准备下一个节点 下一个节点开始就是当前 root 左子树先序遍历的结果
        root.left = createTreePreOrder(line);
        index++;
        root.right = createTreePreOrder(line);
        return root;
    }

    private void helper(TreeNode root, int level){
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        // 把当前节点添加到 result 中合适位置

//        List<Integer> row = result.get(level);
//        row.add(root.val);

        result.get(level).add(root.val);
        if(root.left != null){
            helper(root.left, level + 1);
        }
        if(root.right != null){
            helper(root.right, level + 1);
        }
    }

    // result 是一个二维数组
    // result 0 是第 0 层元素
    static List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root){
        // 把每层节点放到一个单独 List
        if(root == null){
            return result;
        }
        // 方法辅助递归，第二个参数表示当前层数
        helper(root, 0);
        return result;
    }
}
