package Set;

import java.util.*;

public class TestInterview2 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        // 1. 遍历旧链表 key 是旧链表节点 value 是新链表节点
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null ; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        // 2. 再次循环
        for (Node cur = head; cur != null ; cur = cur.next) {
            // 先找到 map 中的该 cur 对应的新链表的节点
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
        }
        // 返回新链表的头节点
        return map.get(head);
    }

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        // 1. 遍历石头数组 加入到 set 中
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        int ret = 0;
        // 2. 遍历宝石数组 用每个元素取 set 中查找
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                ret++;
            }
        }
        return ret;
    }

    static class MyComparator implements Comparator<String> {
        private Map<String, Integer> map;

        public MyComparator(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String o1, String o2) {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            if (count1 == count2) {
                return o1.compareTo(o2);
            }
            // o1 < o2 return < 0
            // o1 > o2 return > 0
            // o1 = o2 return = 0
            // count1 - count2 升序 出现少的较小
            // count2 - count1 降序 出现多的较小
            return count2 - count1;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String x : words) {
            Integer count = map.getOrDefault(x, 0);
            map.put(x, count + 1);
        }
        // 2. 把统计到的字符串内容放到 ArrayList
        // keySet 相当于得到了一个 Set  Set 中存放的所有 key
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        // sort (默认字典序排序) 因此通过比较器自定义比较规则

        // Collections.sort(arrayList, new MyComparator(map));

        // 匿名内部类 只用一次
//        Collections.sort(arrayList, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                int count1 = map.get(o1);
//                int count2 = map.get(o2);
//                if (count1 == count2) {
//                    return o1.compareTo(o2);
//                }
//                return count2 - count1;
//            }
//        });

        // lambda 表达式 本质是匿名方法
        // o1 o2 是 String 类型
        Collections.sort(arrayList, (o1, o2) ->  {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            if (count1 == count2) {
                return o1.compareTo(o2);
            }
            return count2 - count1;
        });
        return arrayList.subList(0, k);
    }

    static class MyEntry<K, V> {
        K key;
        V value;

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(1, 10);
//        map.put(2, 20);
//        map.put(3, 30);
//        map.put(4, 40);
//
//        // 1. 使用迭代器
//        // Entry 表示一个键值对 (jey, value)
//        // entrySet 包含 Entry 的 Set Set<Entry<Integer, Integer>>
//        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<Integer, Integer> entry = iterator.next();
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//        // 2. 使用 for each
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }

        int[] array = {9, 5, 2, 7};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
