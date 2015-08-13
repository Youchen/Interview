/**
 * O( m * A.length )
 * 
 * Very nice Problem
 * DO THIS AGAIN
 * Note:
 *      Pay attention to the function declaration of this kind of problem.
 *  
 *      Pay attention to the validation of the array indexing.
 *          ( Does A[i - 1] is valid ? )
 */
 
 
//Space O( m * A.length ) version
public class Solution {
    public int backPack(int m, int[] A) {
        //2015-06-07 20:29:19 - 2015-06-07 21:06:40 ( 37 min )
        if( m <= 0 || A == null || A.length == 0)
            return 0;
        
        int len = A.length;
        //f[i][j] indicating can we use first i items to have sum of j by seleting some of them.
        boolean[][] f = new boolean[len + 1][m + 1];
        
        //ini
        //f[0][0] = true; f[0][j] = false; f[i][0] = true;
        for(int j = 1; j <= m; j++)
            f[0][j] = false;
        
        for(int i = 0; i <= len; i++)
            f[i][0] = true;
        
        //f[i][j] = f[i - 1][j] OR f[i - 1][j - A[i] ]
        int max = 0;
        for(int i = 1; i <= len; i++){
            
            for(int j = 1; j <= m; j++){
                
                boolean condition1 = f[i - 1][j];
                boolean condition2 = (j - A[i - 1] >= 0 )? f[i - 1][j - A[i - 1] ] : false;
                
                f[i][j] = condition1 || condition2;
                
            }
        }
        
        //find max value
        for(int k = m; k >= 0; k--)
            if(f[len][k])
                return k;
        return 0;
    }
}




//Space O( A.length ) version
public class Solution {
    public int backPack(int m, int[] A) {
        //2015-06-07 20:29:19
        if( m <= 0 || A == null || A.length == 0)
            return 0;
        
        int len = A.length;
        //f[i][j] indicating can we use first i items to have sum of j by seleting some of them.
        boolean[][] f = new boolean[2][m + 1];
        
        //ini
        //f[0][0] = true; f[0][j] = false; f[i][0] = true;
        for(int j = 1; j <= m; j++)
            f[0][j] = false;
        
        for(int i = 0; i <= 1; i++)
            f[i][0] = true;
        
        //f[i][j] = f[i - 1][j] OR f[i - 1][j - A[i] ]
        for(int i = 1; i <= len; i++){
            
            for(int j = 1; j <= m; j++){
                
                boolean condition1 = f[( i - 1 ) % 2][j];
                boolean condition2 = (j - A[i - 1] >= 0 )? f[(i - 1) % 2][j - A[i - 1] ] : false;
                
                f[i % 2][j] = condition1 || condition2;
                
            }
        }
        
        //find max value
        for(int k = m; k >= 0; k--)
            if(f[len % 2][k])
                return k;
        return 0;
    }
}

