import java.util.Arrays;

public class transformToStringTest {
    public static void main(String[] args){
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(toString(arr));
    }
    public static String toString(int arr){
        String ret = "[";
        for(int i = 0; i < arr.length; i++) {
            ret += arr[i];
            if(i !=arr.length - 1){
                ret +=", ";
            }
        }
        ret += "]";
        return ret;

    }
}
