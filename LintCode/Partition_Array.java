public class Solution {
    public int partitionArray(int[] nums, int k) {
        //2015-05-27 14:06:45 pause 2015-05-27 14:07:33
        //resume 2015-05-27 14:11:37 pause 2015-05-27 14:18:37
        //2015-05-27 14:23:42 (10 min)
        if(nums == null || nums.length == 0)
            return 0;

        int left = 0, right = nums.length - 1;
        while(left < right){
            while(left < right && nums[left] < k) left++;
            while(left < right && nums[right] >= k) right--;

            //swap
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= k)
                return i;
        }
        return nums.length;
    }
}


