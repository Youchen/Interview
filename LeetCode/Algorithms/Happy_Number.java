/**
 * This problem is just like 
 *      "Linked List Cycle"
 * 
 * The tricky part is the two vars x, and y.
 * Actually, it's like two pointers points to the 2 computation
 *      steps, x moves 1 step forward, while y moves 2 steps forward.
 *      if there is cycle, y can definately meet x at sometime.
 * 
 * Reference:
 *      https://leetcode.com/discuss/33349/o-1-space-java-solution
 */
public class Solution {
    public boolean isHappy(int n) {
        //2015-06-24 21:36:10 - 2015-06-24 21:54:02 (18 min )
        
        int x = n;
        int y = n;
        while(x > 1){
            x = compute(x);
            if(x == 1)
                return true;
            
            y = compute( compute(y) );
            if(y == 1)
                return true;
            
            if(x == y)
                return false;
        }
        return true;
    }
    private int compute(int x){
        int sum = 0;
        while(x > 0){
            sum += (int) Math.pow(x % 10, 2);
            x /= 10;
        }
        return sum;
    }
}