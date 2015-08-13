/**
 * Round 2
 * 
 * O(n)
 * O(log n) = height of the tree.
 * 
 * Only needs to review the marked line, why it's wrong.
 *      For the reason, you could think about the case as following:
 *          what if these two nodes are adjacent to each other for in-order traversal?
*/
public class Solution {
    public void recoverTree(TreeNode root) {
        //2015-05-21 14:14:01 - 2015-05-21 15:15:06 (1 h)
        if(root == null || (root.left == null && root.right == null) )
            return;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        
        // int lastValue = Integer.MIN_VALUE;
        TreeNode Node1 = null, Node2 = null, pre = null;
        
        while(p != null || ! s.isEmpty()){
            if(p != null){
                s.push(p);
                p = p.left;
            }else{
                p = s.pop();
                
                
                //2015-08-01 17:31:02 - 2015-08-01 17:36:36 ( 5 min )
                if(pre != null && pre.val > p.val){
                    if(Node1 == null)
                        Node1 = pre;
                    // else
                    //     Node2 = pre; // ============ marked line =========
                    Node2 = p;
                }
                pre = p;
                
                
                
                p = p.right;
            }
        }
        //Mistake is exist for sure so swap Node1 Node2
        int temp = Node1.val;
        Node1.val = Node2.val;
        Node2.val = temp;
       
        return;
    }
}






/**
 * O(n)
 * O(log n)
 * DO THIS AGAIN!
*/
public class Solution {
    public void recoverTree(TreeNode root) {
        //2015-05-21 14:14:01 - 2015-05-21 15:15:06 (1 h)
        if(root == null || (root.left == null && root.right == null) )
            return;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        
        int lastValue = Integer.MIN_VALUE;
        TreeNode Node1 = null, Node2 = null, pre = null;
        
        while(p != null || ! s.isEmpty()){
            if(p != null){
                s.push(p);
                p = p.left;
            }else{
                p = s.pop();
                
                
                if(pre != null && pre.val > p.val){
                    if(Node1 == null)
                        Node1 = pre;
                    Node2 = p;
                }
                pre = p;
                
                
                
                p = p.right;
            }
        }
        //Mistake is exist for sure so swap Node1 Node2
        int temp = Node1.val;
        Node1.val = Node2.val;
        Node2.val = temp;
       
        return;
    }
}