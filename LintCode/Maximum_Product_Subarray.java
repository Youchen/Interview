public class Solution {
    public int maxProduct(int[] nums) {
        //2015-06-24 17:59:58 - 2015-06-24 18:15:02 (16 min)
        if(nums == null || nums.length == 0)
            return -1;
        
        int len = nums.length;
        int max = nums[0];
        int min = nums[0];
        int global = nums[0];
        
        for(int i = 1; i < len; i++){
            int tempMax = max;
            
            max = Math.max(nums[i] * min, 
                    Math.max(nums[i] * max, nums[i])
                );
            min = Math.min(nums[i] * min, 
                    Math.min(nums[i] * tempMax, nums[i])
                );
            global = Math.max(global, max);
        }
        return global;
    }
}
