/**
 * O(nk)
 * Did not get it.
 * 
 * Reference:
 *      https://leetcode.com/discuss/52982/c-dp-time-o-nk-space-o-k
 *      maintain the minimum two costs min1(smallest) and min2 (second to smallest) after painting i-th house.
 */
public class Solution {
    public int minCostII(int[][] costs) {
        //2015-08-24 11:11:48
        int n = costs.length;
		if(n == 0)
			return 0;

		int k = costs[0].length;
		if(k == 0)
			return costs[0][0];

		int[] dp = new int[k];
		int min1 = 0, min2 = 0;//just for initialization

		for(int i = 0; i < n; i++){
			int min1_old = (i == 0) ? 0 : min1;
			int min2_old = (i == 0) ? 0 : min2;
			min1 = Integer.MAX_VALUE;
			min2 = Integer.MAX_VALUE;

			for(int j = 0; j < k; j++){
				if(dp[j] != min1_old || min1_old == min2_old){
					dp[j] = min1_old + costs[i][j];
				}
				else{
					dp[j] = min2_old + costs[i][j];
				}

				if(min1 <= dp[j])
					min2 = Math.min(min2, dp[j]);
				else{
					min2 = min1;
					min1 = dp[j];
				}
			}
		}
		return min1;   
    }
}