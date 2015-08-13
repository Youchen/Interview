class Solution {
    public int sqrt(int x) {
        if(x < 0)
            return -1;
        if(x <= 1)
            return x;

        int left = 0, right = x;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(x / mid == mid)
                return mid;
            if(x / mid > mid)//mid * mid <= x
                left = mid;
            else
                right = mid;
        }
        return left;
    }
}






/**
 * O(log n)
 * 238 ms
 * 
 * BinarySearch
 */
public class Solution {
    public int sqrt(int x) {
        /**
         * Binary Search
         */
        if(x == 0) return x;
        int left = 1, right = x, mid, ans = 1;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(mid <= x / mid){//(mid * mid <= x){
                left = mid + 1;
                ans = mid;
            }
            else
                right = mid - 1;
        }//while
        return ans;
    }
}