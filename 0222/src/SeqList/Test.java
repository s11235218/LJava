package SeqList;

public class Test {
    // 单元测试：将代码按照单元分别独立的进行测试（可以是一个或一个以上方法或类构成）
    // 单元测试往往是由开发人员进行，测试人员很少关注单元测试

    //测试驱动开发
    //先写单元测试代码，再实现代码具体细节
    private static void testAdd(){
        // 严谨的测试方式
        // 1. 测试参数非法情况
        // 2. 测试扩容功能
        // 3. 尾插的逻辑
        // 4.普通位置插入
        SeqList seqList = new SeqList();
        seqList.add(0, 100);
        seqList.add(0, 200);
        seqList.add(0, 300);
        seqList.add(0, 400);
        seqList.display();
    }

    private static void testContains() {
        SeqList seqList = new SeqList();
        seqList.add(0, 100);
        seqList.add(0, 200);
        seqList.add(0, 300);
        seqList.add(0, 400);
        System.out.println(seqList.contains(200));
    }

    private static void testSearch(){
        SeqList seqList = new SeqList();
        seqList.add(0, 100);
        seqList.add(0, 200);
        seqList.add(0, 300);
        seqList.add(0, 400);
        System.out.println(seqList.search(200));
    }
    //static 可以修饰成员变量，也能修饰方法
    //有static 说明这个成员是和类相关（类.成员）
    //没有static 是和对象相关（使用之前需要先创建对象，对象.成员）
    //修饰代码块时，这个代码块的内容会在类加载时执行
    private static void testRemove(){
        SeqList seqList = new SeqList();
        seqList.add(0, 1);
        seqList.add(0, 2);
        seqList.add(0, 3);
        seqList.add(0, 4);
        seqList.remove(2);
        seqList.display();
    }

    // 对照代码进行测试：白盒测试
    // 不看代码，对照需求文档：黑盒测试
    public static void main(String[] args) {
        testContains();
        testSearch();
        testRemove();
    }
}
