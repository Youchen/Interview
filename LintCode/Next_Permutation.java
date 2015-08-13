public class Solution {
    public int[] nextPermutation(int[] nums) {
        //2015-06-25 16:33:56 - 2015-06-25 16:51:01 (18 min)
        if(nums == null || nums.length == 0)
            return null;
        
        int len = nums.length;
        int p = -1;
        
        for(int i = len - 1; i >= 1; i--){
            if( nums[i] > nums[i - 1] ){
                p = i - 1;
                break;
            }
        }
        
        if(p == -1){
            return reverse(nums, 0, len - 1);
        }
        
        int firstLarger = Integer.MAX_VALUE;
        int firstLargerIndex = p + 1;
        
        //find the first number larger than nums[p]
        for(int i = p + 1; i < len; i++){
            if(nums[i] > nums[p]){
                firstLarger = Math.min(firstLarger, nums[i]);
                firstLargerIndex = i;
            }
        }
        
        swap(nums, firstLargerIndex, p);
        
        //reverse nums[p + 1, <end>]
        return reverse(nums, p + 1, len - 1);
        
    }
    private int[] reverse(int[] arr, int s, int e){
        int left = s;
        int right = e;
        while(left <= right){
            swap(arr, left, right);
            left++;
            right--;
        }
        return arr;
    }
    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
