package thirdMax;

public class thirdMax {
    public static int thirdMax(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j] < nums[j + 1]){
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }

        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return nums[0];
        }
        int firstMax = nums[0];
        int secondMax = nums[1];
        int thirdMax = nums[2];
        if(nums.length > 3){
            for (int i = 3; i <= nums.length; i++) {
                if (firstMax == secondMax) {
                    firstMax = secondMax;
                    secondMax = thirdMax;
                    thirdMax = nums[i + 1];
                }
                if (secondMax == thirdMax) {
                    if(nums.length != 4){
                        secondMax = thirdMax;
                        thirdMax = nums[i + 1];
                    }else{
                        return nums[3];
                    }
                }
            }
        }
        return thirdMax;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 1};
        System.out.println(thirdMax(nums));
    }
}
