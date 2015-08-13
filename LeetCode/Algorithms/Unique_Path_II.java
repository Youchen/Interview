/**
 * O(m * n)
 * O(m)
 * 
 * By using 1D array.
 */
public class Solution{
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //2015-05-23 11:55:39 - 2015-05-23 12:11:04 (16 min)
        //using 1D array.
        if(obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
        
        //memo[i] is number of ways that the robot go from
        //upper-left to the position [curRow][i];
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[] memo = new int[col];
        
        //ini
        for(int i = 0; i < col; i++){
            if(obstacleGrid[0][i] == 1){
                memo[i] = 0;
                break;
            }else{
                memo[i] = 1;
            }
        }
        
        //function
        for(int i = 1; i < row; i++){
            
            if(memo[0] == 0 || obstacleGrid[i][0] == 1)
                memo[0] = 0;
            else
                memo[0] = 1;
            
            for(int j = 1; j < col; j++){
                if(obstacleGrid[i][j] == 1)
                    memo[j] = 0;
                else
                    memo[j] += memo[j - 1];
            }
        }
        return memo[col - 1];
        
    }
}







/**
 * Round 2 - lots of bugs.
 * 
 * Pay attention to the function part.
 * you should start from [1][1].
 */
public class Solution{
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //2015-05-23 11:40:25 - 2015-05-23 11:53:21 (13 min)
        if( obstacleGrid == null || obstacleGrid.length == 0)
            return 0;
        
        //memo[i][j] is the ways that robot could go from
        //upper-left corner to the position [i][j].
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] memo = new int[row][col];
        
        //initialization
        for(int i = 0; i < col; i++){
            if(obstacleGrid[0][i] == 1){
                memo[0][i] = 0;
                break;
            }
            memo[0][i] = 1;
        }
        
        for(int i = 0; i < row; i++){
            if(obstacleGrid[i][0] == 1){
                memo[i][0] = 0;
                break;
            }
            memo[i][0] = 1;
        }
        
        //function
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(obstacleGrid[i][j] == 1)
                    memo[i][j] = 0;
                else
                    memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }
            
        //ans
        return memo[row - 1][col - 1];
    }
}






public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //1st Trail
    //     if(obstacleGrid[0][0] == 1 || obstacleGrid == null || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1]) == 1) return 0;
        
    //     for(int i = 0; i < obstacleGrid.length; i++)
    //         for(int j = 0; j < obstacleGrid[0].length; j++){
    //             if(obstacleGrid[i][j] == 1)
    //                 obstacleGrid[i][j] = -1;
    //         }
        
    //     // obstacleGrid[0][0] = 1;
    //     return helper(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1 );
    // }
    
    // public int helper(int[][] A, int i, int j){
    //     if(i == 0){
    //         for(int m = 0; m <= i; m++){
    //             if(A[i][m] == -1){
    //                 A[i][j] = 0;
    //                 return 0;
    //             }
    //         }
    //         A[i][j] = 1;
    //         return 1;
    //     }
    //     if(j == 0){
    //         for(int m = 0; m <= j; m++){
    //             if(A[m][j] == -1){
    //                 A[i][j] = 0;
    //                 return 0;
    //             }
    //         }
    //         A[i][j] = 1;
    //         return 1;
    //     }
        
    //     if( (A[i - 1][j] != -1) && (A[i][j - 1] != -1) )
    //         return helper(A, i - 1, j) + helper(A, i, j - 1);
            
    //     else if( (A[i - 1][j] != -1) && (A[i][j - 1] == -1) )
    //         return A[i - 1][j];
            
    //     else if( (A[i - 1][j] == -1) && (A[i][j - 1] != -1) )
    //         return A[i][j - 1];
    //     else//both are -1;
    //         return 0;
    
    
    //Solution #1
    /**
     * O(m + n)
     * O(m + n)
     */
        // int[][] A = new int[obstacleGrid.length][obstacleGrid[0].length];
        // if(obstacleGrid[0][0] == 1) return 0;
        // // else
        // //     A[0][0] = 1;
            
        // for(int i = 0; i < obstacleGrid.length; i++){
        //     for(int j = 0; j < obstacleGrid[0].length; j++){
        //         if(i == 0 && j == 0)
        //             A[0][0] = 1;
        //         else{
        //             if(obstacleGrid[i][j] == 0){
        //                 if(i != 0 && j != 0)
        //                     A[i][j] = A[i - 1][j] + A[i][j - 1];
                    
        //                 else if(i == 0 && j != 0)
        //                     A[i][j] = A[i][j - 1];
                        
        //                 else if ( i != 0 && j == 0)
        //                     A[i][j] = A[i - 1][j];
        //                 // else
        //                 //     A[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
        //             }
        //             else// == 1
        //                 A[i][j] = 0;
        //         }
        //     }
        // }
        // return A[obstacleGrid.length - 1][obstacleGrid[0].length - 1]; 
        
        
        
        
        
        //Solution #2
        /**
         * inspired by 
         *      http://blog.csdn.net/linhuanmars/article/details/22135231
         * use 1D array.
         * 
         * O(m + n) 
         * O(m) - row size
         */
         int[] A = new int[obstacleGrid[0].length];
         A[0] = 1;
          for(int i = 0; i < obstacleGrid.length; i++){
            for(int j = 0; j < obstacleGrid[0].length; j++){
                if(obstacleGrid[i][j] == 1)
                    A[j] = 0;
                else if(j > 0)
                    A[j] += A[j - 1];
            }
          }
          return A[A.length - 1];
    }
}