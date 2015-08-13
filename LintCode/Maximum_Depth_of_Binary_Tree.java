public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        //2015-06-02 17:25:45 - 2015-06-02 17:26:53 (1 min)
        if( root == null )
            return 0;
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

