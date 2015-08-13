//Copied from Leetcode.

/**
 * DO THIS AGAIN!
 * O( s1.length() * s2.length() )
 * O( s1.length() * s2.length() )
 * 
 * Note:
 *      The analysis to the function processing should be exact and correct.
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        //2015-06-07 18:20:39 - 2015-06-07 19:02:48 (42 min)
        
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if(len1 + len2 != len3)
            return false;
            
        //f[i][j] indicate that first i char of s1 and first j char of S2 can (or cannont) be 
        //      interleaving to the first i + j char of s3.
        boolean[][] f = new boolean[len1 + 1][len2 + 1];
        
        //ini
        /**
         * f[0][0] = true
         * f[0][j] = s2[0, j] == s3[0, j]
         * f[i][0] = s1[0, i] == s3[0, i]
         */
        f[0][0] = true;
         
        for(int j = 1; j <= len2; j++)
            f[0][j] = ( s2.substring(0, j).equals(s3.substring(0, j)) );
        
        for(int i = 1; i <= len1; i++)
            f[i][0] = ( s1.substring(0, i).equals(s3.substring(0, i)) );
        
        //f[i][j] = f[i - 1][j] //s1[i] == s3[i + j + 1] OR
        //        = f[i][j - 1] //s2[j] == s3[i + j + 1] <======= it's i + j + 1 instead of i + j
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(
                    (f[i][j + 1] && s1.charAt(i) == s3.charAt(i + j + 1) ) ||
                    (f[i + 1][j] && s2.charAt(j) == s3.charAt(i + j + 1) )
                    )
                f[i + 1][j + 1] = true;
            }
        }
        return f[len1][len2];
    }
}