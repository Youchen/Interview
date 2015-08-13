public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        //2015-05-27 19:16:37 - 2015-05-27 19:21:05 (6 min)
        if(m <= 0 || n <= 0)
            return 0;
        
        int[] memo = new int[n];
        for(int i = 0; i < n; i++)
            memo[i] = 1;
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                memo[j] = memo[j] + memo[j - 1];
            }
        }
        return memo[n - 1];
    }
}


