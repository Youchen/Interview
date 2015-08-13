public class Solution {
    private Stack<TreeNode> stack;
    private TreeNode p;
    //@param root: The root of binary tree.
    public Solution(TreeNode root) {
        //2015-06-02 20:42:49 - 2015-06-02 20:54:58 (12 min)
        stack = new Stack<TreeNode>();
        p = root;
        
        while(p != null){
            stack.push(p);
            p = p.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return (p != null || ! stack.isEmpty());
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        TreeNode pNext = stack.pop();
        p = pNext.right;
        
        while( p != null ){
            stack.push(p);
            p = p.left;
        }
        
        return pNext;
    }
}