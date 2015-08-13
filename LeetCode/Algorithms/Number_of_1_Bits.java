public class Solution {
    //you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //2015-06-24 21:01:41 - 2015-06-24 21:03:58 (2 min)
        int count = 0;
        
        for(int i = 0; i <= 31; i++){
            if(  ( (n >> i) & 1 ) == 1 )
                count++;
        }
        return count;
    }
}