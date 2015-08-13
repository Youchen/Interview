public class Solution {
    public int climbStairs(int n) {
        //2015-06-02 23:39:23 - 2015-06-02 23:47:27 (8 min)
        if(n < 0) return -1;
        if(n <= 1) return 1;
        
        int pre1 = 1;//0
        int pre2 = 1;//1
        int cur = pre1 + pre2;//2
        pre1 = pre2;
        pre2 = cur;
        
        for(int i = 3; i <= n; i++){
            cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        return cur;
    }
}

