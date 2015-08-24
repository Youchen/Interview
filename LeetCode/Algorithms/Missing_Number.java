/**
 * The problem statement is not clear.
 * Should say that the missing number is between [1, n].
 * 
 * Check it by using sumation formula.
 */
public class Solution {
    public int missingNumber(int[] nums) {
        //2015-08-24 13:46:56 - 2015-08-24 13:51:36 (5 min)
        if(nums == null || nums.length == 0)
            return 0;
        
        int sum = 0;
        for(int i : nums)
            sum += i;
        
        return (1 + nums.length) * nums.length / 2 - sum;
    }
}