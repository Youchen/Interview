public class Solution {
    public int uniquePathsWithObstacles(int[][] Grid) {
        //2015-06-02 23:21:17 - 2015-06-02 23:37:02 ( 16 min )
        if(Grid == null || Grid.length == 0)
            return 0;
        
        int row = Grid.length, col = Grid[0].length;
        int[] memo = new int[col];
        
        for(int i = 0; i < col; i++){
            if(Grid[0][i] == 1)
                break;
                
            memo[i] = 1;
        }
        
        for(int i = 1; i < row; i++){
            
            if(Grid[i][0] == 1)
                memo[0] = 0;
                    
            for (int j = 1; j < col; j++){
                
                if(Grid[i][j] == 1)
                    memo[j] = 0;
                else
                    memo[j] = memo[j - 1] + memo[j];
            }
        }
        
        return memo[col - 1];
    }
}

