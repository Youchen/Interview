/**
 * O(3n) = O(n)
 * O(1)
 * 
 * Not so hard, but idea is hard to get.
 * 
 * Note:
 *      “这道题是给定一个数组和一个排列，求下一个排列。算法上其实没有什么特别的地方，
 *      主要的问题是经常不是一见到这个题就能马上理清思路。下面我们用一个例子来说明，
 *      比如排列是(2,3,6,5,4,1)，求下一个排列的基本步骤是这样：
 *          
 *      1) 先从后往前找到第一个不是依次增长的数，记录下位置p。比如例子中的3，对应的位置是1;
 *      2) 接下来分两种情况：
 *              (1) 如果上面的数字都是依次增长的，那么说明这是最后一个排列，下一个就是第一个，
 *                      其实把所有数字反转过来即可(比如(6,5,4,3,2,1)下一个是(1,2,3,4,5,6));
 *              (2) 否则，如果p存在，从p开始往后找，找找找，找到一个比他大且是
 *                      所有比他大的数之中最小的数，然后两个调换位置。
 *                  
 *                      比如例子中的4。调换位置后得到(2,4,6,5,3,1)。
 *                  最后把p之后的所有数字倒序，比如例子中得到(2,4,1,3,5,6), 这个即是要求的下一个排列。
 * 
 *      以上方法中，最坏情况需要扫描数组三次，所以时间复杂度是O(3*n)=O(n)，空间复杂度是O(1)。
 * 
 * Reference:
 *      http://www.cnblogs.com/springfor/p/3896245.html
 * 
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        //2015-06-25 16:33:56 - 2015-06-25 16:51:01 (18 min)
        if(nums == null || nums.length == 0)
            return;
        
        int len = nums.length;
        int p = -1;
        
        for(int i = len - 1; i >= 1; i--){
            if( nums[i] > nums[i - 1] ){
                p = i - 1;
                break;
            }
        }
        
        if(p == -1){
            reverse(nums, 0, len - 1);
            return;
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
        reverse(nums, p + 1, len - 1);
        
        return;
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