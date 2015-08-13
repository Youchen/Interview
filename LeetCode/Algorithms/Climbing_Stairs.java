/**
 * Round 2
 * Nice done!
 */
public class Solution {
    public int climbStairs(int n) {
        //2015-05-23 12:26:43 - 2015-05-23 12:32:27 (6 min)
        if( n <= 1)
            return 1;
        
        //memo[i] is number of ways that climb from
        //bottom to the position [i].
        int[] memo = new int[n + 1];
        
        //initilization
        memo[0] = 1;
        memo[1] = 1;
        
        //function
        for(int i = 2; i < n + 1; i++){
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        
        //ans
        return memo[n];
    }
}






/**
 * O(n)
 * O(n)
 * 182 ms
 * 
 */
public class Solution {
    //#1 solution -- use only recursion.
    // public int climbStairs(int n) {
    //     if(n < 0)
    //         return 0;
    //     if(n == 0)
    //         return 1;
    //     return climbStairs(n - 1) + climbStairs(n - 2);
    // }
    
    //#2 solution -- use DP.
    // public int climbStairs(int n) {
    //     int[] arr = new int[1000];
    //     for(int i = 0; i < arr.length; i++){
    //         arr[i] = -1;
    //     }
    //     return dp(n, arr);
    // }
    // public int dp(int n, int[] arr){
    //     if(n < 0)
    //         return 0;
    //     if(n == 0)
    //         return 1;
    //     if(arr[n] != -1)
    //         return arr[n];
            
    //     arr[n] = dp(n - 1, arr) + dp(n - 2, arr);
    //     return arr[n];
    // }
    
    //#3 Solution attempted on Feb 28.
    public static int[] steps = new int[1000];

    public int climbStairs(int n){
        if(n == 0) return 1;
        if(n == 1) return 1;
    //  if(n == 2) return 2;
        if(steps[n] != 0)
            return steps[n];
        
        steps[n] = climbStairs(n - 1) + climbStairs(n - 2);// + steps(n - 3);
        return steps[n];
    }
    
}