/**
 * Round 2 - Nice done!
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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        //2015-05-19 18:19:57 - 2015-05-19 18:26:50 (7 min)
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        boolean direction = true;
        
        while(! q.isEmpty()){
            ArrayList<Integer> list = new ArrayList<Integer>();
            int size = q.size();
            
            
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                if(direction)
                    list.add(temp.val);
                else
                    list.add(0, temp.val);
                    
                if(temp.left != null)
                    q.offer(temp.left);
                if(temp.right != null)
                    q.offer(temp.right);
            }
            
            direction = ! direction;
            res.add(new ArrayList<Integer>(list));
        }
        
        return res;
    }
}









/**
 * O(n)
 * O(# of nodes in the level which has the most nodes)
 * 252 ms
 * 
 * Note:
 *      Follow the pattern of "Level order traversal I, II".
 *      pretty easy.
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {//10:27 - 10:35 (8 min)
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        //true = right, false = left;
        boolean direction = true;
        
        while(! q.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode head = q.poll();
                
                if(direction)
                    level.add(head.val);
                else
                    level.add(0, head.val);
                    
                if(head.left != null)
                    q.offer(head.left);
                if(head.right != null)
                    q.offer(head.right);
            }
            res.add(level);
            if(direction)
                direction = false;
            else
                direction = true;
        }
        return res;
    }
}