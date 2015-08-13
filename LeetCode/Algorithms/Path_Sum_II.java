/**
 * Round 2
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        
        
        pathSum(root, sum, res, new ArrayList<Integer>() );
        return res;
    }
    
    private void pathSum(TreeNode root, int sum, List<List<Integer>> res, ArrayList<Integer> list){
        //2015-08-02 12:41:34 - 2015-08-02 12:44:36 (3 min)
        if(root == null)
            return;
        
        list.add(root.val);
        if(root.left == null && root.right == null && sum == root.val)
            res.add(new ArrayList<Integer>(list));
            
        pathSum(root.left, sum - root.val, res, list);
        pathSum(root.right, sum - root.val, res, list);
        
        list.remove(list.size() - 1);
    }
}




/**
 * Did not get it right.
 * DO THIS AGAIN.
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        //2015-05-20 18:03:26 -30 2015-05-20 18:44:43 (~ 10 min)
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return res;
        
        
        pathSum(res, root, sum, new ArrayList<Integer>() );
        return res;
    }
    
    private void pathSum(ArrayList<ArrayList<Integer>> res, TreeNode root, 
                                                    int sum, ArrayList<Integer> list){
        if(root == null)
            return;
        
        list.add(root.val);
        
        if(root.left == null && root.right == null && sum == root.val)
            res.add(new ArrayList<Integer>(list));
        
        pathSum(res, root.left, sum - root.val, list);
        pathSum(res, root.right, sum - root.val, list);
        
        list.remove(list.size() - 1);
    }
}