/**
 * Review how to find the left bound and right bound by
 *      modifying the if statement in while loop
 *          find right bound
 *              if(target <= nums[mid])
 *                    right = mid;
 *                else
 *                    left = mid;
 *
 *          find left bound
 *              if(target >= nums[mid])
 *                    left = mid;
 *                else
 *                    right = mid;
 */
/**
 * Round 3
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {//2015-05-11 10:16:08 - 2015-05-11 10:25:26 (9 min)
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if(nums == null || nums.length == 0)
            return res;
        
        int left = 0;
        int right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(target <= nums[mid])
                right = mid;
            else
                left = mid;
        }
        if(nums[left] == target)
            res[0] = left;
        else if(nums[right] == target)
            res[0] = right;
        else
            return new int[]{-1, -1};
        
        /**
         * search for the left bound
         */
        left = 0;
        right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(target >= nums[mid])
                left = mid;
            else//<
                right = mid;
        }
        if(nums[right] == target)
            res[1] = right;
        else
            res[1] = left;
        
        return res;
        
    }
}









/**
 * 2nd Round - 4/1
 *
 * O(log n + log n) = O(log n)
 * O(1)
 * 245 ms
 *
 * Note:
 *  index:   0, 1, 2, 3  4
 *      A = {1, 1, 1, 1};
 *      B = {0, 0, 1, 2, 3};
 *      target = 1;
 * 
 *      Magic point:
 *          use: A[mid] < target
 *                  after while loop:
 *                      A : left, right = 0, 1
 *                      B : left, right = 1, 2
 *          use: A[mid] <= target
 *                  after while loop:
 *                      A : left, right = 2, 3
 *                      B : left, right = 2, 3
 *
 *  Another Thing!
 *      Write correctly, avoid coding like
 *          A[left] < target
 *      Be careful!
 */
public class Solution {
    public int[] searchRange(int[] A, int target) {//17:48
        int[] res = {-1, -1};
        if(A == null || A.length == 0)
            return res;
        /**
         * Find left bound
         */
        int left = 0, right = A.length - 1;
        int mid;
        while(left + 1 < right){
            mid = left + (right - left) / 2;
            if(A[mid] < target)
                left = mid;
            else
                right = mid;
        }
        if(A[left] == target)
            res[0] = left;
        else if(A[right] == target)
            res[0] = right;
        else//taget did not found.
            return res;
            
        /**
         * Find right bound
         */
        left = 0;
        right = A.length - 1;
        while(left + 1 < right){
            mid = left + (right - left) / 2;
            if(A[mid] <= target)
                left = mid;
            else
                right = mid;
        }
        if(A[right] == target)
            res[1] = right;
        else if(A[left] == target)
            res[1] = left;
        
        return res;
    }
}














/**
 * O(log n + log n) = O(log n)
 * O(1)
 * 271 ms
 * 
 * Note:
 *      Need to master the BS application for real problem.
 * 
 * Reference:
 *      https://leetcode.com/discuss/19368/very-simple-java-solution-with-only-binary-search-algorithm
 */
public class Solution {
    public int[] searchRange(int[] A, int target) {
        if(A.length == 0 || A == null)
            return null;
        int[] range = {-1, -1};
        int start = firstGreaterEqual(A, target);
        if(start == A.length || A[start] != target)
            return range;

        //found target
        int end = firstGreaterEqual(A, target + 1) - 1;
        range[0] = start;
        range[1] = end;
        return range;
    }

    public int firstGreaterEqual(int[] A, int target){
        int left = 0, right = A.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(A[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}