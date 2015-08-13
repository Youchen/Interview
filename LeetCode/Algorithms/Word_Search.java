/**
 * Round 3
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        //2015-07-26 21:14:35 - 2015-07-26 21:26:56 (12 min)
        if(board == null || board.length == 0 || word == null || word.length() == 0)
            return false;
        
        int row = board.length;
        int col = board[0].length;
        
        boolean[][] visited = new boolean[row][col];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(dfs(board, word, visited, 0, i, j))
                    return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, boolean[][] visited, int pos, int row, int col){
        if(pos == word.length())
            return true;
            
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] ||
                board[row][col] != word.charAt(pos) )
            return false;
            
        visited[row][col] = true;
        
        boolean res = dfs(board, word, visited, pos + 1, row - 1, col) || 
                    dfs(board, word, visited, pos + 1, row, col - 1) ||
                    dfs(board, word, visited, pos + 1, row + 1, col) ||
                    dfs(board, word, visited, pos + 1, row, col + 1);
        visited[row][col] = false;
        
        return res;
    }
}




/**
 * Round 2
 * DO THIS AGAIN
 * 
 * Note:
 *      This solution is the best way to solve this.
 * 
 * Reference:
 *      http://www.cnblogs.com/springfor/p/3883942.html
 */
public class Solution {
    public boolean exist(char[][] board, String word) {//2015-05-07 10:14:21 - 2015-05-07 10:25:08 (11 min)
        int row = board.length;
        if(board == null || row == 0 || word == null || word.length() == 0)
            return false;
        int col = board[0].length;
        
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(dfs(board, word, 0, visited, i, j))
                    return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int index, boolean[][] visited, int row, int col){
        if(index == word.length())
            return true;
        
        if(row < 0 || col < 0 || row > board.length - 1 || col > board[0].length - 1 || word.charAt(index) != board[row][col] || visited[row][col])
            return false;
        
        visited[row][col] = true;
        boolean res = dfs(board, word, index + 1, visited, row - 1, col) ||
                    dfs(board, word, index + 1, visited, row + 1, col) ||
                    dfs(board, word, index + 1, visited, row, col + 1) ||
                    dfs(board, word, index + 1, visited, row, col - 1);
        visited[row][col] = false;
        return res;
    }
}


public class Solution {
    public boolean exist(char[][] board, String word) {//2015-05-06 23:52:36 - 2015-05-07 00:34:27 (42 min) 9:10 - 9:28 (1h - TLE)
        if(board == null || board.length == 0 || word == null || word == "")
            return false;
        
        boolean[] res = new boolean[1];
        res[0] = false;
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        //find first char of word
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    helper(board, word.substring(1), res, i, j, visited);
                    if(res[0] == true)
                        break;
                    else
                        visited[i][j] = false;
                }
            }
            if(res[0] == true)
                    break;
        }
        return res[0];
    }
    private void helper(char[][] board, String word, boolean[] res, int row, int col, boolean[][] visited){
        if(word.length() == 0){
            res[0] = true;
            return;
        }
        //did not find?
        
        
        //valid row - 1
        if(row - 1 >= 0 && visited[row - 1][col] == false && board[row - 1][col] == word.charAt(0)){
            visited[row - 1][col] = true;
            helper(board, word.substring(1), res, row - 1, col, visited);
            visited[row - 1][col] = false;
        }
        if(col + 1 <= board[0].length - 1 && visited[row][col + 1] == false && board[row][col + 1] == word.charAt(0)){
            visited[row][col + 1] = true;
            helper(board, word.substring(1), res, row, col + 1, visited);
            visited[row][col + 1] = false;
        }
        if(row + 1 <= board.length - 1 && visited[row + 1][col] == false && board[row + 1][col] == word.charAt(0)){
            visited[row + 1][col] = true;
            helper(board, word.substring(1), res, row + 1, col, visited);
            visited[row + 1][col] = false;
        }
            
        if(col - 1 >= 0 && visited[row][col - 1] == false && board[row][col - 1] == word.charAt(0)){
            
            visited[row][col - 1] = true;
            helper(board, word.substring(1), res, row, col - 1, visited);
            visited[row][col - 1] = false;
            
        }
        else
            return;
    }
}







/**
 * O(board.row * board.col + 4 * word.length)
 * O(Math.max(board.row * board.col, word.length))
 * 311 ms
 * 
 * Note:
 *      The visited boolean array is necessary.
 */
public class Solution {
    public boolean exist(char[][] board, String word) {//around 70 min
        if(board == null || board.length == 0)
            return false;
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    if(helper(board, word.substring(1, word.length()), i, j, visited))
                        return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, String word, int row, int col, boolean[][] visited){
        if(word.equals(""))
            return true;
        
        //up
        if(row >= 1 && col >= 0 && col <= board[0].length - 1 && board[row - 1][col] == word.charAt(0) && visited[row - 1][col] == false) {
            visited[row - 1][col] = true;
            if(helper(board, word.substring(1, word.length()), row - 1, col, visited))
                return true;
            visited[row - 1][col] = false;
        }
            
        //right
        if(col <= board[0].length - 2 && row >= 0 && row <= board.length - 1 && board[row][col + 1] == word.charAt(0) && visited[row][col + 1] == false) {
            visited[row][col + 1] = true;
            if(helper(board, word.substring(1, word.length()), row, col + 1, visited))
                return true;
            visited[row][col + 1] = false;
        }
            
        //down
        if(row <= board.length - 2 && col >= 0 && col <= board[0].length - 1 && board[row + 1][col] == word.charAt(0) && visited[row + 1][col] == false) {
            visited[row + 1][col] = true;
            if(helper(board, word.substring(1, word.length()), row + 1, col, visited))
                return true;
            visited[row + 1][col] = false;
        }
            
        //left
        if(col >= 1 && row >= 0 && row <= board.length - 1 && board[row][col - 1] == word.charAt(0) && visited[row][col - 1] == false) {
            visited[row][col - 1] = true;
            if(helper(board, word.substring(1, word.length()), row, col - 1, visited))
                return true;
            visited[row][col - 1] = false;
        }
        return false;
    }
}