/**
 * O(n)
 * O(1)
 * 
 * Note:
 *      2 ways to do:
 *      
 *      1. simple way
 *          partition array as left is 0, right is 1 and 2
 *              get the array like 0 0 0 0 1 2 2 1 2 1 2 1 2 1 
 *          partition 1 2 part again.
 * 
 *      2. 3 pointers.
 *          while( mid <= right)
 *              if mid is 0 => swap with left pointer.
 *              if mid is 1 => mid++
 *              if mid is 2 => swap with right poitner.
 */
class Solution {
    public void sortColors(int[] nums) {
        //2015-06-24 16:34:20 - 2015-06-24 16:46:35 (12 min)
        if(nums == null || nums.length == 0)
            return;
        
        int len = nums.length;
        int left = 0, mid = 0, right = len - 1;
        
        while(mid <= right){
            if(nums[mid] == 0){
                swap(nums, left, mid);
                left++;
                mid++;
            }
            else if(nums[mid] == 1)
                mid++;
            else{//nums[mid] == 2
                swap(nums, mid, right);
                right--;
            }
            
        }
    }
    private void swap(int[] A, int l, int r){
        if(l == r)
            return;
        int temp = A[l];
        A[l] = A[r];
        A[r] = temp;
    }
}
