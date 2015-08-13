/**
 * O(n^2)
 * O(n)
 * 
 * Note:
 *      Still have bugs.
 *      The answer of this problem is not memo[size - 1];
 *      but the max value of all the elements of memo.
 *      Pay attention to the details.
 */
public class Solution {
    public int longestIncreasingSubsequence(int[] nums) {
        //2015-05-24 16:17:33
        if(nums == null || nums.length == 0)
            return 0;
        
        //
        int len = nums.length;
        int[] longestSeqEndHere = new int[len];
        
        //ini
        longestSeqEndHere[0] = 1;
        int max = 0;
        
        //func
        //f[i] = Max ( f[j] )  && nums[j] <= nums[i]
        for(int i = 1; i < len; i++){
            longestSeqEndHere[i] = 1;
            for(int j = 0; j < i; j++){
                
                if(nums[j] <= nums[i])
                    longestSeqEndHere[i] = 
                        longestSeqEndHere[i] > longestSeqEndHere[j] + 1 ?
                        longestSeqEndHere[i] : longestSeqEndHere[j] + 1;
                    
            }
            if(longestSeqEndHere[i] > max)
                max = longestSeqEndHere[i];
        }
        //ans
        return max;
    }
}


