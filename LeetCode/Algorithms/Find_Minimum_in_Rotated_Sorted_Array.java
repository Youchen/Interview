/**
 * Round 4
 */
public class Solution {
    public int findMin(int[] nums) {
        //2015-07-28 23:14:15 - 2015-07-28 23:16:56 (2 min)
        if(nums == null || nums.length == 0)
            return -1;
            
        int left = 0, right = nums.length - 1;
        if(nums[left] < nums[right])
            return nums[left];
        
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            
            if(nums[left] < nums[mid])
                left = mid;
            else
                right = mid;
        }
        return (nums[left] < nums[right]) ? nums[left] : nums[right];
    }
}




/**
 * Round 3
 */
public class Solution {//return element.
    public int findMin(int[] nums) {//2015-05-11 15:20:02 - 2015-05-11 15:24:21 (4 min)
        if(nums == null || nums.length == 0)
            return -1;
        
        int left = 0, right = nums.length - 1;
        //if not rotate
        if(nums[left] < nums[right])
            return nums[left];
            
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[left] < nums[mid])
                left = mid;
            else
                right = mid;
        }
        return (nums[right] > nums[left]) ? nums[left] : nums[right];
    }
}




/**
 * Round 2 - 3/16
 * This solution is short and efficient.
 * Better do this again.
 */
public class Solution{
    public int findMin(int[] num){
        if(num.length == 0 || num == null) return -1;
    
        int left = 0, right = num.length - 1;
        while(left < right){// && num[left] >= num[right])
            int mid = left + (right - left) / 2;
            if(num[mid] > num[right])
                left = mid + 1;
            else//mid <= right -- since mid might be the minimum.
                right = mid;
        }
        return num[left];
    }
}




/**
 * O(log n)
 * O(1)
 * 247 ms
 * 
 * Note:
 *      Draw a simple graph to analysis the case.
 *      This problem is actually finding a decreasing part if the array is really rotated.
 */
public class Solution {
    public int findMin(int[] num) {
        int len = num.length;
        if(num == null || len == 0) return -1;
        if(len == 1) return num[0];
        
        //these are the indices
        int left = 0, right = len - 1, mid = len / 2;
        
        while(left + 1 != right){
            if(num[left] > num[mid]){//left decreasing
                right = mid;
            }
            else if(num[mid] > num[right]){//right decreasing?
                left = mid;
            }
            else if(num[left] < num[mid] && num[mid] < num[right]){//both increasing
                right = mid;
            }else if(num[left] > num[mid] && num[mid] > num[right]){//both decreasing
                left = mid;
            }
            mid = left + (right - left) / 2;
        }
        return (num[right] < num[left])? num[right] : num[left];
    }
}