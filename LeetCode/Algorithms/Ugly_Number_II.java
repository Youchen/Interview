/**
 * Review
 * 
 * Reference:
 *      https://leetcode.com/discuss/52716/o-n-java-solution
 */
public class Solution {
    public int nthUglyNumber(int n) {
        //2015-08-22 21:12:00
        int[] f = new int[n];
        f[0] = 1;
        
        int fac2 = 2, fac3 = 3, fac5 = 5;
        int in2 = 0, in3 = 0, in5 = 0;
        
        for(int i = 1; i < n; i++){
            int min = Math.min(fac2, Math.min(fac3, fac5));
            
            f[i] = min;
            
            if(fac2 == min)
                fac2 = 2 * f[++in2];
              
            if(fac3 == min)
                fac3 = 3 * f[++in3];
            
            if(fac5 == min)
                fac5 = 5 * f[++in5];
            
        }
        return f[n - 1];
    }
}