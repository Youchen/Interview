/**
 * O(n^4)
 * O(n^3) where n is the length of the string.
 * 
 * 3-dimentional DP. Hard to think! Review.
 * 
 * Core idea:
 *      
 *      s1 __ | _____
 *      s2      __ | _____
 *      
 *      s1 left compare with s2 left :     f[i][j][k]
 *      s1 right compare with s2 right :   f[i + k][j + k][n - k]
 * 
 *      s1 __ | _____
 *      s2   _____ | __
 * 
 *      s1 left compare with s2 right :    f[i][j + n - k][k]
 *      s1 right compare with s2 left :    f[i + k][j][n - k]
 * 
 * Reference:
 *      http://blog.csdn.net/linhuanmars/article/details/24506703
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
        //2015-08-17 17:54:01 - 10 min (~ 2 hours)
        if(s1 == null || s2 == null)
            return s1 == null && s2 == null;
            
        if(s1.length() != s2.length())
            return false;
        
        int len = s1.length();
        /**
         * f[i][j][n] is claiming that
         *      s1 stats at i, s2 starts at j,
         *      the length of the substring is n;
         * Is this substring is scrambled string for each other.
         */
        boolean [][][] f = new boolean[len][len][len + 1];
        
        for(int i = 0; i < len; i++)
            for(int j = 0; j < len; j++)
                f[i][j][1] = s1.charAt(i) == s2.charAt(j);
            
        for(int n = 2; n <= len; n++)
            for(int i = 0; i < len - n + 1; i++)
                for(int j = 0; j < len - n + 1; j++)
                    for(int k = 1; k < n; k++)//k < len since i + k could make the length of n
                        f[i][j][n] |= (  (f[i][j][k] && f[i + k][j + k][n - k]) || 
                                         (f[i][j + n - k][k] && f[i + k][j][n - k])   );
        return f[0][0][len];
    }
}