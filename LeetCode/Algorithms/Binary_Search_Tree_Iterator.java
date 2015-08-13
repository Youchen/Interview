/**
 * Round 2
 * Review the marked line.
 */
/**
 * Very nice Problem.
 * DO THIS AGAIN.
 * 
 * Same principle with in-order traversal.
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
//2015-05-19 19:36:42 - 2015-05-19 19:56:28 (20 min)
public class BSTIterator {
    
    Stack<TreeNode> s;
    TreeNode p;
    
    public BSTIterator(TreeNode root) {
        s = new Stack<TreeNode>();
        p = root;
        
        
        
        
        
        // while(p != null || !s.isEmpty()){
        //     if(p != null){
        //         s.push(p);
        //         p = p.left;
        //     }else{
        //         p = s.pop();
        //         p.val//==============
        //         p = p.right;
        //     }
        // }   
        
        
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return p != null || ! s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        while( p != null){// ============ here you need while loop =====
            s.push(p);
            p = p.left;
        }
        p = s.pop();
        int val = p.val;
        p = p.right;
        return val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */