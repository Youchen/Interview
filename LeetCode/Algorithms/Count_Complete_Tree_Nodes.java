/**
 * Round 2
 * 
 * for a binary tree, the level which node is locate is depth 0
 * the height is Max(depth) + 1;
 * 
 * For depth and height, See:
 *      http://web.cs.wpi.edu/~cs507/f98/classes/class04/fig01.gif
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
    public int countNodes(TreeNode root){
        if(root == null)
            return 0;
        
        //2015-07-31 17:26:36 - 2015-07-31 17:36:26 (10 min)
        int leftH = getLeftMostDepth(root) + 1;
        int rightH = getRightMostDepth(root) + 1;
        
        if(leftH == rightH)
            return (2 << (leftH - 1)) - 1;
        else
            return countNodes(root.left) + countNodes(root.right) + 1;
    }
    private int getLeftMostDepth(TreeNode root){
        if(root == null)
            return 0;
            
        int h = 0;
        TreeNode p = root;
        while(p.left != null){
            p = p.left;
            h++;
        }
        return h; 
    }
    private int getRightMostDepth(TreeNode root){
        if(root == null)
            return 0;
            
        int h = 0;
        TreeNode p = root;
        while(p.right != null){
            p = p.right;
            h++;
        }
        return h;
    }
}




/**
 * the optimizing part is to check the left most path height and
 *                                  the right most path height.
 * if they are identical, just return 2^h - 1;
 * if not, recursive compute the height.
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
    public int countNodes(TreeNode root){
        //2015-06-28 23:46:23 - 2015-06-28 23:57:09 (11 min)
        if(root == null)
            return 0;
        
        int leftH = getLeftMostHeight(root) + 1;
        int rightH = getRightMostHeight(root) + 1;
        
        if(leftH == rightH)
            return (2 << (leftH - 1) ) - 1;
        else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
        
        
        // //2015-06-28 23:14:30 - 2015-06-28 23:19:14 TLE
        // if(root == null)
        //     return 0;
        
        // int left = countNodes(root.left);
        // int right = countNodes(root.right);
        // return left + right + 1;
    }
    private int getLeftMostHeight(TreeNode root){
        if(root == null)
            return 0;
            
        int h = 0;
        TreeNode p = root;
        while(p.left != null){
            p = p.left;
            h++;
        }
        return h; 
    }
    private int getRightMostHeight(TreeNode root){
        if(root == null)
            return 0;
            
        int h = 0;
        TreeNode p = root;
        while(p.right != null){
            p = p.right;
            h++;
        }
        return h;
    }
}