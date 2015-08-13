/**
 * O(m + n)
 * O(m + n)
 * 
 * Note:
 *      error-prone and time-consuming problem.
 *      make sure that coding the start and the end index correct.
 */
public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public int[] printZMatrix(int[][] matrix) {
        //2015-05-19 13:50:54 (apprx. 1 h 30 min)
        if(matrix == null || matrix.length == 0)
            return null;
        
        int row = matrix.length, col = matrix[0].length;
        int[] res = new int[row * col];
        
        int resIndex = 0;
        int r = 0, c = 0;
        int sum = 0;
        boolean direction = true;
        
        while(sum <= row + col - 2 && resIndex <= row * col - 1){
            if(direction){//up
                if(sum <= row - 1) {
                	c = 0;
                	r = sum - c;
                }else {
                	r = row - 1;
                	c = sum - r;
                }
                while(c <= col - 1 && r >= 0) {
                	res[resIndex++] = matrix[r][c];
                	r--;
                	c++;
                }
                direction = false;
            }else{//down
            	if(sum > col - 1) {
            		c = col - 1;
            		r = sum - c;
            	}else {
            		r = 0;
            		c = sum - r;
            	}
            	while(r <= row - 1 && c >= 0) {
            		res[resIndex++] = matrix[r][c];
                	r++;
                	c--;
            	}
                direction = true;
            }
            sum++;
        }
        return res;
    }
}


