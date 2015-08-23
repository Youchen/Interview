/**
 * Round 3
 * 
 * Review:
 *      as iterating, there are two lines and a maxGlobal go together with the pointer.
 *          they are maxLocal, minLocal and maxGlobal.
 *      for every number, you need to multiply it with maxLocal and minLocal, see if
 *          they can make the max value.
 *      then Keep updating the maxGlobal.
 */
public class Solution {
    public int maxProduct(int[] nums) {
        //2015-08-21 00:22:23 - 2015-08-21 00:30:09(8 min)
        if(nums == null || nums.length == 0)
            return 0;
        
        int minLocal, maxLocal, maxGlobal;
        minLocal = maxLocal = maxGlobal = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int temp = minLocal;
            
            minLocal = Math.min(nums[i] * minLocal, Math.min(nums[i] * maxLocal, nums[i]));
            maxLocal = Math.max(nums[i] * maxLocal, Math.max(nums[i] * temp, nums[i]));
            
            maxGlobal = Math.max(maxGlobal, maxLocal);
        }
        
        return maxGlobal;
    }
}





/**
 * Round 2
 */
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




public class Solution {
    public int maxProduct(int[] nums) {
        //2015-05-24 21:07:31 - 2015-05-24 21:46:01 (39 min)
        if(nums == null || nums.length == 0)
            return Integer.MIN_VALUE;
        
        int max = nums[0];
        int min = nums[0];
        int global = nums[0];
        
        //f[i] = max( f[i], f[i] * max[i - 1])
        /**
         * f(k) = max( f(k-1) * A[k], A[k], g(k-1) * A[k] )
         * g(k) = min( g(k-1) * A[k], A[k], f(k-1) * A[k] )
         */
        for(int i = 1; i < nums.length; i++){
            int temp = max;
            max = Math.max(nums[i] * min, Math.max(nums[i] * max, nums[i]));
            min = Math.min(nums[i] * min, Math.min(nums[i] * temp, nums[i]));
            global = Math.max(global, max);
        }
        return global;
    }
}