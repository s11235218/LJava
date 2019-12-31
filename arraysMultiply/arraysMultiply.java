import java. util. Arrays;

public class arraysMultiply {
    public static void main (String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		System. out. println(Arrays. toString(multiply(arr)));
    }
    
    public static int[] multiply(int[] arr) {
		for (int i = 0; i < arr.length; i++){
			arr[i] *= 2;
		}
		return arr;
    }
} 