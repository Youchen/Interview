/**
 * Round 2
 */
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        //2015-05-11 11:10:46 - 2015-05-11 11:21:04 (11 min)
        if(matrix == null || matrix.length == 0)
            return 0;
        
        int count = 0, row = matrix.length, col = matrix[0].length;
        int sRow = row - 1, sCol = 0;
        while(sRow >= 0 && sCol <= col - 1){
            if(matrix[sRow][sCol] >= target){//move up
                if(matrix[sRow][sCol] == target)
                    count++;
                    sRow--;
            }
            else{// if(matrix[sRow][sCol] < target){//move right
                    sCol++;
            }
        }
        return count;
    }
}









/**
 * Searching a 2D Sorted Matrix
 *
 * Write an efficient algorithm that searches for a value in an n x m table (two-dimensional array).
 * This table is sorted along the rows and columns — that is,
 *
 *		Table[i][j] ≤ Table[i][j + 1], 
 * 		Table[i][j] ≤ Table[i + 1][j]
 * (row-wise sorted && column-wise sorted)
 *
 * Reference:
 * 	Leetcode: http://articles.leetcode.com/2010/10/searching-2d-sorted-matrix.html
 * 	CodeMonkey: http://www.shuatiblog.com/blog/2014/06/10/Searching-a-2D-Sorted-Matrix/
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