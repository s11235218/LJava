package reflect;

import java.util.Arrays;

public class TestEnum {
    // 需要表示性别 可约定
//    public static final int MALE = 1;
//    public static final int FEMALE = 2;
//    public static final int OTHER = 3;

    public static void main(String[] args) {
        Sex sex = Sex.MALE;
        if (sex == Sex.MALE) {
            // 针对男性操作...
        }

        // 通过定义常量表示性别 代码可读性提高了
        // 但是加减操作无意义 编译器没有过多操作 能正常编译
        // int ret = MALE + 100;

        System.out.println(Arrays.toString(Sex.values()));
        System.out.println(Sex.values().length);

        Sex.valueOf("MALE");
        if (sex == Sex.MALE) {
            System.out.println("得到一个 MALE 类型的枚举常量");
        }
    }
}
