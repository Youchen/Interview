/**
 * change all in n[i, j] to 0.
 * 	    compute pow(2, j - i + 1), we have 100..0 [j + 1, i]
 * 	    100..0 - 1 => 11...1 [j, i]
 * 	    we have 11...1 (j ... i, inclusive)
 * 	    shift i position, we have 11...100..0 (i 0's)
 * 	    get inverse, we have 11..1100..000111..11 ([j, i] 0's in middle)
 * 	    n & 11..1100..000111..11 => XXX-[j, i] is all 0-XXX
 *
 * shift m i position left, form like m-00..0 (i 0's)
 * 	    shift m i position => m-00..0 (i 0's)
 * 	
 * then n OR m-00..0
 * 	    ans = n | m-00..0
*/
class Solution {
    public int updateBits(int n, int m, int i, int j) {
        //2015-05-28 01:45:32 - 2015-05-28 02:09:31 (24 min)
        if(i > j)
            return n;
    
        int mask = ~(((int)(Math.pow(2, j - i + 1) - 1)) << i);
        //clear n[j, i]
        n = n & mask;
        
        int shiftMtoI = m << i;
        return n | shiftMtoI;
    }
}


