/**
 * Round 4
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        //2015-05-18 18:21:17 -42 - 2015-05-18 19:27:32 (24 min)
        if(nums == null)
            return 0;
        if(nums.length <= 2)
            return nums.length;
        
        int count = 1, p1 = 0;
        for(int p2 = 1; p2 < nums.length; p2++){
            if(nums[p1] == nums[p2] && count == 1){
                nums[++p1] = nums[p2];
                count = 2;
            }
            else if(nums[p1] != nums[p2]){
                nums[++p1] = nums[p2];
                if(count == 2)
                    count = 1;
            }
        }
        return p1 + 1;
    }
}





/**
 * Round 3
 * Note:
 *       it's simple by using for loop.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {//2015-05-11 16:20:12 - 2015-05-11 16:28:54 (8 min)
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
            
        int size = 0;
        byte count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[size] && count == 1){
                nums[++size] = nums[i];
                count = 2;
            }
            else if(nums[i] != nums[size]){
                nums[++size] = nums[i];
                if(count == 2)
                    count = 1;
            }
        }
        return size + 1;
    }
}






/**
 * Round 3
 */
public class Solution {
    public int removeDuplicates(int[] nums) {//2015-05-11 15:58:31 - 2015-05-11 16:12:15 (14 min)
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        
        int p1 = 0, p2 = 1;
        byte count = 1;
        
        while(p2 <= nums.length - 1){
            if(nums[p1] == nums[p2] && count == 1){
                count = 2;
                p1++;
                nums[p1] = nums[p2];
                p2++;
            }
            else if(nums[p1] == nums[p2] && count == 2){
                p2++;
            }
            else if(nums[p1] != nums[p2]){
                p1++;
                nums[p1] = nums[p2];
                p2++;
                count = 1;
            }
        }
        return p1 + 1;
    }
}






/**
 * Round 2 - 4/16 (4 min)
 */
public class Solution {
    public int removeDuplicates(int[] A) {//17:47 - 17:51 (4 min)
        if(A == null || A.length == 0)
            return 0;
        
        int left = 1, right = 1, time = 1;
        while(right < A.length){
            if(A[right] != A[right - 1]){
                A[left] = A[right];
                left++;
                time = 1;
            }
            else if(A[right] == A[right - 1] && time == 1){
                A[left] = A[right];
                time = 2;
                left++;
            }
            
            right++;
        }
        return left;
    }
}




/**
 * O(n)
 * O(1)
 * 264 ms
 * 
 * Note:
 *      Easy but error-prone problem.
 *      Be careful, time should be 1, not 0.
 */
public class Solution {
    public int removeDuplicates(int[] A) {//20:44 - 20:52 (8 min)
        if(A == null || A.length == 0)
            return 0;
        
        int left = 1, right = 1;
        int time = 1;
        while(right < A.length){
            if(A[right] != A[right - 1]){
                A[left] = A[right];
                left++;
                time = 1;
            }
            else if(A[right] == A[right - 1] && time == 1){
                time++;
                A[left] = A[right];
                left++;
            }
            right++;
        }
        return left;
    }
}