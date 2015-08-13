/**
 * The key point is to know how to convert.
 *      after conversion, 
 *          the new nodes left child is its parent, and 
 *                   its right child is its sibling.
 *  
 *          left child
 *              /\
 *             /  \
 *            /    \
 *        nodes   right child
 * 
 * Reference:
 *      http://www.danielbit.com/blog/puzzle/leetcode/leetcode-binary-tree-upside-down
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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        //2015-06-29 17:36:07 - 2015-06-29 17:46:12 ( 10 min )
        if(root == null || (root.left == null && root.right == null) )
            return root;
        
        
        TreeNode rootNode = root;
        TreeNode parent = null;
        TreeNode parentRight = null;
        
        while(rootNode != null){
            TreeNode next = rootNode.left;
            
            rootNode.left = parentRight;
            parentRight = rootNode.right;
            
            rootNode.right = parent;
            parent = rootNode;
            
            rootNode = next;
        }
        return parent;
    }
}