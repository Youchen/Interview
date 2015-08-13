/**
 * Round 2 - cost so much time.
 * DO THIS AGAIN
 * 
 * Note:
 *      do not use reference type like boolean[] stop to terminate the helper function.
 *      try to have a return type for helper function
 */
public class Solution {
    public void solveSudoku(char[][] board) {//2015-05-07 15:10:11 - 2015-05-07 15:16:56 (6 min)
        if(board == null || board.length == 0)
            return;
        
        helper(board);
    }
    private boolean helper(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){

                if(board[i][j] == '.'){
                    for(char k = '1'; k <= '9'; k++){// char value could be increased by ++
                        if(check(board, i, j, k)){
                            board[i][j] = k;  // critical part below
                            if(helper(board))
                                return true;
                            else
                                board[i][j] = '.'; // critical part above
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean check(char[][] board, int r, int c, char num){
        int row = board.length, col = board[0].length;
        
        //check horizontal
        for(int i = 0; i < col; i++)
            if(board[r][i] == num)
                return false;
        
        
        //check vertical
        for(int i = 0; i < row; i++)
            if(board[i][c] == num)
                return false;
        
        //check block
        for(int i = r / 3 * 3; i < r / 3 * 3 + 3; i++)
            for(int j = c / 3 * 3; j < c / 3 * 3 + 3; j++)
                if(board[i][j] == num)
                    return false;
                    
        return true;
    }
}







/**
 * O(?)
 * O(?)
 * 257 ms
 * 
 * Note:
 *      Key idea is the recursion parts.
 */
public class Solution {
    public void solveSudoku(char[][] board) {//2:17 pause 2:22 resume 9:50
        if(board == null && board.length == 0)
            return;
        helper(board);
    }
    private boolean helper(char[][] board){
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.')
                    continue;
                
                for(char fill = '1'; fill <= '9'; fill++){
                    if(check(board, i, j, fill)){
                        board[i][j] = fill;
                        
                        if(helper(board))
                            return true;
                        else
                            board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }
    private boolean check(char[][] board, int r, int c, char num){
        int row = board.length, col = board[0].length;
        
        //check horizontal
        for(int i = 0; i < col; i++)
            if(board[r][i] == num)
                return false;
        
        
        //check vertical
        for(int i = 0; i < row; i++)
            if(board[i][c] == num)
                return false;
        
        //check block
        for(int i = r / 3 * 3; i < r / 3 * 3 + 3; i++)
            for(int j = c / 3 * 3; j < c / 3 * 3 + 3; j++)
                if(board[i][j] == num)
                    return false;
                    
        return true;
    }
}