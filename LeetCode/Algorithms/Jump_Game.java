/**
 * Round 2
 * O(n)
 * O(1)
 * 
 * Greedy Algorithm
 * Note:
 *      Very nice algorithm.
 */
public class Solution {
    public boolean canJump(int[] nums) {
         //2015-05-23 12:53:11 - 2015-05-23 12:57:25 (4 min)
        if(nums == null || nums.length == 0)
            return false;
        
        int farPos = 0;
        for(int i = 0; i <= farPos && i < nums.length; i++){
            if(farPos >= nums.length - 1) return true;
            if(farPos < nums[i] + i)
                farPos = nums[i] + i;
        }
        return false;
    }
}





/**
 * Round 2
 * Nice done!
 * 
 * Pay attention to the optimization of the algorithm.
 * It's better to traverse from the current position towards the
 *      start point rather than the reverse direction.
 */
public class Solution {
    public static boolean canJump(int[] nums) {
        //2015-05-23 12:40:01 - 2015-05-23 12:47:56 (7 min)
        if(nums == null || nums.length == 0)
            return false;
        
        //memo[i] is indicating that if we can jump
        //from the start position to the position [i].
        int len = nums.length;
        boolean[] memo = new boolean[len];
        
        //ini
        memo[0] = true;
        
        //function
        for(int i = 1; i < len; i++){
            for(int j = i - 1; j >= 0; j--){
                if(memo[j] && i - j <= nums[j]){
                    memo[i] = true;
                    break;
                }else
                    memo[i] = false;
            }
        }
        
        return memo[len - 1];
    }
}







/**
 * O(n)
 * 237 ms
 *
 * Array
 * Greedy
 */
public class Solution {
    public boolean canJump(int[] A) {
        //1st trail
        // if(A.length == 0) return false;
        
        // int farestIndex = 0;
        // while(farestIndex < A.length - 1){
        //     if(A[farestIndex] == 0) break;
        //     farestIndex = farestIndex + A[farestIndex];
        // }
        // if(farestIndex >= A.length - 1) return true;
        // else return false;
        
        
        //2nd trail
        if(A.length == 0) return false;
        
        int farPos = 0;
        for(int i = 0; i <= farPos && i < A.length; i++){
            if(farPos < A[i] + i) farPos = A[i] + i;
            if(farPos >= A.length - 1) return true;
        }
        return false;
    }
}