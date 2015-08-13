/**
 * Round 3
 * O(n!)
 * O(1)
 * 
 * Need to be more proficient
 */
class Solution {
    public int totalNQueens(int n) {
        //2015-06-15 09:13:03 - 2015-06-15 09:29:03 (16 min)
        if(n <= 1)
            return n;
        
        int[] res = new int[1];
        res[0] = 0;
        
        totalNQueens_Helper(n, res, new int[n], 0);
        return res[0];
    }
    private void totalNQueens_Helper(int n, int[] res, int[] position, int row){
        if(row == n){
            //add solution
            res[0]++;
            return;
        }
        
        for(int i = 0; i < n; i++){
            position[row] = i;
            
            if(isValid(row, position)){
                totalNQueens_Helper(n, res, position, row + 1);
            }
        }
    }
    private boolean isValid(int row, int[] position ){
        
        //vertical invalid && diagonal invalid
        for(int i = 0; i < row; i++){
            if(position[i] == position[row] ||
                Math.abs(row - i) == Math.abs(position[i] - position[row]) )
                return false;
        }
        return true;
    }
};


