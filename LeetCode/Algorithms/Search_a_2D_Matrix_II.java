/**
 * The binary search method is as following:
 *      - binary search the RANGE of the row;
 *      - iteratively binary search every row, until we find the target.
 */

/**
 * Round 2
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //2015-07-29 00:34:03 - 2015-07-29 00:37:30 (3 min)
        if(matrix == null || matrix.length == 0)
            return false;
        
        int row = matrix.length, col = matrix[0].length;
        int r = row - 1, c = 0;
        while(r >= 0 && c <= col - 1){
            if(matrix[r][c] == target)
                return true;
            
            if(matrix[r][c] > target)
                r--;
            else
                c++;
        }
        return false;
    }
}






/**
 * Searching a 2D Sorted Matrix
 *
 * Write an efficient algorithm that searches for a value in an n x m table (two-dimensional array).
 * This table is sorted along the rows and columns — that is,
 *
 *      Table[i][j] ≤ Table[i][j + 1], 
 *      Table[i][j] ≤ Table[i + 1][j]
 * (row-wise sorted && column-wise sorted)
 *
 * Reference:
 *  Leetcode: http://articles.leetcode.com/2010/10/searching-2d-sorted-matrix.html
 *  CodeMonkey: http://www.shuatiblog.com/blog/2014/06/10/Searching-a-2D-Sorted-Matrix/
 *
 */
//Time: O( Math.max(mat.row, mat.col) )
//Space: O(1)
public boolean stepWise(int[][] mat, int target){
    if(mat == null || mat.length == 0)
        return false;

    int row = 0, col = mat[0].length - 1;
    while(row <= mat.length - 1 && col >= 0){
        if(mat[row][col] < target)
            row++;
        else if(mat[row][col] > target)
            col--;
        else
            return true;
    }
    return false;
}