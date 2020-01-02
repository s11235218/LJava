public class avgTest {
    public static void main (String[] args) {
        int[] arr = {1, 3, 4, 5, 3, 5};
        System. out. println(avg(arr));
    }

    public static double avg(int[] arr) {
        int result = 0;
        for(int i = 0;i < arr.length; i++){
            result += arr[i];
        }
        double avgs = (double)result / (double)arr.length;
        return avgs;
    }
} 