class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        //2015-05-27 19:05:30 - 2015-05-27 19:15:21 (10 min)
        if(n == 1) return true;
        if(n <= 0) return false;
        
        return (n & (n - 1)) == 0;
    }
};

