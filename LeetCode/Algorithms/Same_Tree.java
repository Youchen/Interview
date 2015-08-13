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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //2015-08-02 14:46:09 - 2015-08-02 14:47:09 (1 min)
        if(p == null && q == null)
            return true;
        
        if(p == null || q == null)
            return false;
        
        if(p.val != q.val)
            return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
    }
}





/**
 * Round 2
 * Recursive
 * DO THIS AGAIN!
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //2015-05-20 00:33:20 - 2015-05-20 00:34:55 (1 min)
        if(p == null && q == null)
            return true;
        if( (p == null && q != null) || (p != null && q == null) || p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}




/**
 * Round 2
 * Iterative
 * DO THIS AGAIN
 * Same principle with in-order traversal.
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //Iterative - 2015-05-20 00:23:09 - 2015-05-20 00:30:33 (7 min)
        if(p == null && q == null)
            return true;
        
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        
        TreeNode p1 = p, p2 = q;
        while(
            (p1 != null || ! s1.isEmpty()) ||
            (p2 != null || ! s2.isEmpty())
        ){
                if(p1 != null && p2 != null){
                    s1.push(p1);
                    s2.push(p2);
                    p1 = p1.left;
                    p2 = p2.left;
                }else if(p1 == null && p2 == null){
                    p1 = s1.pop();
                    p2 = s2.pop();
                    
                    if(
                        (p1 == null && p2 != null) ||
                        (p1 != null && p2 == null) ||
                        (p1.val != p2.val)
                    )
                        return false;
                    
                    p1 = p1.right;
                    p2 = p2.right;
                }
                else
                    return false;
        }
        
        return true;
            
    }
}




/**
 * O(n)
 * 197 ms
 * (204 ms for better code)
 * 
 * Binary Tree
 * Recursion
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null )
            return true;
        if( (p == null && q != null) || (p != null && q == null) )
            return false;
        if(p.val != q.val) return false;
        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
        /**
         * Better Code
         * https://oj.leetcode.com/discuss/3470/seeking-for-better-solution
         */
        // if(p == null || q == null)
        //     return p == q;
        // else
        //     return (p.val == q.val) && (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}