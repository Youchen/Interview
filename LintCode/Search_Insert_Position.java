public class Solution {
    public int searchInsert(int[] A, int target) {
        // write your code here
        //2015-05-25 21:12:50 - 2015-05-25 21:24:20 (11 min)
        if(A == null || A.length == 0)
            return 0;
        
        int left = 0, right = A.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(A[mid] <= target)
                left = mid;
            else
                right = mid;
        }
        if(A[right] < target)
            return right + 1;
        if(A[left] >= target)
            return left;
        // else if(A[right] == target)
        //     return right;
        // else if(A[left] == target)
        //     return left;
        else
            return right;
    }
}


