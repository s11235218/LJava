public class SeqList {
    //private int[] data = new int[]{}
    private int[] data = null;

    //构造方法
    //实现顺序表时，先new一个一定长度的数组
    //此时顺序表里面的元素可以认为是空顺序表，此时为无效元素
    //通过add方法向顺序表中新建元素，这才是有效元素
    public SeqList(){
        data = new int[100];
    }
}
