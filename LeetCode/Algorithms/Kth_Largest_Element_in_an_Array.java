/**
 * 2015-08-31 10:41:43
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length) 
            return -1;

        return getKth(nums, 0, nums.length - 1, nums.length - k);
    }
    private int getKth(int[] nums, int start, int end, int sortedIndexicalK){
        int pivot = nums[end];
        int left = start, right = end;
        
        while(left < right){
            while(left < right && nums[left] < pivot) left++;
            while(left < right && nums[right] >= pivot) right--;
            
            // if(left == right) break;
            
            swap(nums, left, right);
        }
        swap(nums, left, end);
        
        if(sortedIndexicalK == left)
            return pivot;
        if(sortedIndexicalK < left)
            return getKth(nums, start, left - 1, sortedIndexicalK);
        return getKth(nums, left + 1, end, sortedIndexicalK);
    }
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}








/**
 * Cost so much time.
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        //2015-05-29 19:48:41 pause 2015-05-29 20:41:52 resume 2015-05-30 12:06:25
        //2015-07-10 13:20:37 - 5 min - 2015-07-10 14:32:27 (1 h 12 min)
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length) 
            return -1;

        return getKth(nums, 0, nums.length - 1, nums.length - k);
    }
    private int getKth(int[] nums, int start, int end, int sortedIndexicalK){
        int pivot = nums[end];
        int left = start, right = end;
        
        while(true){
            while(left < right && nums[left] < pivot) left++;
            while(left < right && nums[right] >= pivot) right--;
            
            if(left == right) break;
            
            swap(nums, left, right);
        }
        swap(nums, left, end);
        
        if(sortedIndexicalK == left)
            return pivot;
        if(sortedIndexicalK < left)
            return getKth(nums, start, left - 1, sortedIndexicalK);
        return getKth(nums, left + 1, end, sortedIndexicalK);
    }
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}