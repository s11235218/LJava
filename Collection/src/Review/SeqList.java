package Review;


public class SeqList<E> {
    // E 泛型参数（相当于形参，在真正对该类实例化时，确定实参）
    // 泛型参数一般常见名字：E T KEY VALUE...
    // E 这样的泛型参数不能被直接实例化，当前还不知道 E 的类型
    private E[] data = (E[])new Object[100];
    private int size;

    public void add(E elem){
        data[size] = elem;
        size++;
    }

    public E get(int index){
        return data[index];
    }

    public static void main(String[] args) {
//        SeqList<String> seqList = new SeqList<>();
//        // String 也是继承自 Object
//        // 调用 add 相当于是向上转型
//        seqList.add("a");
//        seqList.add("b");
//        // 调用 get 返回 Object, 需要向下转型
//        String str = seqList.get(0);
//
        SeqList<Animal> animals = new SeqList<>();
        animals.add(new Animal());
        animals.add(new Animal());
        Animal animal = animals.get(0);

        // 装箱拆箱：类型转换
        // 自动拆装箱也就是隐式类型转换
        SeqList<Integer> integerSeqList = new SeqList<>();
        // 相当于 int => Integer: 装箱（boxing）
        // Integer num = new Integer(10);
        // Integer num = Integer.valueOf(10); // valueOf 是一个静态方法
        Integer num = 10; //  可以直接把 int 赋值给 Integer，自动装箱（编译器赋予包装类特有功能）
        integerSeqList.add(num);

        // Integer => int: 拆箱(unboxing)
        num = integerSeqList.get(0);
        // int val = num.intValue(); // 手动拆箱
        int val = num; // 自动拆箱

    }
}
