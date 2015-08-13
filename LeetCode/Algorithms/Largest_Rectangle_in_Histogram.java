/**
 * O(n)
 * O(n)
 * DO THIS AGAIN! The algorithm with O(n) time complexity.
 * 
 * Time Complexity Analysis:
 *      We consider the average complexity which is
 *          every element goes into the stack once and
 *                        get out the stack once.
 *      So, the total times is twice. that's O(2) => O(1)
 *      we have N elements, so that's O(n)
 * 
 * The algorithm idea is:
 *      The stack storing a increasing sequence by their INDEX.
 * 
 *      we iterating the array, and when the array elements not increasing, 
 *          meaning the current elements <= the prior one, we pop all the prior
 *          elements and push the current one.
 * 
 *      Example: Run this in your brain.
 * 
 *                      9 
 *                  8   __
 *              7   __  ||
 *              __  ||  ||
 *              ||  ||  ||      3
 *              ||  ||  ||  2   __
 *              ||  ||  ||  __  ||
 *              ||  ||  ||  ||  ||
 *              ||  ||  ||  ||  ||
 *          ---------------------------
 *              0   1   2   3   4   5
 *
 */
public class Solution {
    public int largestRectangleArea(int[] height) {
        //2015-06-16 15:35:15 - 2015-06-16 15:39:34 (4 min)
        if(height == null || height.length == 0)
            return 0;
        
        Stack<Integer> s = new Stack<Integer>();
        int max = 0;
        
        for(int i = 0; i <= height.length; i++){
            int current = (i == height.length) ? -1 : height[i];
            
            while( !s.isEmpty() && current <= height[s.peek()] ){
                int h = height[s.pop()];
                int w = ( s.isEmpty() )? i : i - s.peek() - 1;
                max = Math.max(max, h * w);
            }
            s.push(i);
        }
        return max;
    }
}







/**
 * O(n ^ 2)
 * O(1)
 */
public class Solution {
    public int largestRectangleArea(int[] height) {
        //2015-06-16 08:56:01 - 2015-06-16 09:03:34 (7 min)
        if(height == null || height.length == 0)
            return 0;
        
        int max = 0;
        for(int i = 0; i < height.length; i++){
            //find left boundary
            int left = i;
            while(left >= 0 && height[left] >= height[i])
                left--;
            left++;
            
            //find right boundary
            int right = i;
            while(right <= height.length - 1 && height[right] >= height[i])
                right++;
        
            max = Math.max(max, (right - left) * height[i] );
        }
        return max;
    }
}
