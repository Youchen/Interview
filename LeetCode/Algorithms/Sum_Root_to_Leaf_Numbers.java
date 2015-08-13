/**
 * Round 2
 * Nice done!
 *
 * Review the iterative way.
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
    public int sumNumbers(TreeNode root) {
        //2015-08-02 12:49:29 pause 2015-08-02 12:55:01
        //2015-08-02 13:03:01 - 2015-08-02 13:04:33 (7 min)
        if(root == null)
            return 0;
        
        int[] sum = new int[1];
        sum[0] = 0;
        
        add(root, sum, 0);
        return sum[0];
        
    }
    private void add(TreeNode root, int[] sum, int num){
        if(root == null)
            return;
        
        num = num * 10 + root.val;
        
        if(root.left == null && root.right == null)
            sum[0] += num;
           
        add(root.left, sum, num);
        add(root.right, sum, num);
        
        num = num / 10;
    }
}






/**
 * Did not get right.
 * DO THIS AGAIN!
 * 
 * Iterative way.
 * By using double stack.
 * The other stack is to store the curSum.
 * 
 * Nice algorithm.
 * Reference:
 *      https://chazyhabit.wordpress.com/2014/08/08/sum-root-to-leaf-numbers-leetcode-41/
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<Integer> preSum = new Stack<Integer>();
        
        TreeNode p = root;
        int sum = 0, cur = 0;
        
        while(p != null || ! s.isEmpty()){
            if(p != null){
                s.push(p);
                cur = cur * 10 + p.val;
                preSum.push(cur);
                
                p = p.left;
            } else{
                p = s.pop();
                cur = preSum.pop();
                
                if( p.left == null && p.right == null){
                    sum += cur;
                }
                
                p = p.right;
            }
        }
        return sum;
    }
}









/**
 * Did not get right.
 * DO THIS AGAIN!
 * 
 */
public class Solution {
    //RECURSIVE.
     public int sumNumbers(TreeNode root) {
         //2015-05-20 12:32:02 pause 2015-05-20 12:56:28
         //resume 2015-05-20 13:27:15 - 2015-05-20 13:31:24 (28 min w/ seeing the solution)
         if(root == null)
             return 0;
      
         return sumNumbers(root, 0);
     }
     public int sumNumbers(TreeNode root, int path){
         if(root == null)
             return 0;
      
         path = path * 10 + root.val;
      
         if(root.left == null && root.right == null)
             return path;
          
         return sumNumbers(root.left, path) + sumNumbers(root.right, path);
      
     }
}