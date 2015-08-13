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