/**
 * O(A.length * m)
 * 
 * Note:
 *      Pay attention to
 *          the function defination.
 *          the answer. sometimes you need to find max value instead of f[n][n]
 */

//Space O(A.length * m ) version
public class Solution {
    public int backPackII(int m, int[] A, int V[]) {
        //2015-06-07 21:15:50 - 2015-06-07 21:34:46 (19 min)
        if( A == null || A.length == 0 || V == null || V.length == 0 || m == 0)
            return 0;
        
        int aLen = A.length, vLen = V.length;
        //f[i][j] indicate the max value when we select first i items from A, 
        //          the size is exactly j.
        int[][] f = new int[aLen + 1][m + 1];
        
        //ini
        //f[0][0] = 0; f[i][0] = 0; f[0][j] = 0;
        for(int i = 0; i <= aLen; i++)
            f[i][0] = 0;
            
        for(int j = 0; j <= m; j++)
            f[0][j] = 0;
            
        //f[i][j] = max( f[i - 1][j], f[i - 1][j - A[i] ] + V[i] )
        for(int i = 1; i <= aLen; i++){
            for(int j = 1; j <= m; j++){
                
                int condition1 = f[i - 1][j];
                int condition2 = (j - A[i - 1] >= 0)? f[i - 1][j - A[i - 1]] + V[i - 1] : 0;
                
                f[i][j] = Math.max(condition1, condition2);
                
            }
        }
        
        //solution: max ( f[len][0 ... m] )
        int maxValue = 0;
        for(int k = m; k >= 0; k--)
            maxValue = Math.max(maxValue, f[aLen][k]);
            
        return maxValue;
    }
}



//Space O(m) version
public class Solution {
    public int backPackII(int m, int[] A, int V[]) {
        //2015-06-07 21:15:50 - 2015-06-07 21:34:46 (19 min)
        if( A == null || A.length == 0 || V == null || V.length == 0 || m == 0)
            return 0;
        
        int aLen = A.length, vLen = V.length;
        //f[i][j] indicate the max value when we select first i items from A, 
        //          the size is exactly j.
        int[][] f = new int[2][m + 1];
        
        //ini
        //f[0][0] = 0; f[i][0] = 0; f[0][j] = 0;
        for(int i = 0; i <= 1; i++)
            f[i][0] = 0;
            
        for(int j = 0; j <= m; j++)
            f[0][j] = 0;
            
        //f[i][j] = max( f[i - 1][j], f[i - 1][j - A[i] ] + V[i] )
        for(int i = 1; i <= aLen; i++){
            for(int j = 1; j <= m; j++){
                
                int condition1 = f[(i - 1) % 2][j];
                int condition2 = (j - A[i - 1] >= 0)? f[ (i - 1) % 2][j - A[i - 1]] + V[i - 1] : 0;
                
                f[i % 2][j] = Math.max(condition1, condition2);
                
            }
        }
        
        //solution: max ( f[len][0 ... m] )
        int maxValue = 0;
        for(int k = m; k >= 0; k--)
            maxValue = Math.max(maxValue, f[aLen % 2][k]);
            
        return maxValue;
    }
}