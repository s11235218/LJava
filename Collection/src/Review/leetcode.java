package Review;

import java.util.*;

public class leetcode{
    static class TreeNode{
        private int val;
        private TreeNode right;
        private TreeNode left;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    List<Integer> res = new ArrayList<>();
    int size = 0;

    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        if (index == size) {
            res.add(root.val);
            size++;
        }
        helper(root.right, index + 1);
        helper(root.left, index + 1);
    }

    public int findUnsortedSubarray(int[] nums) {
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

    public boolean isPalindrome(String s) {
        if (s.length() == 0){
            return true;
        }
        String low = s.toLowerCase();

        int i = 0;
        int j = low.length() - 1;
        while (i < j)
        {
            if (!Character.isLetterOrDigit(low.charAt(i)))
            {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(low.charAt(j)))
            {
                j--;
                continue;
            }
            if (low.charAt(i) != low.charAt(j)){
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public int compress(char[] chars) {
        int left = 0;
        int size = 0;

        for (int right = 0; right <= chars.length; right++) {
            if (right == chars.length || chars[right] != chars[left]) {
                chars[size++] = chars[left];
                if (right - left > 1) {
                    for(char c : String.valueOf(right - left).toCharArray()) {
                        chars[size++] = c;
                    }
                }
                left = right;
            }
        }
        return size;
    }

    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int tmp = 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
            int sum = tmp;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            res.append(sum % 2);
            tmp = sum / 2;
        }
        res.append(tmp == 1 ? tmp : "");
        return res.reverse().toString();
    }

    public static void main(String args[]) {
        int i = 7;
        do {
            System.out.println(--i);
            --i;
        } while (i != 0);
        System.out.println(i);
    }
}
