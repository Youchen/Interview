/**
 * Round 2
 * 
 * Key point is to know
 *      we could get root from preorder, then according to this root, 
 *      we could find the left and right subtree from inorder.
 * 
 * Reference:
 *      http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 * 
 * Let us consider the below traversals:
 * 
 * Inorder sequence: D B E A F C
 * Preorder sequence: A B D E C F
 * 
 * In a Preorder sequence, leftmost element is the root of the tree. So we know ‘A’ is root for given sequences. By searching ‘A’ in Inorder sequence, we can find out all elements on left side of ‘A’ are in left subtree and elements on right are in right subtree. So we know below structure now.
 * 
 *                  A
 *                /   \
 *              /       \
 *            D B E     F C
 * We recursively follow above steps and get the following tree.
 * 
 *          A
 *        /   \
 *      /       \
 *     B         C
 *    / \        /
 *  /     \    /
 * D       E  F
 * Algorithm: buildTree()
 * 1) Pick an element from Preorder. Increment a Preorder Index Variable (preIndex in below code) to pick next element in next recursive call.
 * 2) Create a new tree node tNode with the data as picked element.
 * 3) Find the picked element’s index in Inorder. Let the index be inIndex.
 * 4) Call buildTree for elements before inIndex and make the built tree as left subtree of tNode.
 * 5) Call buildTree for elements after inIndex and make the built tree as right subtree of tNode.
 * 6) return tNode.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //2015-08-01 21:13:25 - 2015-08-01 21:31:03 (18 min)
        if(preorder == null || inorder == null)
            return null;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = inorder.length;
        
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return buildTree(preorder, 0, len - 1, inorder, 0, len - 1, map);
    }
    private TreeNode buildTree(int[] preorder, int pS, int pE, 
                                int[] inorder, int iS, int iE, 
                                HashMap<Integer, Integer> map){
        if(pS > pE || iS > iE)
            return null;
        
        TreeNode root = new TreeNode(preorder[pS]);
        int index = map.get(preorder[pS]);
        
        root.left = buildTree(preorder, pS + 1, pS + (index - iS), inorder, iS, index - 1, map);
        root.right = buildTree(preorder, pS + (index - iS) + 1, pE, inorder, index + 1, iE, map);
        
        return root;
    }
}










/**
 * Very nice problem.
 * DO THIS AGAIN.
 * 
 * I did this by retrieve the solution from memory.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //2015-05-21 13:33:15
        if(preorder == null || inorder == null)
            return null;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return buildTree(preorder, 0, preorder.length - 1,
                          inorder, 0,  inorder.length - 1, map);
    }
    private TreeNode buildTree(int[] preorder, int pL, int pR, 
                               int[]  inorder, int iL, int iR, HashMap<Integer, Integer> map){
        if(pL > pR || iL > iR)
            return null;
        
        TreeNode root = new TreeNode(preorder[pL]);
        int index = map.get(root.val);
        
        root.left = buildTree(preorder, pL + 1, pL + index - iL, inorder, iL, index - 1, map);
        root.right = buildTree(preorder, pL + index - iL + 1, pR, inorder, index + 1, iR, map);
        
        return root;
    }
}