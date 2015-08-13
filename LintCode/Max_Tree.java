/**
 * Not yet fully understand.
 * Think this algorithm together 
 *      with problem "Largest Rectangle in Histogram"
 */
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        //2015-06-16 22:10:12 - 2015-06-16 22:19:06 (9 min)
        if(A == null || A.length == 0)
            return null;
        
        int len = A.length;
        TreeNode[] stack = new TreeNode[len];
        
        for(int i = 0; i < len; i++)
            stack[i] = new TreeNode(0);
        
        int p = 0;//stack pointer.
           
        for(int i = 0; i < len; i++){
            TreeNode cur = new TreeNode(A[i]);
            
            while(p >= 1 && A[i] > stack[p - 1].val){
                cur.left = stack[p - 1];
                p--;
            }
            
            if(p >= 1)
                stack[p - 1].right = cur;
            
            stack[ p++ ] = cur;
        }
        return stack[0];
    }
}
