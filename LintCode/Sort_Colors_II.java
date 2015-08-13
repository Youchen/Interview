/**
 * O(n * (k - 1) )
 * O(1)
 * 
 * This uses the algorithm of sort colors.
 *
 * O(n) Bucket sorting
 *          http://www.cnblogs.com/yuzhangcmu/p/4177326.html
 */
class Solution {
    public void sortColors2(int[] colors, int k) {
        //2015-06-24 17:07:20 - 2015-06-24 17:22:40 (15 min)
        if(colors == null || colors.length == 0)
            return;
        
        int left = 0, mid = 0, right = colors.length - 1;
        int start = 1, end = k;
        //we need to loop (at least)  k - 1 times;
        int loop = k - 1;
        
        while(loop >= 1){
            
            while(mid <= right){
                if(colors[mid] <= start){
                    swap(colors, mid, left);
                    mid++;
                    left++;
                }
                else if(colors[mid] > start && colors[mid] < end)
                    mid++;
                else{// if(colors[mid] >= end) {
                    swap(colors, mid, right);
                    right--;
                }  
            }
            start++;
            end--;
            
            mid = 0;
            left = 0;
            right = colors.length - 1;
            
            loop--;
        }
    }
    private void swap(int[] A, int l, int r){
        if(l == r)
            return;
        int temp = A[l];
        A[l] = A[r];
        A[r] = temp;
    }
}
