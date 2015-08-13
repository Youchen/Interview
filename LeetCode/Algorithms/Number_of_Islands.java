/**
 * Nice done.
 * 
 * Note:
 *      in first time trail, using the boolean array "visited".
 *      it's space consuming and TLE.
 * 
 *      So next time, try to avoid this. Don't use "visited" if not necessary or
 *          could be replace by something else.
 */
public class Solution {
    public int numIslands(char[][] grid) {
        //2015-05-15 20:00:29 - 2015-05-15 20:34:27 (34 min)
        if(grid == null || grid.length == 0)
            return 0;
        
        // boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    change1toTrue(grid, i, j);
                }
            }
        }
        return count;
    }
    private void change1toTrue(char[][] grid, int row, int col){
        //traverse right and down
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1')
            return;
        
        if(grid[row][col] == '1')
            grid[row][col] = '2';
        change1toTrue(grid, row + 1, col);//down
        change1toTrue(grid, row, col + 1);//right
        change1toTrue(grid, row, col - 1);//left
        change1toTrue(grid, row - 1, col);//up
    }
}