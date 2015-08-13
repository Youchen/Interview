/**
 * O(n)
 * O(1)
 * 
 * Feel this kinds of topic.
 */
public class Solution {
    public int rob(int[] nums) {//2015-05-24 18:33:57 - 2015-05-24 18:37:22 (4 min)
        if(nums == null || nums.length == 0)
            return 0;
        
        int pre2 = 0;
        int pre1 = nums[0];
        int cur = pre1;
        
        for(int i = 1; i < nums.length; i++){
            cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return cur;
    }
}






/**
 * Cost lots of time.
 * 
 * Note:
 *      Pay attention to the transform function.
 */
public class Solution {
    public int rob(int[] nums) {
        //2015-05-24 16:43:42 pause 2015-05-24 16:56:41 resume 2015-05-24 17:25:21 - 2015-05-24 18:25:43
        //1 h 13 min
        if(nums == null || nums.length == 0)
            return 0;
        
        //max rob amt at house i
        int len = nums.length;
        int[] maxRob = new int[len + 1];
        
        //ini
        maxRob[0] = 0;
        maxRob[1] = nums[0];
        
        //func
        //dp[i] = max(dp[i - 1], dp[i - 2] + num[i - 1])
        for(int i = 2; i <= len; i++){
            for(int j = 0; j <= i; j++){
                maxRob[i] = Math.max(maxRob[i - 1], maxRob[i - 2] + nums[i - 1]);
            }
        }
        
        //ans
        return maxRob[len];
    }
}