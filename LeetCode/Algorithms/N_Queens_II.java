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










/**
 * Round 2 - Need to be proficient
 * DO THIS AGAIN
 */
public class Solution {
    public int totalNQueens(int n) {//2015-05-06 14:20:18 - 2015-05-06 14:31:08 (11 min)
        if(n < 0)
            return -1;
        //ArrayList<Integer>
        int[] sol = new int[1];
        sol[0] = 0;
        
        helper(n, sol, 0, new int[n]);
        return sol[0];
    }
    private void helper(int n, int[] sol, int level, int[] pos){
        if(level == n){
            sol[0]++;
            return;
        }
        for(int i = 0; i < n; i++){
            pos[level] = i;
            if(valid(level, pos))
                helper(n, sol, level + 1, pos);
        }
    }
    private boolean valid(int level, int[] pos){
        for(int i = 0; i < level; i++){
            if(pos[i] == pos[level] ||
                level - i == Math.abs(pos[level] - pos[i])
            )
            return false;
        }
        return true;
    }
}




/**
 * O(n!)
 * O(n)
 * 216 ms
 * 
 * Note:
 *      The error-prone point is the global variable.
 *      You need to declare it as global but do not pass it together with the recursion
 *          method. like
 *          helper(count ...);
 *      or else, the count will not be updated!!
 */
public class Solution {
    int count;
    public int totalNQueens(int n) {
        if(n <= 0) return 0;
        
        count = 0;
        helper(n, new int[n], 0);
        return count;
    }
    private void helper(int n, int[] columnForRow, int row){
        if(row == n){
            count++;
            return;
        }
        for(int i = 0; i < n; i++){
            columnForRow[row] = i;
            
            if(isValid(columnForRow, row)){
                helper(n, columnForRow, row + 1);
            }
        }
    }
    private boolean isValid(int[] columnForRow, int row){
        for(int i = 0; i < row; i++){//CAUTION! here should be "i < row" NOT "i < columnForRow.length"
            if(columnForRow[i] == columnForRow[row] //cannot be in same column
                || row - i == Math.abs(columnForRow[i] - columnForRow[row]) //cannot be palced diagonally
                )
                return false;
        }
        return true;
    }
}