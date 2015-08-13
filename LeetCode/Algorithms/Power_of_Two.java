public class Solution {
    public boolean isPowerOfTwo(int n) {
        //2015-07-10 01:16:27 - 2015-07-10 01:22:53 (6 min)
        // if(n <= 0)
        //     return false;
        return n > 0 && (n & (n - 1) ) == 0;
    }
}