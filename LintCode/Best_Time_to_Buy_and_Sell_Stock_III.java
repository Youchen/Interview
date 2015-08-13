/**
 * O(3n) = O(n)
 * O(2n) = O(n)
 * 
 * Note:
 *      At most two times ==> we can think the problem
 *          "Best Time to Buy and Sell Stock(BTBSS)", if we see
 *          this problem as separately TWO BTBSS, we could solve
 *          this problem.
 * 
 *      for example: "|" separate two transactions.
 *          [4 4 6 1 1 4 2 5]
 *          [|4 4 6 1 1 4 2 5] only second trans. happens.
 *          [4 | 4 6 1 1 4 2 5] first transanction buy and sell on
 *                              first day, then 2nd trans.
 *          ...
 * 
 *      we scan from left to right to get the cummulative value of
 *          BTBSS left[].
 *      .............right...left ................................
 *          ......right[].
 * 
 *      then we iterate the separate line from left most thru right most.
 *          like
 *              [| .....] to [.... |]
 */
public class Solution {
    public int maxProfit(int[] prices) {
        //2015-06-22 09:40:30 pause 2015-06-22 09:42:27
        //2015-06-22 10:04:25 - 2015-06-22 10:27:03 (25 min)
        if(prices == null || prices.length == 0)
            return 0;
        
        int len = prices.length;
            
        //compute left[i], the BTTBSS starts 0 ends at prices[i]
        int[] left = new int[len];
        int min = prices[0];
        left[0] = 0;
    
        for(int i = 1; i < len; i++){
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        //compute right[i], the BTTBSS starts last index ends at prices[i]
        int[] right = new int[len];
        int max = prices[len - 1];
        right[len - 1] = 0;
    
        for(int i = len - 2; i >= 0; i--){
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }
        //max( left[i] + right[i + 1] )
        int maxProfit = 0;
        for(int i = -1; i <= len - 1; i++){
            int separateLine = (i == -1) ? right[0] : ( 
                                (i == len - 1) ? left[len - 1] : left[i] + right[i + 1] 
                                );
            maxProfit = Math.max(maxProfit, separateLine);
        }
        
        return maxProfit;
    }
}