/**
 * Round 3
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {//2015-05-11 10:31:24 - 2015-05-11 10:42:19 (11 min)
        if(nums == null || nums.length == 0)
            return -1;
        
        int left = 0, right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left )/2;
            if(nums[mid] <= target)
                left = mid;
            else
                right = mid;
        }
        
        /**
         * For 2 numbers, there are 5 positions for inserting a number.
         *          1 NUM 2 NUM 3 (2 NUM positions)
         * so below are these 5 situations.
         */
        if(nums[left] > target)
            return 0;
        else if(nums[left] == target)
            return left;
        else if(nums[left] < target && target < nums[right])
            return right;
        else if(nums[right] == target)
            return right;
        else// if(nums[right] < target)
            return right + 1;
    }
}










/**
 * Round 2 - 4/1
 * O(log n)
 * O(1)
 * 
 * 235 ms
 * 
 * Note:
 *      Understand the template.
 */
public class Solution {
    public int searchInsert(int[] A, int target) {//0401 : 17:43 - 17:45
        if(A == null || A.length == 0)
            return -1;
            
        int left = 0, right = A.length - 1;
        int mid;
        
        while(left + 1 < right){
            mid = left + (right - left) / 2;
            if(A[mid] < target)
                left = mid;
            else 
                right = mid;
        }
        
        if(target <= A[left])
            return left;
        else if(A[left] < target && target <= A[right])
            return right;
        else
            return right + 1;
    }
}








/**
 * O(log n)
 * 213 ms
 * 
 * Array
 * BinarySearch
 */ 
public class Solution {//33 min
    public int searchInsert(int[] A, int target) {
        if(A.length == 0) return 0;
        if(target > A[A.length - 1]) return A.length;
        
        int left = 0, right = A.length - 1, mid = 0;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(A[mid] == target)
                return mid;
            else if(A[mid] < target){
                left = mid + 1;
            }
            else
                right = mid - 1;
        }//while
        if(A[mid] > target) return mid;
        else return mid + 1;
    }
}