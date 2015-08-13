/**
 * Be careful!!
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        //2015-05-26 20:09:27 - 2015-05-26 20:17:13 (8 min)
        if(nums == null || nums.length == 0)
            return 0;
        
        int index = 0;
        for(int i = 1; i < nums.length; i++){
            //different nums[index] = nums[i] index++, i++
            //same i++
            if(nums[i] != nums[index]){
                index++;
                nums[index] = nums[i];
            }
        }
        //0 1 2
        return index + 1;
    }
}

