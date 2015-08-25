/**
 * Round 3
 * Remember using Greedy instead of DP.
 */
public class Solution {
    public int jump(int[] nums) {
        //2015-08-24 16:45:56 - 2015-08-24 16:48:22 (3 min)
        if(nums == null || nums.length == 0)
            return 0;
        
        int maxReach = 0;
        int lastReach = 0;
        int step = 0;
        
        for(int i = 0; i < nums.length && i <= maxReach; i++){
            if(i > lastReach){
                step++;
                lastReach = maxReach;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return step;
    }
}






/**
 * Round 2
 * O(n)
 * O(1)
 * 
 * Note:
 *      takes so much time to understand the best solution.
 *      Code comes from the modification of "Jump Game".
 * 
 *      Idea is to maintain a maxReach and lastReach,
 *      the iterator i iterates inside the range of maxReach.
 *      when i exceeds the range of maxReach, lastReach needs to update to the 
 *      current maxReach. and make step++.
 *
 * Reference:
 *      http://blog.csdn.net/linhuanmars/article/details/21356187
 */
public class Solution {
    public int jump(int[] nums) {
        //2015-06-03 17:31:39 - 2015-06-03 17:34:04 (3 min)
        if(nums == null || nums.length == 0)
            return 0;
        
        int maxReach = 0;
        int step = 0;
        int lastReach = 0;
        for(int i = 0; i < nums.length && i <= maxReach; i++){
            if(i > lastReach){
                step++;
                lastReach = maxReach;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        if(maxReach < nums.length - 1)
            return 0;
        return step;
    }
}








/**
 * O(n^2)
 * O(n)
 * 
 * DP is not the best way to solve.
 * DP can cause TLE. Consider Greedy!
 */
public class Solution {
    public int jump(int[] nums) {
        //2015-05-23 13:53:08 - 2015-05-23 14:42:45 ( 49 min)
    
        //memo[i] indicating that the min ways that robot
        //could go from start position to the ith position.
        // int len = nums.length;
        int[] memo = new int[nums.length];
        
        //ini
        memo[0] = 0;
        
        //function
        for(int i = 1; i < nums.length; i++){
            memo[i] = Integer.MAX_VALUE;

            for(int j = 0; j < i; j++){
                if(memo[j] != Integer.MAX_VALUE && i - j <= nums[j]){
                    memo[i] = memo[j] + 1;
                    break;
                }
            }
        }
        return memo[nums.length - 1];
    }
}