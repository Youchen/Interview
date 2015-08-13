public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        //2015-06-24 22:16:48 - 2015-06-24 22:30:39 (14 min)
        int res = 0;
        
        for(int i = 0; i <= 31; i++){
            int mostRight = (n >> i) & 1;
            
            if( mostRight == 1 )//mostRight bit is 1
                res += 1;
            
            //if n = 1, in the 31th loop, res is 1000..000(31 zeros)
            //      so, when i == 31, do not shift!!
            if(i <= 30)
                res = (res << 1);
        }
        return res;
    }
}