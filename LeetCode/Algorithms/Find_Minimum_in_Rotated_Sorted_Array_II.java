/**
 * Round 2
 * Be careful for the equal condition.
 */
public class Solution {
    public int findMin(int[] nums) {//2015-05-11 15:25:35 - 2015-05-11 15:35:06 (10 min)
        if(nums == null || nums.length == 0)
            return -1;
        
        int left = 0, right = nums.length - 1;
        if(nums[left] < nums[right])//?
            return nums[left];
            
        while(left + 1 < right){
            if(nums[left] == nums[right])
                left++;
            else{
                int mid = left + (right - left) / 2;
                if(nums[mid] <= nums[right]){//right sorted
                    if(nums[mid] == nums[right])
                        right--;
                    else
                        right = mid;
                }else if(nums[mid] >= nums[left]){//left sorted
                    if(nums[mid] == nums[left])
                        left++;
                    else
                        left = mid;
                }
                
            }//else
        }//while
        return (nums[left] <= nums[right]) ? nums[left] : nums[right];
    }
}




/**
 * O(n)
 * O(1)
 * 229 ms
 * 
 * Note:
 *      This is a very nice practice for BS.
 *      Same algorithm principle as "Search in Rotated Sorted Array II"
 */
public class Solution {
    public int findMin(int[] num) {
        if(num.length == 0 || num == null) return -1;
        
        int left = 0, right = num.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            
            if(num[mid] > num[right] )
                left = mid + 1;
            else if(num[mid] == num[right])
                right--;
            else//mid < right
                right = mid;
            
            // if(left + 1 == right) break;
        }
        return num[left];
    }
}