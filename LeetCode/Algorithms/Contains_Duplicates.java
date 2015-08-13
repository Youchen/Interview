public class Solution {
    public boolean containsDuplicate(int[] nums) {
        //2015-06-15 15:39:36 - 2015-06-15 15:42:44 (3 min)
        if(nums == null || nums.length == 0)
            return false;
        
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i : nums){
            if( ! hs.add(i) )
                return true;
        }
        return false;
    }
}