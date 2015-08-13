
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        //2015-06-02 17:28:43 - 2015-06-02 17:31:50 ( 3 min )
        ArrayList<Integer> al = new ArrayList<Integer>();
        if(root == null)
            return al;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        
        while(p != null || ! s.isEmpty()){
            if(p != null){
                al.add(p.val);
                s.push(p);
                p = p.left;
            }else{
                p = s.pop();
                p = p.right;
            }
        }
        return al;
    }
}

