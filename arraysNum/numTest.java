import java. util. Arrays;

public class numTest {
    public static void main (String[] args) {
		int[] arr = new int[100];
		System. out. println(Arrays. toString(putNum(arr)));
    }
    
    public static int[] putNum(int[] arr) {
		for(int i = 0;i < 100; i++){
			arr[i] = i + 1;
		}
		return arr;
	}
} 