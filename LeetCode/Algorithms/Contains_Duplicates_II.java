/**
 * A little confused and time consuming.
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //2015-06-15 15:43:30 - 2015-06-15 16:00:17 (17 min)
        if(nums == null || nums.length == 0)
            return false;
        
        HashSet<Integer> hm = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k)
                hm.remove(nums[i - k - 1]);
            if( !hm.add(nums[i]) )
                return true;
        }
        return false;
    }
}