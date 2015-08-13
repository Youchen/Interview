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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        //2015-05-19 18:02:15 - 2015-05-19 18:10:24 ( 8 min)
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
            res.add(0, new ArrayList<Integer>(list));//============ use this line OR line below =============
        }
        // Collections.reverse(res);//====================== use this line OR line above =============
        return res;
    }
}





/**
 * O(n)
 * O(# of the level that has the most nodes)
 * 287 ms
 * 
 * Note:
 *      Get hint from the solution of the related problem I.
 *      Try to solve naked by hand at 2nd time.
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {//4/29 10:11 - 10:24 (13 min)
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
            
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode p = root;
        q.offer(p);
        
        while(! q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<Integer>();
            
            for(int i = 0; i < size; i++){
                TreeNode head = q.poll();
                level.add(head.val);
                if(head.left != null)
                    q.offer(head.left);
                if(head.right != null)
                    q.offer(head.right);
            }
            res.add(0, level);
        }
        return res;
    }
}



/**
 * O(n)
 * O(n)
 * 318 ms
 * 
 * Note:
 *      Using Stack and Queue at the same time.
 *      Could be simplized as related problem, just add at the beginning of the ArrayList.
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {//4/29 0:13 - 0:17 0:28 - 0:41 1:01 - 1:05 1:07 - 1:18 (32 min)
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        
        
        LinkedList<TreeNode> level = new LinkedList<TreeNode>();
        Stack<LinkedList<TreeNode>> s = new Stack<LinkedList<TreeNode>>();
        TreeNode p = root;
        
        level.offer(p);
        s.push(level);
        
        //push
        while(true){
            int size = level.size();
            if(size == 0) break;
            
            level = new LinkedList<TreeNode>();
            
            for(int i = 0; i < size; i++){
                p = s.peek().get(i);
                if(p.left != null)
                    level.offer(p.left);
                if(p.right != null)
                    level.offer(p.right);
            }
            if(level.size() != 0)
                s.push(level);
        }
        
        //pop
        while(! s.isEmpty()){
            LinkedList<TreeNode> q = s.pop();
            int size = q.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                tmp.add(q.poll().val);
            }
            res.add(tmp);
        }
        return res;
    }
}