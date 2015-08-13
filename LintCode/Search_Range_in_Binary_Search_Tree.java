/**
 * Nice done!
 * Same principle with in-order traversal
 */



/**
 * Iterative
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        //2015-05-19 19:03:39 - 2015-05-19 19:05:51 (2 min)
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        
        while(p != null || ! s.isEmpty()){
            if(p != null){
                s.push(p);
                p = p.left;
            }else{
                p = s.pop();
                if(k1 <= p.val && p.val <= k2)
                    res.add(p.val);
                p = p.right;
            }
        }
        return res;
    }
    
}






/**
 * Recursive
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        //2015-05-19 18:59:40 - 2015-05-19 19:02:37 (3 min)
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        
        traverse(root, k1, k2, res);
        return res;
        
    }
    private void traverse(TreeNode root, int k1, int k2, ArrayList<Integer> res){
        
        if(root == null)
            return;
        
        traverse(root.left, k1, k2, res);
        
        if(k1 <= root.val && root.val <= k2)
            res.add(root.val);
        
        traverse(root.right, k1, k2, res);
    }
}

