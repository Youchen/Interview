class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        //2015-05-27 19:33:28 pause 2015-05-27 19:34:52
        //2015-05-27 19:43:17 (10 min)
        //resume 2015-05-27 19:38:06
        if(n <= 0) return -1;
        long count = 0;
        // long power = 1;
        
        // while(n / Math.pow(5, power) > 0){
        //     count += n / Math.pow(5, power);
        //     power++;
        // }
        
        for(long i = 5; n / i >= 1; i *= 5)
            count += n / i;
            
        return count;
    }
};


