/**
 * O(n^2)
 * O(1)
 * 
 * Idea:
 *      After sorting, if i, j, k is a valid triple, 
 *      then i, j-1, k, ..., i, i+1, k are also valid triples. 
 *      No need to count them one by one.
 * 
 * Reference:
 *      https://leetcode.com/discuss/52362/11-lines-o-n-2-python
 */
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        //2015-08-17 00:40:36 pause 2015-08-17 01:27:30 ( ~ 1 hour)
        if(nums == null || nums.length <= 2)
            return 0;
            
        Arrays.sort(nums);
        int i, j, count = 0;
        
        for(int k = 2; k <= nums.length - 1; k++){
            i = 0;
            j = k - 1;
            
            while(i < j){
                int sum = nums[i] + nums[j] + nums[k];
                
                if(sum < target){
                    count += j - i;
                    i++;
                }
                else
                    j--;
            }
        }
        return count;
    }
}