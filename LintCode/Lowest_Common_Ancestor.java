/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        //2015-05-19 17:37:20 - 2015-05-19 17:40:38 (TLE) (3 min)
        // - 2015-05-19 17:44:21 (w/ seeing the solution) (7 min)
        if(root == null)
            return null;
        if(A == root)
            return A;
        if(B == root)
            return B;
            
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        if(left != null && right != null)
            return root;
        
        if(left == null)
            return right;
        
        if(right == null)
            return left;
        
        return null;
    }
}

