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
    public int kthSmallest(TreeNode root, int k) {
        //2015-07-31 16:44:43 - 2015-07-31 16:48:18 (4 min)
        if(root == null)
            return -1;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        
        while(p != null || ! s.isEmpty()){
            if(p != null){
                s.push(p);
                p = p.left;
            }else{
                p = s.pop();
                k--;
                if(k == 0)
                    return p.val;
                
                p = p.right;
            }
        }
        return -1;
    }
}





/**
 * O(n) where n is the total nodes in the tree.
 * O(n) by using stack.
 * 
 * Follow-up:
 *      http://solvedstack.com/questions/find-kth-smallest-element-in-a-binary-search-tree-in-optimum-way
 * 
 *      Here's just an outline of the idea:
 * 
 *      Let each node in the BST have a field that returns the number of elements in its left and right subtree. 
 *          Let the left subtree of node T contain only elements smaller than T (and also node T itself for
 *          the below to work, but you can have variations of this) and the right subtree only elements 
 *          larger than or equal to T.
 *      
 *      Now, suppose we are at node T:
 *      
 *      k == num_elements(left subtree of T), then the answer we're looking for is the value in node T
 *      k > num_elements(left subtree of T) then obviously we can ignore the left subtree, because 
 *              those elements will also be smaller than the kth smallest. So, we reduce the problem to 
 *              finding the k - num_elements(left subtree of T) smallest element of the right subtree.
 *      k < num_elements(left subtree of T), then the kth smallest is somewhere in the left subtree, 
 *              so we reduce the problem to finding the kth smallest element in the left subtree.
 *      This is O(log N) on average (assuming a balanced tree).
 *
 * 
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
    public int kthSmallest(TreeNode root, int k) {
        //2015-07-01 21:44:56 - 2015-07-01 21:54:13 (10 min)
        if(root == null)
            return -1;
        
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode p = root;
        
        while(p != null || !stk.isEmpty()){
            if(p != null){
                stk.push(p);
                p = p.left;
            }
            else{
                p = stk.pop();
                k--;
                if(k == 0)
                    return p.val;
                p = p.right;
            }
        }
        return -1;
    }
}