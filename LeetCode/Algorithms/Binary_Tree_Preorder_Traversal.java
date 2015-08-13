/**
 * Round 5
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        //2015-07-31 16:40:11 - 2015-07-31 16:42:40 (2 min)
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        
        helper(root, res);
        return res;
        
    }
    private void helper(TreeNode root, List<Integer> res){
        if(root == null)
            return;
            
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
}



/**
 * Round 4 - Remember this template.
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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        //2015-05-14 16:09:39 - 2015-05-14 16:11:24 (2 min)
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        while(p != null || ! s.isEmpty()){
            if(p != null){
                res.add(p.val);
                s.push(p);
                p = p.left;
            }else{
                p = s.pop();
                p = p.right;
            }
        }
        return res;
    }
}






/**
 * Round 4 - iterative still cannot do.
 * Remember this!
 * DO THIS AGAIN
 * 
 * Note:
 *      Thinking the tube and the dry food. you squeeze the food into the tube.
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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        //2015-05-13 22:56:40 -31 min - 2015-05-13 23:34:12 (7 min)
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(! s.isEmpty()){
            TreeNode temp = s.pop();
            res.add(temp.val);
            if(temp.right != null)
                s.push(temp.right);
            if(temp.left != null)
                s.push(temp.left);
        }
        return res;
    }
}





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
    public List<Integer> preorderTraversal(TreeNode root) {
        //2015-05-13 22:52:55 - 2015-05-13 22:55:17 (3 min)
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        preorderTraversal(root, res);
        return res;
    }
    private void preorderTraversal(TreeNode root, ArrayList<Integer> res){
        if(root == null)
            return;
        res.add(root.val);
        preorderTraversal(root.left, res);
        preorderTraversal(root.right, res);
    }
}






/**
 * Round 3 - 14 min
 * pre- and in- better use this template.
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
    public List<Integer> preorderTraversal(TreeNode root) {//4/27 17:08 - 17:20 pause 20:49 resume 20:51 finish (14 min)
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        
        while(p != null || ! s.isEmpty()){
            if(p != null){
                res.add(p.val);
                s.push(p);
                p = p.left;
            }else{
                p = s.pop();
                p = p.right;
            }
        }
        return res;
    }
}






/**
 * Round 2 - Still cannot do.
 * DO THIS AGAIN.
 * 
 * Understand the principle.
 * 
 * For recursive method:
 *      Need to have addAll
 * 
 * For iterative method
 *      use Stack
 *      use push right first then left.
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
    public List<Integer> preorderTraversal(TreeNode root) {//4/19 18:17
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        
        /**
         * Recursive Method
         * O(n)
         * O(height) 
         *      if every level above the deepest level is full, then height = O(log n)
         */
        // res.add(root.val);
        // res.addAll(preorderTraversal(root.left));
        // res.addAll(preorderTraversal(root.right));
        // return res;
        
        /**
         * Iterative Method
         * O(n)
         * O(height) 
         *      if every level above the deepest level is full, then height = O(log n)
         */
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        
        while(! s.isEmpty()){
            TreeNode p = s.pop();
            res.add(p.val);
            if(p.right != null) s.push(p.right);
            if(p.left != null) s.push(p.left);
        }
        return res;
    }
}















/**
 * O(n)
 * O(n)
 * 
 * 203 ms
 * 194 ms
 * 
 * BT
 * ArrayList, Stack
 * 
 * Note:
 *      Reconsider this problem.
 * 
 * DO THIS AGAIN
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
    public List<Integer> preorderTraversal(TreeNode root) {
    //   ArrayList<Integer> al = new ArrayList<Integer>();
    //   if(root == null) return al;
       
    //   al.add(root.val);
    //   al.addAll(preorderTraversal(root.left));
    //   al.addAll(preorderTraversal(root.right));
    //   return al;
    
        ArrayList<Integer> al = new ArrayList<Integer>();
        if(root == null) return al;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        
        while(! s.isEmpty()){
            TreeNode p = s.pop();
            al.add(p.val);
            if(p.right != null) s.push(p.right);
            if(p.left != null) s.push(p.left);
        }
        return al;
    }
}