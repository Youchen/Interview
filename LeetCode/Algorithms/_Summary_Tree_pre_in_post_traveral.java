/**
 * @author: Youchen
 * BT:  (pre- in- post-) order summary.
 * update 2015-05-14 00:25:33
 */

//Recursive
public class Solution {
    public List<Integer> DFSTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        preorderTraversal(root, res);
        return res;
    }
    private void DFSTraversal(TreeNode root, ArrayList<Integer> res){
        if(root == null)
            return;
        // res.add(root.val);//<=================pre
        preorderTraversal(root.left, res);
        // res.add(root.val);//<=================in
        preorderTraversal(root.right, res);
        // res.add(root.val);//<=================post
    }
}




/**
 * Iterative
 */
//Pre- in-
public class Solution {
    public List<Integer> DFSTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        /**
         * iterative
         * pre- & in- can use the same template
         * post-      is different.
         */
        //pre- in-
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;

        while(p != null || ! s.isEmpty()){
            if(p != null){
                // res.add(p.val); //<================ pre-
                s.push(p);
                p = p.left;
            }else{
                p = s.pop();
                // res.add(p.val); //<================ in-
                p = p.right;
            }
        }
        return res;
    }
}

//post-
public class Solution {
    public List<Integer> DFSTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        /**
         * iterative
         * pre- & in- can use the same template
         * post-      is different.
         */
        //pre- in-
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;

        while(p != null || ! s.isEmpty()){
            if(p != null){
                // res.add(p.val); //<=================== post-
                s.push(p);
                // p = p.right;//<======================= post-
            }else{
                p = s.pop();
                // p = p.left;//<======================== post-
            }
        }
        // Collections.reverse(res);//<================== post-
        return res;
    }
}




Template 1: Traverse

public class Solution {
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // do something with root
        traverse(root.left);
        // do something with root
        traverse(root.right);
        // do something with root
    }
}


Tempate 2: Divide & Conquer

public class Solution {
    public ResultType traversal(TreeNode root) {
        // null or leaf
        if (root == null) {
            // do something and return;
        }
        
        // Divide
        ResultType left = traversal(root.left);
        ResultType right = traversal(root.right);
        
        // Conquer
        ResultType result = Merge from left and right.
        return result;
    }
}



































/**
 * Below is old version
 */
public List<Integer> BTtraversal(TreeNode root){
    List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
            
    /**
     * recursive is trivial.
     */
    //pre
    res.add(root.val);
    res.addAll(preorderTraversal(root.left));
    res.addAll(preorderTraversal(root.right));
    return res;
    
    //in
    res.addAll(inorderTraversal(root.left));
    res.add(root.val);
    res.addAll(inorderTraversal(root.right));
    return res;
    
    //post
    res.addAll(postorderTraversal(root.left));
    res.addAll(postorderTraversal(root.right));
    res.add(root.val);
    return res;
    
    
    /**
     * iterative
     * pre- & in- can use the same template
     * post-      is different.
     */
    //pre- in-
     Stack<TreeNode> s = new Stack<TreeNode>();
     TreeNode p = root;

     while(p != null || ! s.isEmpty()){
        if(p != null){
            // res.add(p.val); //<================ pre-
            s.push(p);
            p = p.left;
        }else{
            p = s.pop();
            // res.add(p.val); //<================ in-
            p = p.right;
        }
     }
     return res;







     
     //pre- & post-
     Stack<TreeNode> s = new Stack<TreeNode>();
     TreeNode cur = root, pre = null;
     s.push(root);
        
     while(! s.isEmpty()){
        cur = s.peek();
        //traverse down
        if(pre == null || pre.left == cur || pre.right == cur){
            //res.add(cur.val); //<============if this line is here, that's pre-
            if(cur.left != null)
                s.push(cur.left);
            else if(cur.right != null)
                s.push(cur.right);
        }
        //traverse up from left
        else if(cur.left == pre){
            if(cur.right != null)
                s.push(cur.right);
        }
        //traverse up from right
        else if(cur.right == pre || pre == cur){
            //res.add(cur.val); //<============if this line is here, that's post-
            s.pop();
        }
        pre = cur;
     }
     return res;


     
}








