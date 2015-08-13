/**
 * Round 2
 * 
 * This is actually an another form of recursive pre-order traversal.
 * The difficult part is marked below.
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
    public void flatten(TreeNode root) {
        //2015-08-01 22:50:58 - 2015-08-01 22:53:25 (3 min)
        if(root == null)
            return;
        
        TreeNode L = root.left;
        TreeNode R = root.right;
        
        root.left = null;
        
        flatten(L);
        flatten(R);
        
        root.right = L;
        
        /**
         * for the idea of line below
         * consider the case:
         *       1
         *      /\
         *     2  5
         * 
         * you need to flatten it as 1 - 2 - 5
         */
        TreeNode cur = root;
        while(cur.right != null) cur = cur.right;
        cur.right = R;
    }
}





/**
 * Did not get right.
 * DO THIS AGAIN.
 * 
 * Reference:
 *      https://leetcode.com/discuss/27643/straightforward-java-solution
 * 
 */
public class Solution {
    public void flatten(TreeNode root) {
        //2015-05-20 18:47:16 pause 2015-05-20 18:51:40 resume 2015-05-20 18:54:37
        //2015-05-20 19:01:47 (11 min)
        if(root == null)
            return;
            
        TreeNode L = root.left;
        TreeNode R = root.right;
        
        root.left = null;
        
        flatten(L);
        flatten(R);
        
        root.right = L;
        TreeNode cur = root;
        while(cur.right != null) cur = cur.right;
        cur.right = R;
    }
}