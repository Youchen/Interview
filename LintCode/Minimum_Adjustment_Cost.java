/**
 * O( A.size() * 101 * 101 ) = O( A.size() )
 * O( A.size() * 101 ) = O( A.size() )
 * 
 * DO THIS AGAIN!
 * 
 * Note:
 *      So hard.
 *      The function defination is hard to think of.
 *      
 *      Just copied the solution.
 *      Need to consider it again!
 *
 * Reference:
 *      http://www.cnblogs.com/yuzhangcmu/p/4153927.html
 */
public class Solution {
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        //2015-06-08 23:36:37 - 2015-06-09 01:05:47 (approx. 1h 30 min)
        if(A == null || A.size() == 0)
            return 0;
        
        int size = A.size();
        //f[i][t] : the min cost for first A[i] # and
        //              adjustify A[i] to t and satisfy that the 
        //              adjacent number <= target
        //since the max # of A[i] is 100, the possible # is 0 ~ 100
        int[][] f = new int[size][101];
        
        //f[0][v] = |A[i] - v|
        //f[i][v] = min( |A[i] - v| + f[i - 1][v'] )       |v' - v| <= target
        for(int i = 0; i < size; i++){
            for(int v = 1; v <= 100; v++){
                f[i][v] = Integer.MAX_VALUE;
                
                if(i == 0)
                    f[i][v] = Math.abs(A.get(i) - v);
                else{
                    for(int k = 1; k <= 100; k++){
                        if(Math.abs(v - k) <= target){
                            f[i][v] = Math.min(
                                    f[i][v], Math.abs(v - A.get(i)) + f[i - 1][k]
                                    );
                        }
                            
                    }
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            res = Math.min(res, f[size - 1][i]);
        }
            
        return res;
    }
}
