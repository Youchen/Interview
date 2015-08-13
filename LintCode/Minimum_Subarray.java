/**
 * O(n)
 * O(1)
 * 
 * Note:
 *      DP iterating function is
 *          f[i] = min( f[i - 1], nums[i] )
 *      NOT
 *          f[i] = min( f[i - 1], nums[i], f[i - 1] + nums[i] )
 */
public class Solution {
    public int minSubArray(ArrayList<Integer> nums) {
        //2015-06-19 15:22:00 -  2015-06-19 15:38:56 (16 min)
        if(nums == null || nums.size() == 0)
            return 0;
            
        //f[i] is the min value of the subarray that ends at nums[i]
        int[] f = new int[2];
        f[0] = nums.get(0);//Integer.MAX_VALUE;
        
        //f[i] = min( nums[i], f[i - 1] + nums[i] )
        int min = f[0];
        for(int i = 1; i < nums.size(); i++){
            f[i % 2] = Math.min(nums.get(i), nums.get(i) + f[ (i - 1) % 2]);
            
            min = Math.min(min, f[i % 2]);
            
        }
        return min;
    }
}

