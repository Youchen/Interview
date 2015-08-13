/**
 * O(n)
 * O(n)
 * 
 * Note:
 *      Be careful with the case like [1, 2, 0, 1]
 *      So after count the upper bound, like 1, 2, 3, ...
 *      you need to reset the var to num[i], like reset curValue to 1
 *          and count downwards, like 1, 0, -1, -2 ...
 * 
 *      then count the max.
 */
public class Solution {
    public int longestConsecutive(int[] num) {
        //2015-06-17 23:12:21 - 2015-06-17 23:26:44 (14 min)
        if(num == null || num.length == 0)
            return 0;
        
        int max = 1;
        //put all into hash map
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i : num)
            hs.add(i);
        
        for(int i = 0; ! hs.isEmpty() && i < num.length; i++){
            int curValue = num[i];
            
            if( ! hs.contains(curValue) )
                continue;
            
            int count = 1;
                
            hs.remove(curValue);
            
            while (hs.contains(curValue - 1) ){
                count++;
                hs.remove(curValue - 1);
                curValue--;
            }
            
            curValue = num[i];
            
            while( hs.contains(curValue + 1) ){
                count++;
                hs.remove(curValue + 1);
                curValue++;
            }
            
            max = Math.max(max, count);
        }
        return max;
    }
}
