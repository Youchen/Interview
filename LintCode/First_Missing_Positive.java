public class Solution {
    public int firstMissingPositive(int[] nums) {
        //2015-05-26 21:27 - 2015-05-27 00:03:37
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0 && nums[i] < nums.length && nums[nums[i] - 1] != nums[i]){
                //swap
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
                i--;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(i + 1 != nums[i])
                return i + 1;
        }
        return nums.length + 1;
    }
}