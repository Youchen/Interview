/**
 * Round 3
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        
        if(root.left == null && root.right == null && sum == root.val)
            return true;
        
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}



/**
 * Round 2
 * DO THIS AGAIN!
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        //2015-05-20 00:38:23 - 2015-05-20 00:49:55 (11 min)
        if(root == null)
            return false;
        
        if(root.left == null && root.right == null && root.val == sum)
            return true;
        
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}





/**
 * 2/20
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null && root.val == sum)
            return true;
        return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val) );
    }
}