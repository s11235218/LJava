package abstractLearn.sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Boy[] boys = {
                new Boy("吴彦祖", 100, 100),
                new Boy("刘宪华", 100, 120),
                new Boy("王嘉尔", 100, 110),
                new Boy("小新", 30, 80),

        };
        sort(boys);
        System.out.println(Arrays.toString(boys));
    }

    // Comparable 带一个泛型参数，也可没有，没有表示 Object
    // 冒泡排序
    public static void sort(Comparable[] array){
        for(int bound = 0; bound < array.length; bound++){
            for(int cur = array.length - 1; cur > bound; cur--){
                if(array[cur - 1].compareTo(array[cur]) > 0){
                    Comparable tmp = array[cur - 1];
                    array[cur - 1] = array[cur];
                    array[cur] = tmp;
                }
            }
        }
    }
}
