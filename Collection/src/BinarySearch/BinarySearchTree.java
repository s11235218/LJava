package BinarySearch;

public class BinarySearchTree {
    public static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    private Node root = null;

    public Node find(int key) {
        Node cur = root;
        while (cur != null) {
            if (key < cur.key) {
                cur = cur.left;
            } else if (key > cur.key) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }

    // 二叉搜索树 key 不允许相同 set map 中 key 也不允许相同
    // 如果重复 返回失败 false 成功 true
    public boolean insert(int key) {
        // 和查找类似找到合适位置
        if (root == null) {
            // 空树让 root 指向 key 对应新节点
            root = new Node(key);
            return true;
        }

        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else if (key > cur.key) {
                parent = cur;
                cur = cur.right;
            } else {
                // 重复值
                return false;
            }
        }
        // 循环结束 cur 指向 null 当前元素插入到parent 子树位置
        // 具体插入parent 那个子树
        if (key < parent.key) {
            parent.left = new Node(key);
        } else {
            parent.right = new Node(key);
        }
        return true;
    }

    // key 在树中存在 删除成功
    // key 在树中不存在 删除失败
    public boolean remove(int key) {
        // 找到待删除元素后 在判定情况
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else if (key > cur.key) {
                parent = cur;
                cur = cur.right;
            } else {
                // 判断情况
                removeNode(parent, cur);
                return true;
            }
        }
        return false;
    }

    private void removeNode(Node parent, Node cur) {
        if (cur.left == null) {
            // 1. 要删除的元素没有左子树
            if (cur == root) {
                // 1.1 如果要删除节点为 root
                root = cur.right;
            } else if (cur == parent.left) {
                // 1.2 cur 是 parent 的左子树
                parent.left = cur.right;
            } else if (cur == cur.right) {
                // 1.3 cur 是 parent 的右子树
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            // 1. 要删除的元素没有右子树
            if (cur == root) {
                // 2.1 如果要删除节点为 root
                root = cur.left;
            } else if (cur == parent.left) {
                // 2.2 cur 是 parent 的左子树
                parent.left = cur.left;
            } else {
                // 2.3 cur 是 parent 的右子树
                parent.right = cur.left;
            }
        } else {
            // 3. 要删除的有两个节点
            // 3.1 先找到右子树的最小元素
            Node goatParent = cur;
            Node scapeGoat = cur.right;
            while (scapeGoat.left != null) {
                goatParent = scapeGoat;
                scapeGoat = scapeGoat.left;
            }
            // 循环结束时 scapeGoat 指向右子树最小值
            // 3.2 把找到的值赋给待删除的节点
            cur.key = scapeGoat.key;
            // 3.3 删除该节点
            //   替罪羊节点没有左子树
            if (scapeGoat == goatParent.left) {
                goatParent.left = scapeGoat.right;
            } else {
                goatParent.right = scapeGoat.right;
            }
        }
    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.key);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(3);
        tree.insert(6);
        tree.insert(8);

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();

        Node cur = tree.find(2);
        System.out.println(cur.key);

        tree.remove(5);
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
    }
}
