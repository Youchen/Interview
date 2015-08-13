public class Solution {
    public int jump(int[] A) {
        //2015-06-03 15:18:10 - 2015-06-03 16:00:54 (42 min)
        if(A == null || A.length <= 0)
            return 0;
            
        int len = A.length;
        //jump[i] is the min step that I could jump to position i;
        int[] jump = new int[len];
        
        jump[0] = 0;
        
        if(A.length <= 1)
            return 0;
        
        for(int i = 1; i < len; i++){
            jump[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++){
                if( i - j <= A[j] && jump[j] + 1 < jump[i] ){
                    jump[i] = jump[j] + 1;
                }
            } 
        }
        
        return jump[len - 1];
    }
}