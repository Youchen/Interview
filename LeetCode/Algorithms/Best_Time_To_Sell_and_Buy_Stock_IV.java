/**
 * Very nice algorithm
 * But I cannot understand the two marked lines.
 * 
 * Reference:
 *      https://leetcode.com/discuss/25603/a-concise-dp-solution-in-java
 */
public class Solution{
    public int maxProfit(int k, int[] prices){
    	int len = prices.length;
    	if(k >= len / 2)
    		return quickSolve(prices);
    
    	//f[k][t] is the max profit we made in t time with most k transactions
    	int[][] f = new int[k + 1][len];
    
    	//initilization
    	//f[0][t] = 0;
    	//f[k][0] = 0 || -prices[0]; //corespond to sell and buy, sell and buy ...
    
    	for(int i = 1; i < k + 1; i++){
    		int tmpMin = prices[0];
    
    		for(int j = 1; j < len; j++){
    			f[i][j] = Math.max(f[i][j - 1], prices[j] - tmpMin);//======
    			tmpMin = Math.min(tmpMin, prices[j] - f[i - 1][j - 1]);//=======
    		}
    	}
    	return f[k][len - 1];
    }
    private int quickSolve(int[] prices){
    	int len = prices.length, profit = 0;
    	
    	for(int i = 1; i < len; i++)
    		if(prices[i] > prices[i - 1])
    			profit += prices[i] - prices[i - 1];
    			
    	return profit;
    }
}