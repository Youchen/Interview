/**
 * idea is great!
 * review the implementation step.
 * 
 * Implementation Reference:
 *      https://codesolutiony.wordpress.com/2015/05/25/lintcode-longest-increasing-continuous-subsequence-ii/
 */
public class Solution {
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        //2015-08-18 16:50:57 - 2015-08-18 17:32:26 (TLE) (40 min)
        //-30 min 2015-08-18 18:46:06 (approx. 1 h 30 min)
        if(A == null || A.length == 0)
            return 0;
        
        int row = A.length, col = A[0].length;
        int[][] memo = new int[row][col];
        
        int max = 0;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(memo[i][j] == 0){
                    max = Math.max(max, find(A, i, j, memo) );
                }
            }
        }
        
        return max;
    }
    
    private int find(int[][] A, int row, int col, int[][] memo){
        if(memo[row][col] != 0)
            return memo[row][col];

        int left = 0, right = 0, up = 0, down = 0;

        if(col + 1 < memo[0].length && A[row][col] < A[row][col + 1]){
            right = find(A, row, col + 1, memo);
        }
            
        if(row + 1 < memo.length && A[row][col] < A[row + 1][col]){
            down = find(A, row + 1, col, memo);
        }
        
        if(col - 1 >= 0 && A[row][col] < A[row][col - 1]){
            left = find(A, row, col - 1, memo);
        }
        
        if(row - 1 >= 0 && A[row][col] < A[row - 1][col]){
            up = find(A, row - 1, col, memo);
        }
        
        memo[row][col] = Math.max(Math.max(up, down), Math.max(left, right)) + 1;

        return memo[row][col];
    }
}