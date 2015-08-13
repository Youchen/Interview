/**
 * Round 2
 * O(n)
 * O(1) space
 * 
 * idea is kind like
 * 
 *                  1
 *              /       \
 *            2(iter)    3
 *           /     \        \
 * (level)->4       5         7
 *    (cur)↗︎
 * 
 * iter is in upper level
 * level and cur is in bottom level.
 * 
 */
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        //2015-08-01 00:04:22 - 2015-08-01 00:11:06 (7 min)
        if(root == null)
            return;
        
        TreeLinkNode iter = root;
        
        while(iter != null){
            TreeLinkNode level = new TreeLinkNode(0);//0 is arbitrary value;
            TreeLinkNode cur = level;
            
            while(iter != null){
                if(iter.left != null){
                    cur.next = iter.left;
                    cur = cur.next;
                }
                if(iter.right != null){
                    cur.next = iter.right;
                    cur = cur.next;
                }
                
                iter = iter.next;
            }
            iter = level.next;
        }
    }
}






/**
 * Round 2
 * O(n)
 *
 * Nice done!
 */
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        //2015-07-31 23:01:10 - 2015-07-31 23:08:56 (7 min)
        if(root == null)
            return;
        
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.offer(root);
        
        while( !q.isEmpty()){
            int curSize = q.size();
            
            for(int i = 0; i < curSize; i++){
                TreeLinkNode p = q.poll();
                
                if(p.left != null)
                    q.offer(p.left);
                if(p.right != null)
                    q.offer(p.right);
                
                if(i < curSize - 1)    
                    p.next = q.peek();
                else
                    p.next = null;
            }
        }
        return;
    }
}






/**
 * Very nice problem.
 * Space O(1) solution
 * 
 * I did not get it without seeing the solution.
 * DO THIS AGAIN!
 * 
 * The idea is that make two dummy node, one is in front of the under-level head
 *      the other is the pointer of the last connected node in the under-level.
 * And make a pointer in the current level (the above level of the under-level)
 *      to traverse the nodes.
 * 
 * Reference:
 *      https://leetcode.com/discuss/36624/short-java-bfs-solution
 */
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
    //2015-05-21 19:39:41 - 2015-05-21 19:48:08 (11 min)
        TreeLinkNode iter = root;

        while (iter != null) {
            TreeLinkNode level = new TreeLinkNode(0);
            TreeLinkNode current = level;

            while (iter != null) {
                if (iter.left != null) {
                    current.next = iter.left;
                    current = current.next;
                }
                if (iter.right != null) {
                    current.next = iter.right;
                    current = current.next;
                }

                iter = iter.next;
            }

            iter = level.next;
        }
    }
}






/**
 * Non- constant Space solution.
 * 
 * Not so proficient for the core 4 lines.
 * DO THIS AGAIN!
 */
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        //2015-05-21 18:20:23 pause 2015-05-21 18:29:01 resume 2015-05-21 18:47:56 - 2015-05-21 19:20:09 (42 min)
        if(root == null)
            return;
        
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.offer(root);
        TreeLinkNode p1 = null, p2 = null;
        
        while(! q.isEmpty()){
            int size = q.size();
            
            
            for(int i = 0; i < size; i++){
                TreeLinkNode p = q.poll();
                
                
                /**
                 * just below 4 lines, cost so much time!!
                 */
                p2 = p;
                if(p1 != null)
                    p1.next = p2;
                p1 = p2;
                
                
                if(p.left != null)
                    q.offer(p.left);
                if(p.right != null)
                    q.offer(p.right);
            }
            // p2.next = null;
            p1 = null;
            p2 = null;
        }
        return;
    }
}