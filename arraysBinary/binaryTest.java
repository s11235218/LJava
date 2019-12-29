import java.util.Scanner;
import java. util. Arrays;

public class binaryTest {
    public static void main (String[] args) {
		Scanner scanner = new Scanner(System. in);
		int num = scanner.nextInt();
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		System. out. println(binarySearch(arr, num));
    }
    
    public static int binarySearch(int[] arr, int toFind) {
		int left = 0;
		int right = arr.length - 1;
		
		while(left <= right){
			int mid = (left + right) / 2;
			if(toFind < arr[mid]){
				right = mid - 1;
			}
			else if(toFind > arr[mid]){
				left = mid + 1;
			}
			else{
				return mid;
			}
		}
		return -1;
	}
} 