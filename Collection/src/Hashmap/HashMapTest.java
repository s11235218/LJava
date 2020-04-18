package Hashmap;

// 开散列
public class HashMapTest {
    static class Node {
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final double LOAD_FACTOR = 0.75;

    // array 是 hash表的本体，数组每个元素是链表的头节点
    private Node[] array = new Node[101];
    private int size = 0;

    private int hashFunc(int key) {
        return key % array.length;
    }

    // 如果 key 已经存在，那么就修改当前的 value
    // 如果 key 不存在，就插入新的键值对
    public void put(int key, int value) {
        // 1. 需要把 key 映射成数组下标
        int index = hashFunc(key);
        // 2. 根据下标找到对应链表
        Node list = array[index];
        // 3. 当前 key 在链表中是否存在
        for (Node cur = list; cur != null; cur = cur.next) {
            if (cur.key == key) {
                // key 已经存在，直接修改 value
                cur.value = value;
                return;
            }
        }
        // 4. 如果循环结束没有找到相同值 直接插入到指定链表头部
        Node newNode = new Node(key, value);
        newNode.next = list;
        array[index] = newNode;
        size++;

        if (size / array.length > LOAD_FACTOR) {
            resize();
        }
    }

    private void resize() {
        Node[] newArray = new Node[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            for (Node cur = array[i]; cur != null; cur = cur.next) {
                int index = cur.key % newArray.length;
                Node newNode = new Node(cur.key, cur.value);
                newNode.next = newArray[index];
                newArray[index] = newNode;
            }
        }
    }

    // 查找元素 返回value或null
    public Integer get(int key) {
        int index = hashFunc(key);
        Node list = array[index];
        for (Node cur = list; cur != null; cur = cur.next) {
            if (cur.key == key) {
                // key 已经存在，直接修改 value
                return cur.value;
            }
        }
        return null;
    }
}
