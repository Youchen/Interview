/**
 * the point is to consider if the overlapped area exist.
 * 
 * Reference:
 *      https://leetcode.com/discuss/39398/my-java-solution-sum-of-areas-overlapped-area
 */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        //2015-06-24 23:47:32 - 2015-06-25 00:02:41 (15 min)
        
        int rec1 = (C - A) * (D - B);
        int rec2 = (G - E) * (H - F);
        
        //for the overlapped area
        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);
        
        int diff = 0;
        if(left < right && top > bottom)
            diff = (right - left) * (top - bottom);
        
        return rec1 + rec2 - diff;
    }
}