import java. util. Arrays;

public class sumTest {
    public static void main (String[] args) {
		int[] arr = {1, 3, 4, 6, 4, 2};
		System. out. println(sum(arr));
    }
    
    public static int sum(int[] arr) {
		int result = 0;
		for(int i = 0;i < arr.length; i++){
			result += arr[i];
		}
		return result;
	}
} 