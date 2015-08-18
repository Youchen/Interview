/**
 * Round 4
 * O(1)
 * O(n)
 * 
 * Note:
 *      Thoughts is very important!!
 * 
 * Thoughts:
 * Scan from left to right. And keep track the minimal price in left. 
 *      So, each step, only calculate the difference between current price 
 *      and minimal price.
 *       If this diff large than the current max difference, replace it.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        //2015-08-17 22:37:26
        if(prices == null || prices.length <= 1)
            return 0;
        
        int min = prices[0], max = 0, profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(min > prices[i])
                min = prices[i];
                
            profit = prices[i] - min;
            if(profit > max)
                max = profit;
        }
        return max;
    }
}



/**
 * Round 3
 * 
 * idea is:
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








/**
 * Round 2
 * DO THIS AGAIN!!
 * O(1)
 * O(n)
 * 
 * Note:
 *      Thoughts is very important!!
 * 
 * Thoughts:
 * Scan from left to right. And keep track the minimal price in left. 
 *      So, each step, only calculate the difference between current price 
 *      and minimal price.
 *      If this diff large than the current max difference, replace it.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        //2015-05-25 18:53:00 - 2015-05-25 18:56:19 (2 min)
        if(prices == null || prices.length == 0)
            return 0;
        
        int min = prices[0], max = 0, profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(min > prices[i])
                min = prices[i];
                
            profit = prices[i] - min;
            if(profit > max)
                max = profit;
        }
        return max;
    }
}




/**
 * O(n)
 * O(1)
 * 178 ms
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        
        //here, the array must have elements >= 1;
        
        int min = prices[0], HistoricalMaxProfit = 0;
        int profit = 0;
        
        for(int i = 1; i < prices.length; i++){
           if(prices[i] < min) min = prices[i];
           profit = prices[i] - min;
           if(profit > HistoricalMaxProfit) HistoricalMaxProfit = profit;
        }
        
        return HistoricalMaxProfit;
    }
}