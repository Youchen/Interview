/**
 * Sliding Window to solve.
 * Since left scan once, right scan once => O(2n) = O(n)
 * 
 * Reference: http://www.programcreek.com/2014/05/leetcode-minimum-size-subarray-sum-java/
 *      We can use 2 points to mark the left and right boundaries of the sliding window. 
 *          When the sum is greater than the target, shift the left pointer; 
 *          when the sum is less than the target, shift the right pointer.
 *
 *
 * Caution:
 *      in marked line, you need to have 
 *          right - left  instead of 
 *          right - left + 1
 *      since when the first while loop terminates,
 *          right is points to the position one more right.
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //2015-06-20 22:40:28 - 2015-06-20 23:09:22 (29 min)
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1){
            if(nums[1] >= s)
                return 1;
            else
                return 0;
        }
        
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        
        while(right <= nums.length - 1 ){
            while(right <= nums.length - 1 && sum < s)
                sum += nums[right++];
            
            while(left <= right && sum >= s){
                min = Math.min(min, right - left); //<===== marked line =====
                sum -= nums[left++];
            }
        }
        
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}