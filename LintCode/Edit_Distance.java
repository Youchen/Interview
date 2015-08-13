/**
 * Round 2
 * O( A.length() * B.length() )
 * O( A.length() * B.length() )
 *
 * Note:
 *      Nice done!
 *      Pay attention to the function, it is a little bit difficult to coding right.
 *      
 *      For the index
 *          just align the index with string.
 *          then, follow the function processing relation, and the relation of string
 *              to the function ( string index + 1 = function index), replace the index
 *              in the function processing formula.
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        //2015-06-07 11:13:48 - 2015-06-07 11:33:41 (20 min)
        
        int len1 = word1.length(), len2 = word2.length();
        //f[i][j] is the min # of steps required to convert first i chars of A
        //          to first j chars of B.
        int[][] f = new int[len1 + 1][len2 + 1];
        
        //ini
        //f[0][j] = j    f[i][0] = i
        for(int j = 0; j <= len2; j++)
            f[0][j] = j;
        
        for(int i = 0; i <= len1; i++)
            f[i][0] = i;
            
        //f[i][j] = min( f[i - 1][j - 1], f[i - 1][j] + 1, f[i][j - 1] + 1 ) // A[i] = B[j]
        //        = min( f[i - 1][j - 1] + 1, f[i - 1][j] + 1, f[i][j - 1] + 1 ) // A[i] != B[j]
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(word1.charAt(i) == word2.charAt(j))
                    f[i + 1][j + 1] = Math.min( f[i][j], 
                                        Math.min( f[i][j + 1] + 1, f[i + 1][j] + 1) );
                else
                    f[i + 1][j + 1] = Math.min( f[i][j] + 1,
                                        Math.min( f[i][j + 1] + 1, f[i + 1][j] + 1) );
            }
        }
        return f[len1][len2];
    }
}