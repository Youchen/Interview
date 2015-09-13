/**
 * O(n lg n) + O(n) = O(n lg n)
 * O(1)
 */
public class Solution {
    public int hIndex(int[] citations) {
        //2015-09-07 11:47:10 - 2015-09-07 11:53:49 (6 min)
        if(citations == null || citations.length == 0)
            return 0;
            
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++){
            if(citations[i] >= citations.length - i)
                return citations.length - i;
        }
        return 0;
    }
}