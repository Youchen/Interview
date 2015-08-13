/**
 * Round 5
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        //2015-08-03 19:52:48 - 2015-08-03 19:54:42 (2 min)
        if(nums == null || nums.length == 0)
            return 0;
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > nums[i] + sum)
                sum = nums[i];
            else
                sum += nums[i];
            
            max = Math.max(sum, max);
        }
        return max;
    }
}




/**
 * Round 4
 * Same algorithm with "Best time to buy and sell stock"
 */
public class Solution {
    public int maxSubArray(ArrayList<Integer> nums) {
        //2015-06-22 00:58:14 - 2015-06-22 01:04:06 (6 min)
        if(nums == null || nums.size() == 0)
            return 0;
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        //max ( max + nums[i], nums[i] )
        for(int i = 0; i < nums.size(); i++){
            if(sum + nums.get(i) < nums.get(i))
                sum = nums.get(i);
            else
                sum += nums.get(i);
                
            max = Math.max(max, sum);
        }
        return max;
    }
}





/**
 * Round 3
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





/**
 * Round 2
 * O(n)
 * O(n)
 * DO THIS AGAIN.
 * 
 * Still cannot get right.
 * Why we need max var?
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        //5/24 20:30 pause 20:43 resume 20:46
        if(nums == null || nums.length == 0)
            return Integer.MIN_VALUE;
        
        //memo[i] is the first i items that has the max sum.
        int len = nums.length;
        int[] memo = new int[len];
        
        //ini
        memo[0] = nums[0];
        int max = nums[0];
        
        //func
        //f[i] = max( f[i - 1], f[i - 1] + nums[i] )
        for(int i = 1; i < len; i++){
            memo[i] = Math.max(nums[i], memo[i - 1] + nums[i]);
            max = Math.max(max, memo[i]);
        }
        return max;
    }
}







/**
 * DO THIS AGAIN.
 */
public class Solution {
    int[] sol = new int[16000];
    public int maxSubArray(int[] A) {
        //Solution #1 - Time Limit Exceed
    //     for(int i = 0; i < sol.length; i++)
    //         sol[i] = -1;
    //     return maxSubArray_2(A, sol);
    // }
    
    // public int maxSubArray_2(int[] A, int[] sol){
    //     if(A.length == 0) return 0;
    //     if(A.length == 1) return A[0];
    //     if(A.length == 2) 
    //         return (A[0] >= A[1]) ? Math.max(A[0], (A[0] + A[1])) : Math.max(A[1], (A[0] + A[1]));
        
    //     if(sol[A.length - 1] != -1)
    //         return sol[A.length - 1];
        
    //     int[] Asub = Arrays.copyOfRange(A, 0, A.length - 1);
        
    //     sol[A.length - 1] = Math.max(maxSubArray_2(Asub, sol), A[A.length - 1]);
    //     return sol[A.length - 1];
    
    //Solution #2 - Time Limit Exceed
        // int[] sum = new int[A.length];
        // sum[0] = A[0];
        
        // for(int i = 1; i < A.length; i++){
        //     sum[i] = (sum[i - 1] > A[i])? Math.max(sum[i - 1], A[i] + sum[i - 1]) : Math.max(A[i], sum[i - 1] + A[i]); 
        // }
        // return sum[sum.length - 1];
        
        //Solution #3 - Accepted
        /**
         * O(n)
         * O(n)
         */
        //Idea comes from: 
        //  http://blog.csdn.net/fightforyourdream/article/details/14515425
        // int[] sum = new int[A.length];
        // sum[0] = A[0];
        
        // int max = A[0];
        
        // for(int i = 1; i < A.length; i++){
        //     sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
        //     max = Math.max(max, sum[i]);
        // }
        // return max;
        
        
        
        //Solution #4
        /**
         * O(n)
         * O(1)
         */
        int sum = A[0];//= Integer.MIN_VALUE;
        int max = A[0];//Integer.MIN_VALUE;
        
        for(int i = 1; i < A.length; i++){
           sum = Math.max(A[i], sum + A[i]);
           max = Math.max(max, sum);
        }
        return max;
    
    }
}