/**
 * O(n)
 * O(1)
 * Hard one!
 * DO THIS AGAIN.
 * 
 * Note:
 *      Remember the algorithm, Two pointers iterate from both sides.
 */
public class Solution {
    public int trap(int[] height) {
        //2015-05-18 21:53:52 - 2015-05-18 22:05:30 (12 min)
        if(height == null || height.length <= 2)
            return 0;
        
        int sum = 0, left = 0, right = height.length - 1;
        //find the point that could hold water.
        while(left < right && height[left] < height[left + 1])
            left++;
        while(left < right && height[right] < height[right - 1])
            right--;
        
        //left, right is the peak point.
        while(left < right){
            int Lv = height[left];
            int Rv = height[right];
            if(Lv <= Rv){
                while(left < right && Lv > height[++left])
                    sum += Lv - height[left];
            }else{
                while(left < right && Rv > height[--right])
                    sum += Rv - height[right];
            }
        }
        return sum;
    }
}