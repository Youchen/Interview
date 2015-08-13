/**
 * Cost so much time
 * 
 * The key point is dp from bottom right to upper left.
 *      compute the bottom row and rightmost col first.
 * 
 * Solution copied from below
 * Reference:
 *      https://leetcode.com/discuss/20721/my-ac-java-version-suggestions-are-welcome
 */
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        //2015-07-30 10:53:50 pause 2015-07-30 11:11:16
        //2015-07-30 18:09:55 pause 2015-07-30 20:08:57
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
    
        int m = dungeon.length;
        int n = dungeon[0].length;
    
        int[][] health = new int[m][n];
    
        health[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
    
        for (int i = m - 2; i >= 0; i--) {            
            health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }
    
        for (int j = n - 2; j >= 0; j--) {
            health[m - 1][j] = Math.max(health[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }
    
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(health[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(health[i][j + 1] - dungeon[i][j], 1);
                health[i][j] = Math.min(right, down);
            }
        }
    
        return health[0][0];
    
    }
}