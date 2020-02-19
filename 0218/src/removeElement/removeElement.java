package removeElement;

public class removeElement {
    public static int removeElement(int[] nums, int val) {
        int res = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != val){
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = new int[]{3, 2, 2, 3};
        System.out.println(removeElement.removeElement(num, 3));
    }
}
