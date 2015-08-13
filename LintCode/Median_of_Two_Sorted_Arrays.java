class Solution {
    //DO THIS AGAIN!
    public double findMedianSortedArrays(int[] A, int[] B) {
        //2015-05-25 22:01:30 pause 2015-05-25 22:12:31 resume 2015-05-25 22:32:37
        //- 2015-05-25 22:47:00 (26 min)
        //if A != null || B != null
        if((A.length + B.length) % 2 == 0){//even (mid + mid) / 2
            double left = kth(A, 0, B, 0, (A.length + B.length) / 2);
            double right = kth(A, 0, B, 0, (A.length + B.length) / 2 + 1 );
            return (left + right) / 2.0;
        }
        else
            return kth(A, 0, B, 0, (A.length + B.length) / 2 + 1);
    }
    private double kth(int[] A, int as, int[] B, int bs, int k){
        if(as >= A.length)
            return B[bs + k - 1];
        if(bs >= B.length)
            return A[as + k - 1];
        
        if(k == 1)
            return Math.min(A[as], B[bs]);
            
        int A_kDiv2 = as + k / 2 - 1 < A.length ? A[as + k / 2 - 1] : Integer.MAX_VALUE;
        int B_kDiv2 = bs + k / 2 - 1 < B.length ? B[bs + k / 2 - 1] : Integer.MAX_VALUE;
        
        if(A_kDiv2 <= B_kDiv2)
            return kth(A, as + k / 2, B, bs, k - k / 2);
        else
            return kth(A, as, B, bs + k / 2, k - k / 2);
    }
}


