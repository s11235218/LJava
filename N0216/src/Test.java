import java.util.Scanner;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        mystery.mystery(1234);
        Scanner scanner = new Scanner(System.in);
        String a =scanner.next();
        String sc = "Hello";
        System.out.println(ToLowerCase.ToLowerCase(a));
        System.out.println(ToLowerCase.ToLowerCase(sc));
        int[] num = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(Rotation.rotate(num, 3)));
    }

}
