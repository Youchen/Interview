/**
 * Note:
 *      You need to check if target == A[left] OR A[right]
 */
public class Solution {
    public int search(int[] A, int target) {
        // write your code here
        //2015-05-25 22:55:39 - 2015-05-25 23:10:58 (15 min)
        if(A == null || A.length == 0)
            return -1;
        
        int left = 0, right = A.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(A[mid] == target)
                    return mid;
            if(A[left] < A[mid]){//left is sorted
                if(A[left] == target)
                    return left;
                if(A[left] < target && target < A[mid])
                    right = mid;
                else
                    left = mid;
            }
            else if(A[mid] < A[right]){//right is sorted
                if(A[right] == target)
                    return right;
                if(A[mid] < target && target < A[right])
                    left = mid;
                else
                    right = mid;
            }
        }
        if(A[left] == target)
            return left;
        if(A[right] == target)
            return right;
        
        return -1;
    }
}


