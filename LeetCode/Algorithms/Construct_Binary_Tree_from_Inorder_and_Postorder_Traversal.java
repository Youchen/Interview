/**
 * O(n)
 * O(n)
 * 
 * Same principle with
 *      Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //2015-05-21 13:51:18 - 2015-05-21 14:01:51 (10 min)
        if(inorder == null || postorder == null)
            return null;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1,
                       postorder, 0, postorder.length - 1, map);
    }
    private TreeNode buildTree(int[] inorder, int iL, int iR,
                             int[] postorder, int pL, int pR, HashMap<Integer, Integer> map){
        if(iL > iR || pL > pR)
            return null;
            
        TreeNode root = new TreeNode(postorder[pR]);
        int index = map.get(root.val);
        root.left = buildTree(inorder, iL, index - 1, postorder, pL, pL + index - iL - 1, map);
        root.right = buildTree(inorder, index + 1, iR, postorder, pL + index - iL, pR - 1, map);
        
        return root;
    }
}