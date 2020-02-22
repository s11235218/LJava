package SeqList;

// 顺序表基本操作时间复杂度
//1.新增元素：O(N) (尾插是O(1),不考虑扩容)
//2.查找元素：O(N)
//3.根据下标获取/修改元素：O(1)
//4.删除元素：O(N)
//5.清除所有元素：O(1)
//顺序表最主要特点：支持随机访问（高效按照下标）
//尾插效率较高（可能触发扩容，开销就大）
public class SeqList {
    private int[] datas = new int[100];
    //长度（有效元素个数）
    private int size = 0;

    public int getSize() {
        // size 这个成员只能提供get 方法，不能提供 set 方法
        return size;
    }

    public void display(){
        //依次打印出某个元素
        //形如[1, 2, 3, 4]
        String result = "[";
        for(int i = 0; i < size; i++){
            result += datas[i];
            if(i < size - 1){
                result += ", ";
            }
        }
        result += "]";
        System.out.println(result);
    }

    // pos 表示新元素要插入的位置
    // data 表示新元素的值
    public void add(int pos, int data){
        // 判定 pos 是否为有效值
        // 封装性比较好
        // 调用者，实现者双重确定，double check
        if(pos < 0 || pos > size){
            return;
        }

        //扩容支持
        if(size >= datas.length){
            //需要扩容
            //顺序表扩容策略很灵活，可以根据实际情况决定扩容方式
            int[] newDatas = new int[2 * datas.length];
            for(int i = 0; i < datas.length; i++){
                newDatas[i] = datas[i];
            }
            datas = newDatas;
        }

        // 1. 尾插
        //    把这个新元素放在 size 位置上
        if(pos == size){
            this.datas[pos] = data;
            size++;
            return;
        }
        // 2.普通位置插入
        for(int i = size - 1; i >= pos; i--){
            datas[i + 1] = datas[i];
        }
        datas[pos] = data;
        size++;
    }

    public boolean contains(int toFind){
        // 循环访问每个元素并进行比较
        // 如果发现某元素和 toFind 相等，返回true
        // 没找到，返回false
        for(int i = 0; i < size; i++){
            if(toFind == datas[i]){
                return true;
            }
        }
        return false;
    }

    public int search(int toFind){
        for(int i = 0; i < size; i++){
            if(toFind == datas[i]){
                return i;
            }
        }
        return -1;
    }

    //对于参数非法，处理方式
    // 1.返回一个非法值 C/C++/Go
    // 2.抛出一个异常 Java/Python
    //Integer 是包装类， 把 int 这个内置类包装了一下
    public Integer getPos(int pos){
        if(pos < 0 || pos >= size){
            return null;
        }
        return datas[pos];
    }

    public void setPos(int pos, int data){
        datas[pos] = data;
    }
    // toRemove 表示要被删除的元素值
    public void remove(int toRemove){
        // 1.先找到toRemove 对应的下标
        int pos = search(toRemove);
        if(pos == -1){
            return;
        }
        // 2.如果下标是最后一个元素，尾删
        if(pos == size - 1){
            size--;
            return;
        }
        // 3.如果下标是中间元素，先搬运，后尾删
        for (int i = pos; i < size - 1; i++) {
            datas[i] = datas[i + 1];
        }
        size--;
    }
    //扩容是常见操作
    //缩容是不常见操作
    public void clear(){
        size = 0;
    }
}
