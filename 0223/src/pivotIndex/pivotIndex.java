package pivotIndex;

public class pivotIndex {
    public static int pivotIndex(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            for(int j = 0; j < i; j++){
                sumLeft += nums[j];
            }
            for (int j = i + 1; j < nums.length; j++) {
                sumRight += nums[j];
            }
            if(sumLeft == sumRight){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }
}
