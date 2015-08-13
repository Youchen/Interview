/**
 * Round 4 - Remember this template
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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        //2015-05-14 16:12:19 - 2015-05-14 16:13:52 (1 min)
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        while(p != null || ! s.isEmpty()){
            if( p != null){
                s.push(p);
                p = p.left;
            }else{
                p = s.pop();
                res.add(p.val);
                p = p.right;
            }
        }
        return res;
    }
}






/**
 * Round 4 - Nice done
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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        //2015-05-13 23:41:51 - 2015-05-13 23:43:48 (2 min)
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        inorderTraversal(root, res);
        return res;
    }
    private void inorderTraversal(TreeNode root, ArrayList<Integer> res){
        if(root == null)
            return;
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }
}





/**
 * Round 3 - 2 min
 * 
 * pre- and in- better use this template.
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
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {//21:10 - 21:12
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        
        while(p != null || ! s.isEmpty()){
            if(p != null){
                s.push(p);
                p = p.left;
            }else{
                p = s.pop();
                res.add(p.val);
                p = p.right;
            }
        }
        return res;
        
    }
}









/**
 * Round 2 - still cannot do iterative.
 * DO THIS AGAIN.
 * 
 * For recursive
 *      just like preorder, pretty simple.
 *      remember addAll
 * 
 * For iterative
 *      Hard one.
 *      remember the solution.
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
    public List<Integer> inorderTraversal(TreeNode root) {//4/19 22:15
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
            
        //recursive 22:17 (2 min)
        // res.addAll(inorderTraversal(root.left));
        // res.add(root.val);
        // res.addAll(inorderTraversal(root.right));
        
        // return res;
        
        
        //iterative 22:39 (22 min)
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        
        while(p != null || !s.isEmpty()){
            if(p != null){
                s.push(p);
                p = p.left;
            }else{
                p = s.pop();
                res.add(p.val);
                p = p.right;
            }
        }
        return res;
    }
}







/**
 * DO THIS AGAIN.
 * 
 * O(n)
 * O(n)
 * 200 ms
 * 
 * BT
 * ArrayList
 * Stack
 * 
 * Note:
 *      ReConsider this problem.
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
    public List<Integer> inorderTraversal(TreeNode root) {//2:29
        ArrayList<Integer> al = new ArrayList<Integer>();
        if(root == null) return al;
        
        // al.addAll(inorderTraversal(root.left));
        // al.add(root.val);
        // al.addAll(inorderTraversal(root.right));
        
        // return al;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        TreeNode p = root;
        
        while(! s.isEmpty() || p != null){
            if(p != null ){
                s.push(p);
                p = p.left;
            }else{
                TreeNode t = s.pop();
                al.add(t.val);
                p = t.right;
            }
        }
        return al; 
    }
}