/**
 * The idea is very simple:
 *      last bit of (odd number & even number) is 0.
 *      when m != n, There is at least an odd number and an even number, so the last bit position result is 0.
 *      Move m and n rigth a position.
 *      Keep doing step 1,2,3 until m equal to n, use a factor to record the iteration time.
 * 
 * Reference:
 *      https://leetcode.com/discuss/32115/bit-operation-solution-java
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        //2015-06-29 00:02:22 -5 min 2015-06-29 00:14:49 (7 min)
        if(m == n){
            return m & n;
        }
        int computedBit = 1;
        while(m != n){
            m = m >> 1;
            n = n >> 1;
            computedBit <<= 1;
        }
        return computedBit * m;
    }
}