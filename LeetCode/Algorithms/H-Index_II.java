/**
 * O(log n)
 * O(1)
 * 
 * be careful with the index, you need to return the
 *      len - left OR len - right
 * instead of
 *      left OR right
 */
public class Solution {
    public int hIndex(int[] citations) {
        //2015-09-07 13:57:00 - 2015-09-07 14:32:55 (~ 30 min)
        int len = citations.length;
        if(len == 0)
            return 0;
            
        int left = 0, right = len - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            
            if(citations[mid] >= len - mid)
                right = mid;
            else
                left = mid;
        }
        return citations[left] >= len - left ? len - left : (citations[right] >= len - right ? len - right : 0);
        
    }
}