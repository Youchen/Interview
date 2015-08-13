/**
 * Round 2
  */
class Solution {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        //2015-05-25 21:03:14 - 2015-05-25 21:10:59(7 min)
        if(A == null || A.length == 0 || B == null || B.length == 0)
            return;
        
        // int aIndex = A.length - 1, bIndex = B.length - 1;
        int aIterator = A.length - 1;
        m--;
        n--;
        while(m >= 0 || n >= 0){
            if(m < 0)
                A[aIterator--] = B[n--];
            else if(n < 0)
                A[aIterator--] = A[m--];
            else
                A[aIterator--] = A[m] >= B[n] ? A[m--] : B[n--];
        }
        return;
    }
}








/**
 * Submission failed at the condition checking.
 * So in the interview, don't Zhuang Niu X, just write the
 *      LONG but CORRECT code at first.
 */
class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
        //2015-05-11 16:41:31 - 2015-05-11 16:54:07 (13 min)
        if(A == null)
            return B;
        if(B == null)
            return A;
           
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        while(A.size() != 0 || B.size() != 0){
            if(B.size() == 0 || (A.size() != 0 && A.get(0) < B.get(0)) ){
                res.add(A.get(0));
                A.remove(0);
            }
            else if(A.size() == 0 || (B.size() != 0 && A.get(0) >= B.get(0)) ){
                res.add(B.get(0));
                B.remove(0);
            } 
        }
        return res;
    }
}

