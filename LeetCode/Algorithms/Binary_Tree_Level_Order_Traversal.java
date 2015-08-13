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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        //2015-05-19 17:51:48 - 2015-05-19 18:00:31 (9 min)
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while(! q.isEmpty()){
            ArrayList<Integer> list = new ArrayList<Integer>();
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                list.add(temp.val);
                if(temp.left != null)
                    q.offer(temp.left);
                if(temp.right != null)
                    q.offer(temp.right);
            }
            
            res.add(new ArrayList<Integer>(list));
        }
        return res;
    }
}










/**
 * O(n)
 * O(# of nodes in the level which has the most nodes) 
 *          => O(n / 2 - 1) if the tree is complete tree, the level which has the most nodes is the deepest level.
 * 
 * Note:
 *      Easy one.
 *      proficient in the LinkedList API.
 * 289 ms
 * 
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {//4/28 21:45 - 21:53 (8 min)
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while(! q.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                TreeNode head = q.poll();
                level.add(head.val);
                if(head.left != null)
                    q.offer(head.left);
                if(head.right != null)
                    q.offer(head.right);
            }
            res.add(level);
        }
        return res; 
    }
}