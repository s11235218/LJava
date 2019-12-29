import java. util. Arrays;

public class arraysTransform {
    public static void main (String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		System. out. println(Arrays. toString(transform(arr)));
    }
    
    public static int[] transform(int[] arr) {
		int left = 0;
		int right = arr.length - 1;

		while(left < right) {
			while(left < right && arr[left] % 2 == 0) {
				left++;
			}
			while(left < right && arr[right] % 2 != 0) {
				right--;
			}
			int tmp = arr[left];
			arr[left] = arr[right];
			arr[right] = tmp;
		}
		return arr;
    }
} 