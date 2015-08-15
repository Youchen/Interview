/**
 * O(col)
 * O(1)
 * 
 * review the DP matrix question.
 */
public class Solution {
    public int minCost(int[][] costs) {
        //2015-08-14 21:34:47 - 2015-08-14 21:38:30 (4 min)
        if(costs == null || costs.length == 0)
            return 0;
        
        int row = costs.length;
        for(int i = 1; i < row; i++){
            costs[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        return Math.min(costs[row - 1][0], Math.min(costs[row - 1][1], costs[row - 1][2]));
    }
}