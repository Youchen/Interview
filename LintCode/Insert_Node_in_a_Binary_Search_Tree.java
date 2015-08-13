/**
 * Round 2
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        //2015-08-03 01:08:02 - 2015-08-03 01:10:52 (2 min)
        if(root == null)
            return new TreeNode(node.val);
        
        TreeNode parent = null, son = root;
        while(son != null){
            parent = son;
            if(node.val > son.val)
                son = son.right;
            else
                son = son.left;
        }
        
        if(node.val < parent.val)
            parent.left = node;
        else
            parent.right = node;
        
        return root;
    }
}






/**
 * Nice done!
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        //2015-05-19 18:51:12 - 2015-05-19 18:56:49 (5 min)
        if(root == null)
            return node;
        
        TreeNode p1 = null, p2 = root;
        while(p2 != null){
            p1 = p2;
            if(node.val < p2.val)
                p2 = p2.left;
            else
                p2 = p2.right;
        }
        
        if(node.val < p1.val)
            p1.left = node;
        else
            p1.right = node;
        
        
        return root;
        
    }
}

