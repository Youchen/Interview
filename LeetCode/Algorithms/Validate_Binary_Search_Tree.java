/**
 * Round 3
 * 
 * Recursive - use in-order traversal
 * Iterative - Stack
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
    Integer lastPrint = null;
    public boolean isValidBST(TreeNode root) {
        //2015-08-03 01:11:59 - 2015-08-03 01:27:09 (16 min)
        if(root == null)
            return true;
        
        if( ! isValidBST(root.left) )
            return false;
          
        if(lastPrint != null && lastPrint >= root.val)
            return false;
        
        lastPrint = root.val;
        
        if(! isValidBST(root.right))
            return false;
            
        return true;
    }
}







/**
 * Round 2 - did not get right at 1st time
 * DO THIS AGAIN!
 * 
 * Note:
 *      Very nice problem.
 *      It's the same principle with BT in-order traversal.
 *      Just have an additional lastPrint.
 */

/**
 * Recursive
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
    Integer lastPrint = null;
    public boolean isValidBST(TreeNode root) {
        //2015-05-19 18:28:33 - 2015-05-19 18:43:49 (11 min)
        if(root == null)
            return true;
        
        if(! isValidBST(root.left))
            return false;
        
        
        if(lastPrint != null && lastPrint >= root.val)
            return false;
        lastPrint = root.val;
        
        
        
        if(! isValidBST(root.right))
            return false;
        
        return true;
    }
}







/**
 * Recursive
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
    Integer lastPrint = null;
    public boolean isValidBST(TreeNode root) {
        //2015-05-19 18:28:33 - 2015-05-19 18:43:49 (11 min)
        if(root == null)
            return true;
        
        if(! isValidBST(root.left))
            return false;
        
        
        if(lastPrint != null && lastPrint >= root.val)
            return false;
        lastPrint = root.val;
        
        
        
        if(! isValidBST(root.right))
            return false;
        
        return true;
    }
}






/**
 * Iterative
 */
public class Solution {
    Integer lastPrint = null;
    public boolean isValidBST(TreeNode root) {
        //2015-05-19 18:28:33 - 2015-05-19 18:46:09 (18 min)
        if(root == null)
            return true;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        while(p != null || ! s.isEmpty()){
            if(p != null){
                s.push(p);
                p = p.left;
            }else{
                p = s.pop();
                
                if(lastPrint != null && lastPrint >= p.val)
                    return false;
                lastPrint = p.val;
                
                p = p.right;
            }
        }
        return true;
    }
}











/**
 * O(n)
 * O(n)
 * 285 ms
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
// public class Solution {
//     public boolean isValidBST(TreeNode root) {
//         ArrayList<Integer> al = createArr(root);
//         for(int i = 1; i < al.size(); i++)
//             if(al.get(i) <= al.get(i - 1))
//                 return false;
//         return true;
//     }
    
//     public ArrayList<Integer> createArr(TreeNode root){
//         ArrayList<Integer> al = new ArrayList<Integer>();
//         if(root == null) return al;
        
//         al.addAll(createArr(root.left));
//         al.add(root.val);
//         al.addAll(createArr(root.right));
        
//         return al;
//     }
// }
/**
 * O(n)
 * O(1)
 * 361 ms
 */
public class Solution {
    public Integer last_printed = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        
        if(! isValidBST(root.left)) return false;
        if(last_printed != null && root.val <= last_printed) return false;
        last_printed = root.val;
        
        if(! isValidBST(root.right)) return false;
        
        return true;
    }
}