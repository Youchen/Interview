/**
 * O(n)
 * O(n)
 * 
 * COMPLETELY UNDERSTAND THE PROBLEM!!!
 * 
 * This one tells that two non-overlapping but NOT say these two must 
 *      next to each other!!!
 */
public class Solution {
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        //2015-06-22 10:36:48 - 2015-06-22 11:07:35 (31 min)
        if(nums == null || nums.size() == 0)
            return 0;
        
        int len = nums.size();
        //scan from left to right to get left[];
        int[] left = new int[len];
        int sum;
        left[0] = sum = nums.get(0);
        
        for(int i = 1; i < len; i++){
            sum = Math.max(nums.get(i), nums.get(i) + sum);
            left[i] = Math.max(left[i - 1], sum);
        }
        
        //scan from right to left to get right[];
        int[] right = new int[len];
        right[len - 1] = sum = nums.get(len - 1);
        
        for(int i = len - 2; i >= 0; i--){
            sum = Math.max(nums.get(i), nums.get(i) + sum);
            right[i] = Math.max(right[i + 1], sum);
        }
        
        int max = Integer.MIN_VALUE;
        //find the separate line such that left[i] + right[i + 1] reach the max
        for(int i = 0; i <= len - 2; i++){
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    
    }
}


