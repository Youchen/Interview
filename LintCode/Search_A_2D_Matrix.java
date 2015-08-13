public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	//2015-05-27 14:47:16 pasue 2015-05-27 14:51:06
    	//resume 2015-05-27 14:59:12 pause 2015-05-27 15:05:03
    	//resume 2015-05-27 16:52:08 - 2015-05-27 16:54:21
    	//12 min
    	if(matrix == null || matrix.length == 0)
    		return false;

    	int row = matrix.length, col = matrix[0].length;
    	int left = 0, right = row * col - 1, r, c;
    	while(left + 1 < right){
    		int mid = left + (right - left) / 2;
    		r = mid / col;
    		c = mid % col;
    		if(matrix[r][c] == target)
    			return true;
    		if(matrix[r][c] < target)
    			left = mid;
    		else 
    			right = mid;
    	}
    	//left right
    	if(matrix[left / col][left % col] == target || 
    		matrix[right / col][right % col] == target)
    		return true;
    	return false;
    }
}




