/**
 * O( A.length() * B.length() )
 * 
 * Note:
 *      index Part still have problems.
 *      Did not get right without seeing the index part of the solution.
 */

//Space O( A.length() ) version
public class Solution {
    public int longestCommonSubsequence(String A, String B) {
        //2015-06-07 00:15:35 - 2015-06-07 00:37:18 (22 min)
        if(A == null || B == null || A.length() == 0 || B.length() == 0)
            return 0;
        
        int Alen = A.length(), Blen = B.length();
        //f[i][j] is saying the LCS for
        //      the first i char of A COMBINE the first j char of B.
        int[][] f = new int[2][Blen + 1];
        
        //ini
        //f[0][j] = 0, f[i][0] = 0
        for(int j = 0; j <= Blen; j++)
            f[0][j] = 0;
            
        for(int i = 0; i <= 1; i++)
            f[i][0] = 0;
        
        //func
        /**
         * f[i][j] = max (f[i][j - 1], f[i - 1][j], f[i - 1][j - 1] + 1 ) // a[i] == b[j]
         *         = max (f[i][j - 1], f[i - 1][j], f[i - 1][j - 1]) //a[i] != b[j]
         */
        for(int i = 0; i < Alen; i++){
            for(int j = 0; j < Blen; j++){
                if(A.charAt(i) == B.charAt(j))
                    f[(i + 1) % 2][j + 1] = Math.max(f[(i + 1) % 2][j], 
                                            Math.max( f[i % 2][j + 1], f[i % 2][j] + 1 ));
                else
                    f[(i + 1) % 2][j + 1] = Math.max(f[(i + 1) % 2][j], f[i % 2][j + 1]);
    
            }
        }
        return f[Alen % 2][Blen];
    }
}




//Space O( A.length() * B.length() ) version
public class Solution {
    public int longestCommonSubsequence(String A, String B) {
        //2015-06-07 00:15:35 - 2015-06-07 00:37:18 (22 min)
        if(A == null || B == null || A.length() == 0 || B.length() == 0)
            return 0;
        
        int Alen = A.length(), Blen = B.length();
        //f[i][j] is saying the LCS for
        //      the first i char of A COMBINE the first j char of B.
        int[][] f = new int[Alen + 1][Blen + 1];
        
        //ini
        //f[0][j] = 0, f[i][0] = 0
        for(int j = 0; j <= Blen; j++)
            f[0][j] = 0;
            
        for(int i = 0; i <= Alen; i++)
            f[i][0] = 0;
        
        //func
        /**
         * f[i][j] = max (f[i][j - 1], f[i - 1][j], f[i - 1][j - 1] + 1 ) // a[i] == b[j]
         *         = max (f[i][j - 1], f[i - 1][j], f[i - 1][j - 1]) //a[i] != b[j]
         */
        for(int i = 0; i < Alen; i++){
            for(int j = 0; j < Blen; j++){
                if(A.charAt(i) == B.charAt(j))
                    f[i + 1][j + 1] = Math.max(f[i + 1][j], Math.max( f[i][j + 1], f[i][j] + 1 ));
                else
                    f[i + 1][j + 1] = Math.max(f[i + 1][j], f[i][j + 1]);
    
            }
        }
        return f[Alen][Blen];
    }
}
