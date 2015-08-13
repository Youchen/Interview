class Solution {
    public int binarySearch(int[] nums, int target) {
        //2015-05-25 21:25:33 - 2015-05-25 21:32:14 (7 min)
        if(nums == null || nums.length == 0)
            return -1;
        
        int left = 0, right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target)
                left = mid;
            else
                right = mid;
        }
        if(nums[left] == target)
            return left;
        else if(nums[right] == target)
            return right;
        else
            return -1;
    }
}

