/**
 *  idea is:
 *      maintain a min value, then iterate from left to right, 
 *          update the min and calculate profit( current - min )
 * 
 *      the answer is the max profit in the process of iteration.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        //2015-06-22 00:36:42 - 2015-06-22 00:41:23 (5 min)
        if(prices == null || prices.length == 0)
            return 0;
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, profit = 0;
        
        for(int i : prices){
            if(i < min)
                min = i;
            
            profit = i - min;
            
            if(profit > max)
                max = profit;
        }
        return max;
    }
}
