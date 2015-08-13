public class Solution {
    public int minPathSum(int[][] grid) {
        //2015-06-02 23:48:15 - 2015-06-02 23:55:08 (7 min)
        if(grid == null || grid[0].length == 0)
            return 0;
        
        int row = grid.length, col = grid[0].length;
        int[] memo = new int[col];
        memo[0] = grid[0][0];
        
        for(int i = 1; i < col; i++){
            memo[i] = memo[i - 1] + grid[0][i];
        }
        
        for(int i = 1; i < row; i++){
            memo[0] = memo[0] + grid[i][0];
            for(int j = 1; j < col; j++){
                memo[j] = Math.min(memo[j - 1] + grid[i][j], memo[j] + grid[i][j]);
            }
        }
        
        return memo[col - 1];
    }
}


