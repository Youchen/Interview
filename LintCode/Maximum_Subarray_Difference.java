/**
 * O(5n) = O(n)
 * O(n)
 * 
 * Very nice problem.
 * This is an integrated one for all the min/max subarray problem.
 */
public class Solution {
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        //2015-06-24 00:20:49 - 2015-06-24 00:36:07 (16 min)
        if(nums == null || nums.size() == 0)
            return -1;
        
        int len = nums.size(), sum;
        //find max array from left to right
        int[] leftMax = new int[len];
        leftMax[0] = nums.get(0);
        sum = nums.get(0);
        
        for(int i = 1; i < len; i++){
            sum = Math.max(sum + nums.get(i), nums.get(i) );
            leftMax[i] = Math.max(leftMax[i - 1], sum);
        }
        
        //find max array from right to left
        int[] rightMax = new int[len];
        rightMax[len - 1] = nums.get(len - 1);
        sum = nums.get(len - 1);
        
        for(int i = len - 2; i >= 0; i--){
            sum = Math.max(sum + nums.get(i), nums.get(i) );
            rightMax[i] = Math.max(rightMax[i + 1], sum);
        }
        
        
        //find min array from left to right
        int[] leftMin = new int[len];
        leftMin[0] = nums.get(0);
        sum = nums.get(0);
        
        for(int i = 1; i < len; i++){
            sum = Math.min(sum + nums.get(i), nums.get(i) );
            leftMin[i] = Math.min(leftMin[i - 1], sum);
        }
        //find max array from right to left
        int[] rightMin = new int[len];
        rightMin[len - 1] = nums.get(len - 1);
        sum = nums.get(len - 1);
        
        for(int i = len - 2; i >= 0; i--){
            sum = Math.min(sum + nums.get(i), nums.get(i) );
            rightMin[i] = Math.min(rightMin[i + 1], sum);
        }
        
        //find max( abs(nums[i] - nums[i - 1] )
        int res = Integer.MIN_VALUE;
        
        //left is max, right is min
        for(int i = 0; i < len - 1; i++){
            int left_min_right_max = Math.abs( leftMin[i] - rightMax[i + 1] );
            int left_max_right_min = Math.abs( leftMax[i] - rightMin[i + 1] );
            
            res = Math.max(res, 
                    Math.max(left_min_right_max, left_max_right_min)
                            );
        }
        return res;   
    }
}


