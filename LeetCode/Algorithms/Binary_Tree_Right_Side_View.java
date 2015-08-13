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
    public List<Integer> rightSideView(TreeNode root) {
        //2015-08-02 15:07:37 - 2015-08-02 15:11:54 ( 4 min )
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                TreeNode p = q.poll();
                
                if(p.left != null)
                    q.offer(p.left);
                if(p.right != null)
                    q.offer(p.right);
                    
                if(i == size - 1)
                    res.add(p.val);
            }
        }
        return res;
    }
}




/**
 * O(n) which n is the total number of nodes.
 * O(Math.cellDiv(n / 2))
 * 
 * Nice Question
 * Same principle with BT BFS.
 */
public class Solution {
    public ArrayList<Integer> rightSideView(TreeNode root) {
        //2015-05-19 20:09:35 - 2015-05-19 20:22:51 (11 min)
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
            
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while(! q.isEmpty()){
            
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                
                if(i == size - 1)
                    res.add(temp.val);
                    
                if(temp.left != null)
                    q.offer(temp.left);
                if(temp.right != null)
                    q.offer(temp.right);
            }
        }
        return res;
    }
}