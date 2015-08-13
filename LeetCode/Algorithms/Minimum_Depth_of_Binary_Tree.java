/**
 * Round 2
 * 
 * Iterative way
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
    public int minDepth(TreeNode root) {
        //2015-08-03 12:41:54 - 2015-08-03 12:45:46 (4 min)
        if(root == null)
            return 0;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int level = 1;
        
        while(! q.isEmpty()){
            int size = q.size();
            
            for(int i = 0 ; i < size; i++){
                TreeNode cur = q.poll();
                
                if(cur.left != null)
                    q.offer(cur.left);
                if(cur.right != null)
                    q.offer(cur.right);
                
                if(cur.left == null && cur.right == null)
                    return level; 
            }
            level++;
        }
        return level;
    }
}




/**
 * Round 2
 * 
 * Review
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
    public int minDepth(TreeNode root) {
        //2015-08-03 01:57:24 - 2015-08-03 02:06:43 (9 min)
        if(root == null)
            return 0;
        
        if(root.left == null || root.right == null)
            return 1 + (root.left == null ? minDepth(root.right) : minDepth(root.left));
        
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}






/**
 * O(n)
 * O(n)
 * 347 ms
 * 
 * DO THIS AGAIN.
 * 
 * Note:
 *      Thinking together with the problem of "Max depth of BT".
 *      Idea is
 *          if the node is leaf, return 0
 *          if the node has INCOMPLETE children, just traverse down, in order to reach the leaf.
 *          compare the left child min and right child min.
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {//4/20 13:10 - 15:10 (2 hours)
        if(root == null)
            return 0;
            
        if(root.left == null || root.right == null)
            return 1 + (root.left == null ? minDepth(root.right) : minDepth(root.left));
        
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}