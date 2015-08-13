/**
 * O(1)
 * O(n)
 * 
 * Note:
 *      DO THIS AGAIN!
 */
public class Solution {
    public int rob(int[] nums) {
        //2015-05-25 15:32:24 - 2015-05-25 16:07:01 (35 min)
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
       
        //
        int len = nums.length;
        
        //f[i] = Math.max(f[i - 2] + nums[i], f[i - 1]);
        //rob nums[0]
        int pre0 = nums[0];
        int pre1 = Math.max(pre0, nums[1]);
        int res = Math.max(pre0, pre1);
        int cur = 0;
        for(int i = 2; i < len - 1; i++){
            cur = Math.max(pre0 + nums[i], pre1);
            pre0 = pre1;
            pre1 = cur;
        }
        res = Math.max(res, cur);
        
        //rob nums[len - 1]
        pre0 = 0;
        pre1 = nums[1];
        for(int i = 2; i < len; i++){
            cur = Math.max(pre0 + nums[i], pre1);
            pre0 = pre1;
            pre1 = cur;
        }
        res = Math.max(res, cur);
        
        return res;
        
    }
}