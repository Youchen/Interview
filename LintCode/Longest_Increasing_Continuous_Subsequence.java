public class Solution {
    public int longestIncreasingContinuousSubsequence(int[] A) {
        //2015-08-18 20:08:50 - 2015-08-18 20:17:11 (9 min)
        if(A == null || A.length == 0)
            return 0;
        if(A.length == 1)
            return 1;
        
        int max = 0;
        int pre = 1;
        int cur = 0;// no meaning for 0. just for initialization.
        
        int dcrPre = 1;
        int dcrCur = 0;// no meaning for 0. just for initialization.
        
        for(int i = 1; i < A.length; i++){
            if(A[i] > A[i - 1]){
                cur = pre + 1;
                pre = cur;
            }else{
                cur = 1;
                pre = cur;
            }
            
            if(A[i] < A[i - 1]){
                dcrCur = dcrPre + 1;
                dcrPre = dcrCur;
            }else{
                dcrCur = 1;
                dcrPre = dcrCur;
            }
            
            max = Math.max(max, Math.max(cur, dcrCur) );    
        }
        return max;
    }
}
