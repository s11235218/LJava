package linkList;

//一个节点
class Node{
    public int data;   //数据
    public Node next = null;  //下一个节点的位置

    public Node(int data) {
        this.data = data;
    }
}

//对于单向链表来说（只能找到下一个节点),只要知道第一个节点,就能获取到所有节点
//通常会用第一个节点的位置来代表整个链表，这样的第一个节点称为“头结点”
//通常会使用一个头结点来代表整个链表
//一个链表初始情况下是一个空链表。如果head => null,当前是一个空链表
//链表表现形式（排列组合）:
//1.单向还是双向
//2.是否带环（最后一个节点的next如果是null, 就不带环；如果不是null而是链表上其他某个位置上的节点，就是带环）
//3.链表的头结点是否是傀儡节点（只是为了代码实现起来比较方便，实际上这个节点中data部分不具有实际意义，不参与存储数据）
//单向，不带环，不带傀儡节点的链表
//如果链表不带傀儡节点，就用head => null作为空链表的表示方式
//如果带傀儡节点，head初始情况下是指向一个傀儡节点。null才认为是空链表
public class LinkedList {
    //管理所有的链表节点，只需要记录头节点位置即可
    //初始情况下head 为null，此时表示空链表（不带傀儡节点）
    private Node head = null;

    //头插
    public void addFirst(int data){
        //1.根据data值构建一个链表节点（Node对象）
        Node node = new Node(data);
        //2.如果链表为空链表
        if(head == null){
            head = node;
            return;
        }
        //3.如果不是空链表
        node.next = head;
        head = node;
    }

    public void addLast(int data){
        //1. 构造Node对象
        Node node = new Node(data);
        //2.判空
        if(head == null){
            head = node;
            return;
        }
        //3.链表非空，先找到链表最后一个节点
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        //循环结束后，tail就对应到最后一个节点了
        tail.next = node;
    }

    public void display(){
        //链表中的每个元素打印出来
        for(Node cur = head; cur != null; cur = cur.next){
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }

    public int getSize(){
        int size = 0;
        for(Node cur = head; cur != null; cur = cur.next){
            size++;
        }
        return size;
    }

    //插入成功，返回true，失败false
    public boolean addIndex(int index, int data){
        int size = getSize();
        //1.判定index是否有效
        if(index < 0 || index > size){
            //index 无效，插入失败
            return false;
        }
        //2.如果index = 0，相当于头插
        if(index == 0){
            addFirst(data);
            return true;
        }
        //3.如果index = size，相当于尾插
        if(index == size){
            addLast(data);
            return true;
        }
        Node node = new Node(data);
        //4.如果index是中间位置
        //a.先找到index前一个节点index - 1
        Node prev = getPos(index - 1);
        //b.接下来就把新节点插入到prev 后
        node.next = prev.next;
        prev.next = node;
        return true;

    }

    //给定index下标，找到对应节点
    private Node getPos(int index){
        Node cur = head;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur;
    }

    public boolean contains(int toFind){
        for(Node cur = head; cur != null; cur = cur.next){
            if(toFind == cur.data){
                return true;
            }
        }
        return false;
    }

    public void remove(int toRemove){
        //1.如果是头节点
        if(head.data == toRemove){
            head = head.next;
            return;
        }
        //2.如果不是头节点，找到删除节点的前一个节点
        Node prev = searchPrev(toRemove);
        //3.修改引用指向,完成删除
        prev.next = prev.next.next;
    }

    public Node searchPrev(int toRemove){
        for(Node cur = head; cur != null && cur.next != null; cur = cur.next){
            if(cur.next.data == toRemove){
                return cur;
            }
        }
        return null;
    }
}
