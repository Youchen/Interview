/**
 * Round 2
 * 
 * for example
 *       4
 *     /   \
 *    2     7
 *   / \   / \
 *  1   3 6   9
 * /\   /\/\  /\
 * 84   5364  21
 * 
 * as the algorithm, the last level 84536421 will be converted as follows
 *      84 53 64 21
 *      64 21 84 53
 *      21 64 53 84
 *      12 46 35 48 - This is the invert form of original.
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
    public TreeNode invertTree(TreeNode root) {
        //2015-06-24 21:05:15 - 15min - 2015-06-24 21:33:44 (13 min)
        if(root == null || 
            (root.left == null && root.right == null)
            )
            return root;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while(! q.isEmpty() ){
            TreeNode p = q.poll();
            
            if(p.left != null)
                q.offer(p.left);
            if(p.right != null)
                q.offer(p.right);
            
            TreeNode temp = p.left;
            p.left = p.right;
            p.right = temp;
        }
        return root;
    }
}







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
    public TreeNode invertTree(TreeNode root) {
        //2015-06-24 21:05:15 - 15min - 2015-06-24 21:33:44 (13 min)
        if(root == null || 
            (root.left == null && root.right == null)
            )
            return root;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while(! q.isEmpty() ){
            TreeNode p = q.poll();
            
            if(p.left != null)
                q.offer(p.left);
            if(p.right != null)
                q.offer(p.right);
            
            TreeNode temp = p.left;
            p.left = p.right;
            p.right = temp;
        }
        return root;
    }
}