class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        //2015-05-25 21:34:18 - 2015-05-25 21:42:39 (8 min)
        if(A == null || A.length == 0)
            return -1;
        
        int left = 0, right = A.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            
            if(mid - 1 >= 0 && mid + 1 <= A.length - 1 &&
                A[mid] > A[mid - 1] && A[mid] > A[mid + 1])
                return mid;
                
            if(mid + 1 <= A.length -1 && A[mid] < A[mid + 1])
                left = mid;
            else if(mid + 1 <= A.length - 1 && A[mid] > A[mid + 1])
                right = mid;
        }
        if(A[left] < A[right])
            return right;
        else
            return left;
    }
}


