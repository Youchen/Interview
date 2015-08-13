/**
 * Round 2
 * O(32n) = O(n)
 * O(32) = O(1)
 * 
 * Key idea is the ternary arithmetic (三进制).
 * The marked line shows the add operation.
 *      kind of tricky by using "|". Think about this again.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        //2015-06-21 15:35:26 - 2015-06-21 15:39:56 (4 min)
        if(nums == null || nums.length == 0)
            return 0;
        
        int[] count = new int[32];
        int res = 0;
        
        for(int i = 0; i <= 31; i++){
            for(int j = 0; j < nums.length; j++ ){
                if( ( (nums[j] >> i) & 1) == 1 )
                    count[i]++;
            }
            res |= ( count[i] % 3 ) << i;
        }
        
        return res;
    }
}





/**
 * O(n)
 * O(1)
 * 
 * Optimized solution, Not fully understood.
 * 
 * Demostration:
 *      We can improve this based on the previous solution using three bitmask variables: 
 *
 *            ones as a bitmask to represent the ith bit had appeared once.
 *            twos as a bitmask to represent the ith bit had appeared twice.
 *            threes as a bitmask to represent the ith bit had appeared three times.
 *        When the ith bit had appeared for the third time, clear the ith bit of both 
 *                ones and twos to 0. The final answer will be the value of ones.
 *                
 *        For example, if the array is like [5, 5, 5, ....]
 *        the changes are:
 *
 *                ones = 101
 *                twos = 0
 *                threes = 0
 *                --------------
 *                ones = 0
 *                twos = 101
 *                threes = 0
 *                --------------
 *                ones = 0
 *                twos = 0
 *                threes = 101
 *                --------------
 *
 * 
 * Reference:
 *      https://leetcode.com/discuss/857/constant-space-solution
 *      http://www.acmerblog.com/leetcode-single-number-ii-5394.html
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for(int i = 0; i < n; i++){
            twos |= ones & nums[i];
            ones ^= nums[i];
            threes = ones & twos;
            
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
}










import java.util.*;
public class Solution {
    public int singleNumber(int[] A) {
        Hashtable<Integer, Integer> hs = new Hashtable<Integer, Integer>();
        for(int i : A){
            if(! hs.containsKey(i) )
                hs.put(i, 1);
            else if(hs.get(i) + 1 == 3)
                hs.remove(i);
            else
                hs.put(i, 2);
        }
        
        return hs.keys().nextElement();
    }
}