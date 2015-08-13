/**
 * O(n)
 * O(1)
 * 
 * Same as Minimum Subarray.
 */
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        //2015-06-19 15:45:04 - 2015-06-19 15:49:36 (4 min)
        if(nums == null || nums.size() == 0)
            return 0;
        
        //f[i] is the max subarray that ends at nums.get(i)
        int[] f = new int[2];
        f[0] = nums.get(0);
        
        int max = nums.get(0);
        //f[i] = max(nums[i], f[i - 1] + nums.get(i))
        for(int i = 1; i < nums.size(); i++){
            f[i % 2 ] = Math.max(nums.get(i), f[ (i - 1) % 2 ] + nums.get(i));
            max = Math.max(max, f[i % 2]);
        }
            
        return max;
    }
}
