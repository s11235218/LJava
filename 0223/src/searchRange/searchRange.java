package searchRange;

public class searchRange {
    public static int[] searchRange(int[] nums, int target){
        int[] arrTarget = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                arrTarget[0] = i;
                break;
            }
        }
        if (arrTarget[0] == -1) {
            return arrTarget;
        }
        for (int j = nums.length-1; j >= 0; j--) {
            if (nums[j] == target) {
                arrTarget[1] = j;
                break;
            }
        }
        return arrTarget;
    }
}
