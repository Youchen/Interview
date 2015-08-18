/**
 * Round 2
 * 
 * O(n)
 * O(1)
 * 
 * idea is that 
 *      - rob       the 1st home      not rob      the last home
 *      - rob       the last home     not rob      the 1st home.
 * 
 * Since during the iteration, only 3 variables used, 
 *      we can reduce the space complexity to O(1)
 */
public class Solution {
    public int rob(int[] nums) {
        //2015-08-17 22:05:55 - 2015-08-17 22:17:01 (12 min)
        if(nums == null || nums.length == 0)
            return 0;
        
        int len = nums.length;
        if(len == 1)
            return nums[0];
        if(len == 2)
            return Math.max(nums[0], nums[1]);
            
        int pre, mid, cur = 0;
        int max = 0;
        
        //not rob last one but rob the 1st one.
        pre = 0;
        mid = nums[0];
        
        for(int i = 1; i <= len - 2; i++){
            cur = Math.max(mid, pre + nums[i]);
            pre = mid;
            mid = cur;
        }
        max = mid;
        
        //not rob 1st one but rob last one.
        pre = 0;
        mid = 0;
        
        for(int i = 1; i <= len - 1; i++){
            cur = Math.max(mid, pre + nums[i]);
            pre = mid;
            mid = cur;
        }
        max = Math.max(max, cur);
        return max;
    }
}








/**
 * Round 2
 * 
 * O(n)
 * O(n)
 * 
 * idea is that 
 *      - rob       the 1st home      not rob      the last home
 *      - rob       the last home     not rob      the 1st home.
 */
public class Solution {
    public int rob(int[] nums) {
        //2015-08-17 21:42:55 - 2015-08-17 22:04:25 (22 min)
        if(nums == null || nums.length == 0)
            return 0;
        
        int len = nums.length;
        if(len == 1)
            return nums[0];
        if(len == 2)
            return Math.max(nums[0], nums[1]);
            
        int[] f = new int[len + 1];
        int max = 0;
        
        //not rob last one but rob the 1st one.
        f[0] = 0;
        f[1] = nums[0];
        
        for(int i = 2; i < len; i++)
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i - 1]);
            
        max = f[len - 1];
        
        //not rob 1st one but rob last one.
        f[0] = 0;
        f[1] = 0;
        
        for(int i = 2; i <= len; i++)
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i - 1]);
        
        max = Math.max(max, f[len]);
        return max;
    }
}








/**
 * O(n)
 * O(1)
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