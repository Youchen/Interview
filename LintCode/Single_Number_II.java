/**
 * Not fully understand.
 */
public class Solution {
    public int singleNumberII(int[] A) {
        //2015-06-21 17:16:23 - 2015-06-21 17:19:45
        if(A == null || A.length == 0)
            return 0;
        
        int ones = 0, twos = 0, threes = 0;
        for(int i = 0; i < A.length; i++){
            twos |= ones & A[i];
            ones ^= A[i];
            threes = ones & twos;
            
            ones &= ~threes;
            twos &= ~threes;
        }
        
        return ones;
    }
}