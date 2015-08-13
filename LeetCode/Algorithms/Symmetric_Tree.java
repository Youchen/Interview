/**
 * Round 2
 *
 * nice done!
 * Review the iterative approch.
 *      iterative algorithm is hard to make it right.
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
    public boolean isSymmetric(TreeNode root) {
        //2015-08-02 14:51:31 - 2015-08-02 14:53:09 (2 min)
        return root == null || isS(root.left, root.right);
    }
    private boolean isS(TreeNode left, TreeNode right){
        if(left == null || right == null)
            return left == null && right == null;
        
        if(left.val != right.val)
            return false;
        
        return isS(left.left, right.right) && isS(left.right, right.left);
    }
}




/**
 * Hard to get right.
 * DO THIS AGAIN!
 * Same principle with in-order traversal iterative approch.
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
    public boolean isSymmetric(TreeNode root) {
        //2015-05-19 23:48:07 - 2015-05-20 00:14:53 (26 min)
        if(root == null)
            return true;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<TreeNode> v = new Stack<TreeNode>();
        TreeNode p = root.left, q = root.right;
        
        while(
            (p != null || ! s.isEmpty())
            || (q != null || ! v.isEmpty())
            ){
            if(p != null && q != null){
                s.push(p);
                v.push(q);
                
                p = p.left; // caution !
                q = q.right;// caution !
                
            }else if(p == null && q == null){
                p = s.pop();
                q = v.pop();
                    
                if(
                    (p != null && q == null) ||
                    (p == null && q != null) ||
                    q.val != p.val
                )
                return false;
                
                p = p.right;// caution !
                q = q.left;// caution !
            }
            else
                return false;// caution !
        }
        return true;
    }
}






/**
 * NOT VERY WELL.
 * DO THIS AGAIN!
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        //2015-05-19 20:47:29 pause 2015-05-19 20:59:05
        //resume 2015-05-19 23:37:46 - 2015-05-19 23:44:12 ( 19 min )
        if(root == null)
            return true;
        
        TreeNode left = root.left, right = root.right;
        
        return traverse(left, right);
    }
    private boolean traverse(TreeNode left, TreeNode right){
        
        if(left == null && right == null)
            return true;
        if((left == null && right != null) || 
            (left != null && right == null) || 
            left.val != right.val
            )
            return false;
        
        /**
         * Here is so important!
         * 
         * === left.left ==== COMPARE TO === right.right ==== 
         *      (NOT right.left) SINCE IT'S SYMMETRIC
         */
        boolean resL = traverse(left.left, right.right);
        boolean resR = traverse(left.right, right.left);
        
        return resL && resR;
        
        // return true;
    }
}