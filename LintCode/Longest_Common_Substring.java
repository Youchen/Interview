/**
 * Round 2
 * O(A.length() * B.length()
 * 
 * Note:
 *      Index could be ** aligned with String **.
 *      meaning i -> 0 ~ A.length() - 1     j -> 0 ~ B.length() - 1
 *      then when you assign the function value 
 *      just use f[i + 1][j + 1] to replace f[i][j]
 * 
 *      Still did not get right without seeing the ** <=== ** part of the 
 *      solution.
 *      
 *      Remember to understand the real meaning of STATE !!
 */

// Space O( A.length() ) version
public class Solution {
    public int longestCommonSubstring(String A, String B) {
        //2015-06-07 00:48:36 - 2015-06-07 01:01:11 (13 min)
        if(A == null || B == null || A.length() == 0 || B.length() == 0)
            return 0;
        
        int aLen = A.length(), bLen = B.length();
        //f[i][j] is the LCS for
        //      the combination of the first i char of A AND
        //                         the first j char of B.
        // LCS must be end with i and j. (A[i] B[j] both are identical to the LCS)
        int[][] f = new int[2][bLen + 1];
        
        //ini
        //f[0][j] = 0    f[i][0] = 0
        for(int j = 0; j <= bLen; j++)
            f[0][j] = 0;
        
        for(int i = 0; i <= 1; i++)
            f[i][0] = 0;
        
        //func
        //f[i][j] = f[i - 1][j - 1] + 1 // A[i] = B[j]
        //        = 0 // A[i] != B[j] <========= Be careful for this line 
        //                             ============= NOT max ( f[i - 1][j], f[i][j - 1] )
        int maxLCS = 0;
        for(int i = 0; i < aLen; i++){
            for(int j = 0; j < bLen; j++){
                if(A.charAt(i) == B.charAt(j))
                    f[ (i + 1) % 2 ][j + 1] = f[i % 2][j] + 1;
                else
                    f[(i + 1) % 2][j + 1] = 0;
                
                maxLCS = Math.max(maxLCS, f[(i + 1) % 2][j + 1]);
            }
        }
        return maxLCS;
    }
}




// Space O(A.length() * B.length() version
public class Solution {
    public int longestCommonSubstring(String A, String B) {
        //2015-06-07 00:48:36 - 2015-06-07 01:01:11 (13 min)
        if(A == null || B == null || A.length() == 0 || B.length() == 0)
            return 0;
        
        int aLen = A.length(), bLen = B.length();
        //f[i][j] is the LCS for
        //      the combination of the first i char of A AND
        //                         the first j char of B.
        // LCS must be end with i and j. (A[i] B[j] both are identical to the LCS)
        int[][] f = new int[aLen + 1][bLen + 1];
        
        //ini
        //f[0][j] = 0    f[i][0] = 0
        for(int j = 0; j <= bLen; j++)
            f[0][j] = 0;
        
        for(int i = 0; i <= aLen; i++)
            f[i][0] = 0;
        
        //func
        //f[i][j] = f[i - 1][j - 1] + 1 // A[i] = B[j]
        //        = 0 // A[i] != B[j] <========= Be careful for this line 
        //                             ============= NOT max ( f[i - 1][j], f[i][j - 1] )
        int maxLCS = 0;
        for(int i = 0; i < aLen; i++){
            for(int j = 0; j < bLen; j++){
                if(A.charAt(i) == B.charAt(j))
                    f[i + 1][j + 1] = f[i][j] + 1;
                else
                    f[i + 1][j + 1] = 0;
                
                maxLCS = Math.max(maxLCS, f[i + 1][j + 1]);
            }
        }
        return maxLCS;
    }
}













public class Solution {
    public int longestCommonSubstring(String A, String B) {
        //2015-05-26 15:39:47 - pause 2015-05-26 15:55:19 resume 2015-05-26 16:17:30
        //       - 2015-05-26 16:25:52 (24 min) with seeing the solution.
        int alen = A.length(), blen = B.length();
        
        //f[i][j] is the LCS that ending with
        //      first i char of A and
        //      first j char of B.
        int[][] f = new int[alen + 1][blen + 1];
        
        //ini
        //f[0][j] = 0, f[i][0] = 0;
        for(int k = 0; k < blen + 1; k++)
            f[0][k] = 0;
        
        for(int k = 0; k < alen + 1; k++)
            f[k][0] = 0;
        
        //func
        //f[i][j] = if(A[i] == B[j]) f[i - 1][j - 1] + 1;
        //          if(A[i] != B[j]) max(f[i - 1][j], f[i][j - 1])
        int max = 0;
        for(int i = 1; i < alen + 1; i++){
            for(int j = 1; j < blen + 1; j++){
                if(A.charAt(i - 1) == B.charAt(j - 1))
                    f[i][j] = f[i - 1][j - 1] + 1;
                else
                    //f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                    f[i][j] = 0;//<============= pay attention here, it's not the above line!!!
                
                 max = Math.max(max, f[i][j]);
            }
        }
        return max;
    }
}

