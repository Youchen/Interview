public class Solution {
    public int woodCut(int[] L, int k) {
        //2015-05-27 17:23:35 - 2015-05-27 17:30:32 (7 min with seeing the solution)
        if(L == null || L.length == 0 || k < 0)
            return 0;

        //find max length.
        int maxLen = 0;
        for(int i = 0; i < L.length; i++){
            maxLen = Math.max(maxLen, L[i]);
        }
        int left = 0, right = maxLen;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(woodSum(L, mid) >= k)
                left = mid;
            else//< k
                right = mid;
        }
        if(woodSum(L, right) >= k)
            return right;
        return left;

    }
    private int woodSum(int[] L, int len){
        int sum = 0;
        for(int i = 0; i < L.length; i++){
            sum += L[i] / len;
        }
        return sum;
    }
}