/**
 * Round 2 - Nice done.
 * Note:
 *      Remember the SanBuFanZhuanFa.
 */
public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        //2015-05-12 17:27:55 - 2015-05-12 17:33:24 (5 min)
        if(nums == null || nums.size() == 0)
            return;
            
        int i;
        for(i = 0; i < nums.size(); i++){
            if(i > 0 && nums.get(i) < nums.get(i - 1))
                break;
        }
        reverse(nums, 0, i - 1);
        reverse(nums, i, nums.size() - 1);
        reverse(nums, 0, nums.size() - 1);
        return;
    }
    private void reverse(ArrayList<Integer> nums, int start, int end){
        while(start < end){
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            
            start++;
            end--;
        }
        return;
    }
}






/**
 * O(n + n) = O(n)
 * O(1)
 * 
 * Be careful and be fast.
 */
import java.util.*;
public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {//16:10 - 16:35 (25 min)
        // write your code
        if (nums == null || nums.size() <= 1 || nums.get(0) < nums.get(nums.size() - 1) )
            return;
        
        int begin = 0;
        while(nums.get(begin) <= nums.get(begin + 1) ){
            begin++;
        }
        begin++;
        
        rotate3(nums, 0, begin - 1);
        rotate3(nums, begin, nums.size() - 1);
        rotate3(nums, 0, nums.size() - 1);  
    }
    private void rotate3(ArrayList<Integer> nums, int s, int e){
        while(s < e){
            int temp = nums.get(s);
            nums.set(s, nums.get(e));
            nums.set(e, temp);
            
            s++;
            e--;
        }
    }
}