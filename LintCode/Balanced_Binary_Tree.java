public class Solution {
    public boolean isBalanced(TreeNode root) {
        //2015-06-02 20:26:42 - 2015-06-02 20:32:29 (6 min)
        if(root == null)
            return true;
        
        int left = maxHeight(root.left);
        int right = maxHeight(root.right);
        if( Math.abs(left - right) >= 2 )
            return false;
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int maxHeight(TreeNode root){
        if(root == null)
            return 0;
            
        int left = 1 + maxHeight(root.left);
        int right = 1 + maxHeight(root.right);
        
        return Math.max(left, right);
    }
}

