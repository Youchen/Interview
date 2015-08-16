/**
 * O(n) where n is the number of nodes.
 * O(height) the height of the tree.
 * 
 * Same as path sum ii, Just use recursive method.
 *      I have tried iterative method for long time, but does not work yet.
 * Remember this algorithm.
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
    public List<String> binaryTreePaths(TreeNode root) {
        //2015-08-15 20:13:10 pause 2015-08-15 20:29:56
        //2015-08-15 23:12:50 - 2015-08-16 00:00:01 (1 hour +)
        List<String> res = new ArrayList<String>();
        if(root == null)
            return res;
        
        binaryTreePaths(root, res, new ArrayList<String>());
        return res;
    }
    private void binaryTreePaths(TreeNode root, List<String> res, ArrayList<String> list){
        if(root == null)
            return;
        
        list.add(String.valueOf(root.val));
        if(root.left == null && root.right == null)
            res.add(curList(list));
        
        binaryTreePaths(root.left, res, list);
        binaryTreePaths(root.right, res, list);
        
        list.remove(list.size() - 1);
    }
    private String curList(ArrayList<String> list){
        String res = "";
        for(String s : list)
            res += s + "->";
        res = res.substring(0, res.length() - 2);
        return res;
    }
}