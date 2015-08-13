/**
 * O(n)
 * O(1)
 * 
 * This is called "polygenelubricants" (多基因润滑剂?) Algorithm.
 * 
 * Reference:
 *      http://stackoverflow.com/questions/2680548/given-an-array-of-numbers-return-array-of-products-of-all-other-numbers-no-div
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        
        res[0] = 1;
        for(int i = 1; i < len; i++)
            res[i] = res[i - 1] * nums[i - 1];
        
        int right = 1;
        for(int i = len - 1; i >= 0; i--){
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}