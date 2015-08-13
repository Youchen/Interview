/**
 * Round 2
 */
class Solution {
    public int maxProfit(int[] prices) {
        //2015-06-22 00:45:52 - 2015-06-22 00:52:53 (7 min)
        if(prices == null || prices.length == 0)
            return 0;
        
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1] )
                profit += prices[i] - prices[i - 1];
        }
        
        return profit;
    }
}





/**
 * O(n)
 * O(1)
 * 230 ms
 * 
 * Note:
 *      See this problem as finding the increasing phrase.
 *      The graph of the prices is just like an wave line.
 *      We need to find out the sum of the increasing phrase.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0 || prices == null) return 0;
        
        int profit = 0;
        for(int i = 1; i < len; i++){
            if(prices[i] > prices[i - 1])
                profit += (prices[i] - prices[ i - 1]);
        }
        return profit;
    }
}