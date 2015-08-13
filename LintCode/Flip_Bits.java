class Solution {
    public static int bitSwapRequired(int a, int b) {
        //2015-05-27 18:26:39 - 2015-05-27 19:02:19 (36 min)
        if(a == b)
            return 0;
            
        int xor = a ^ b;
        int count = 0;
        int loop = 32;
        
        while( loop > 0){
            count += xor & 1;
            xor = xor >> 1;
            loop--;
        }
        
        return count;
    }
};