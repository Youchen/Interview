/**
 * O( A.length * A.length * target )
 * 
 * Note:
 *      Pay attention to the func defination.
 *      
 *      Sometimes, you can consider use some item or do not use some item
 *          to create the case.
 *      like this problem in the ** <==== mark =====  ** line.
 */

// Space O( A.length * A.length * target ) version
public class Solution {
    public int kSum(int A[], int k, int target) {
        //2015-06-08 01:52:50 - 2015-06-08 02:20:41 (28 min)
        if(A == null || A.length == 0 || k == 0)
            return 0;
        
        int len = A.length;
        //func defi
        //f[i][j][t] indicating that the # of solutions for picking j numbers in
        //      first i chars in A to get the sum t.
        int[][][] f = new int[len + 1][len + 1][target + 1];
        
        //ini
        //f[0][0][0] = 1; f[i][0][0] = 1; 
        //f[0][j][0] = 0; f[0][0][t] = (t == 0) ? 1 : 0;
        for(int i = 0; i <= len; i++)
            f[i][0][0] = 1;
            
        for(int j = 1; j <= len; j++)
            f[0][j][0] = 0;
        
        for(int t = 1; t <= target; t++)
            f[0][0][t] = 0;
        
        //f[i][j][t] = f[i - 1][ j - 1 ][t - A[i] ] // use A[i]    +
        //           = f[i - 1][j][t] // not use A[i]              <==== mark ===
        for(int i = 1; i <= len; i++){
            for(int j = 1; j <= len; j++){
                for(int t = 1; t <= target; t++){
                    
                    f[i][j][t] = f[i -1][j][t];
                    if(j - 1 <= i - 1 && t - A[ i - 1] >= 0)
                        f[i][j][t] += f[i - 1][ j - 1 ][t - A[i - 1] ];
                    
                    
                }
            }
        }
        return f[len][k][target];
    }
}




// Space O( A.length * target ) version
public class Solution {
    public int kSum(int A[], int k, int target) {
        //2015-06-08 01:52:50 - 2015-06-08 02:20:41 (28 min)
        if(A == null || A.length == 0 || k == 0)
            return 0;
        
        int len = A.length;
        //func defi
        //f[i][j][t] indicating that the # of solutions for picking j numbers in
        //      first i chars in A to get the sum t.
        int[][][] f = new int[2][len + 1][target + 1];
        
        //ini
        //f[0][0][0] = 1; f[i][0][0] = 1; 
        //f[0][j][0] = 0; f[0][0][t] = (t == 0) ? 1 : 0;
        for(int i = 0; i <= 1; i++)
            f[i][0][0] = 1;
            
        for(int j = 1; j <= len; j++)
            f[0][j][0] = 0;
        
        for(int t = 1; t <= target; t++)
            f[0][0][t] = 0;
        
        //f[i][j][t] = f[i - 1][ j - 1 ][t - A[i] ] // use A[i]    +
        //           = f[i - 1][j][t] // not use A[i]
        for(int i = 1; i <= len; i++){
            for(int j = 1; j <= len; j++){
                for(int t = 1; t <= target; t++){
                    
                    f[i % 2][j][t] = f[(i -1) % 2][j][t];
                    if(j - 1 <= i - 1 && t - A[ i - 1] >= 0)
                        f[i % 2][j][t] += f[(i - 1) % 2][ j - 1 ][t - A[i - 1] ];
                    
                    
                }
            }
        }
        return f[len % 2][k][target];
    }
}


