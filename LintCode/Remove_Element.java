/**
 * Nice algorithm
 * DO THIS AGAIN!
 */
public class Solution {
    public int removeElement(int[] A, int target) {
        //2015-05-26 17:52:36
        if(A == null || A.length == 0)
            return 0;
        // if(A.length == 1)
        //     return A[0] == target ? 0 : 1;
        
        int left = 0, right = A.length - 1, len = 0;
        
        while(left <= right){
            if(A[left] == target){
                A[left] = A[right--];
            }else
                left++;
        }
        return right + 1;
    }
}


