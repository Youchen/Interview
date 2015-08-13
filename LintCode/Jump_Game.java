public class Solution {
    public boolean canJump(int[] A) {
        //2015-06-03 17:17:27 - 2015-06-03 17:19:36
        if(A == null || A.length == 0)
            return true;
        
        int maxReach = 0;
        for(int i = 0; i <= maxReach && i < A.length; i++){
            
            maxReach = Math.max(maxReach, A[i] + i);
        }
        
        if(maxReach < A.length - 1)
            return false;
        
        return true;
    }
}