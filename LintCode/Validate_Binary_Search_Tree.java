
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    Integer lastPrint = null;
    
    public boolean isValidBST(TreeNode root) {
        //2015-06-02 17:43:26 - 2015-06-02 19:31:04 ( 2 hours)
        if(root == null ){
            return true;
        }
        
        
        if(! isValidBST(root.left))
            return false;
        
        
        
        if( lastPrint != null && root.val <= lastPrint)
            return false;
        lastPrint = new Integer(root.val);
        
        
        
        
        if(! isValidBST(root.right))
            return false;
        
        return true;
    }
    
}

