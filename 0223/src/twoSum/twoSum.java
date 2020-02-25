package twoSum;

public class twoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == dif){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 11};
        System.out.println(twoSum(nums, 9));
    }
}
