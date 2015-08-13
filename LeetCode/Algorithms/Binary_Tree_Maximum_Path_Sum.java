/**
 * Round 3
 * 
 * Review for the idea of
 * 
 *      max(
 *          root.val
 *          root.val + left
 *          root.val + right
 *          root.val + left + right
 *          max[0]
 *      )
 * 
 *  Caution the marked line below.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
        //2015-08-03 01:41:43 - 2015-08-03 01:46:42 (5 min )
        if(root == null)
            return 0;
            
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
    
        maxPathSum(root, max);
        return max[0];
    }
    private int maxPathSum(TreeNode root, int[] max){
        if(root == null)
            return 0;
            
        int left = maxPathSum(root.left, max);
        int right = maxPathSum(root.right, max);
        
        //the var "rootLR" below means The max value is root OR root + Left OR root + Right ?
        int rootLR = Math.max(root.val, Math.max(root.val + left, root.val + right));
        max[0] = Math.max(max[0], Math.max(rootLR, root.val + left + right));
        
        return rootLR;// ========= here you need to return rootLR rather than max[0] !
    }
}







/**
 * Round 2 - still cannot get right without seeing the solution.
 * DO THIS AGAIN
 * 
 * Note:
 *      Idea is:
 *      max(
 *          root.val
 *          root.val + left
 *          root.val + right
 *          root.val + left + right
 *          max[0]
 *      )
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
        //2015-05-19 17:28:07 - 2015-05-19 17:31:43 (3 min)
        if(root == null)
            return 0;
        
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        findMax(root, max);
        return max[0];
    }
    private int findMax(TreeNode root, int[] max){
        if(root == null)
            return 0;
        
        int left = findMax(root.left, max);
        int right = findMax(root.right, max);
        
        int singleMax = Math.max(root.val, Math.max(root.val + left, root.val + right));
        max[0] = Math.max(max[0], Math.max(singleMax, root.val + left + right));
        
        return singleMax;
    }
}










/**
 * O(n)
 * O(height)
 * 376 ms
 * 
 * Note:
 *      Hard one.
 *      But the reference solution is nice.
 * 
 * Reference:
 *      http://www.cnblogs.com/springfor/p/3886411.html
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxPathSum(TreeNode root) {//4/20 15:52 - 17:01 (1 h 9 min)
        // if(root == null)
        //     return 0;
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        
        findMax(root, max);
        return max[0];
    }
    private int findMax(TreeNode root, int[] max){
        if(root == null)
            return 0;
        
        int left = findMax(root.left, max);
        int right = findMax(root.right, max);
        
        int curMax = Math.max(root.val, Math.max(left + root.val, right + root.val));
        max[0] = Math.max(max[0], Math.max(curMax, root.val + left + right));
        
        return curMax;
    }
}