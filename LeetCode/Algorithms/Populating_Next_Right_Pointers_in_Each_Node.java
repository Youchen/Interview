/**
 * Round 2
 * O(1)
 * O(n)
 * 
 * Round 2 - Recursive
 * DO THIS AGAIN!
 * 
 * Reference:
 *      https://leetcode.com/discuss/19061/java-solution-with-o-1-memory-o-n-time
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
        TreeLinkNode levelStart = root;

        while(levelStart != null){
            TreeLinkNode cur = levelStart;
            
            while(cur != null){
                if(cur.left != null)
                    cur.left.next = cur.right;
                if(cur.right != null && cur.next != null)
                    cur.right.next = cur.next.left;
                    
                cur = cur.next;
            }
            levelStart = levelStart.left;
        }
    }
}






/**
 * Round 2
 * O(n / 2)
 * O(n)
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        //2015-05-20 00:55:35 - 2015-05-20 01:01:46 (6 min)
        if(root == null)
            return;
        
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.offer(root);
        
        while(! q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeLinkNode temp = q.poll();
                
                if(i == size - 1)
                    temp.next = null;
                else
                    temp.next = q.element();
                    
                if(temp.left != null)
                    q.offer(temp.left);
                if(temp.right != null)
                    q.offer(temp.right);
            }
        }
        return;
    }
}





/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
/**
 * O(n)
 * O(1) - constant extra space
 * 233 ms
 * 
 * Note:
 *      for the do-while part, just write the task (the thing after "//") first
 *          then add the details.
 *      Be careful regarding the null case, you cannot say cur.left if cur is null.
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        
        TreeLinkNode nextLevelLeft = root.left;
        TreeLinkNode cur = root;
        
        while(cur != null){
	        do{
        		//connect left and right
        		if(nextLevelLeft != null)
        			cur.left.next = cur.right;
        
        		//connect 5 to 6
        		if(cur.next != null && nextLevelLeft != null)
        			cur.right.next = cur.next.left;
        
        		//cur = cur.next
        		cur = cur.next;
	        }while(cur != null);//REMEMBER: A SEMICOLON IS NEEDED HERE!!!

        	cur = nextLevelLeft;
        	if(cur != null)
        		nextLevelLeft = cur.left;
        }//while
    }
}
 
 
/**
 * O(n)
 * O(h) = O(log n)
 * 240 ms
 *
 * Note:
 *      This algorithm does not use constant extra space!
 */
// public class Solution {
//     public void connect(TreeLinkNode root) {
//         if(root == null) return;
        
//         if(root.left != null)//since this is perfect binary tree, no need to add "&& root.right != null"
//             root.left.next = root.right;
        
//         if(root.next != null && root.right != null)
//             root.right.next = root.next.left;
            
//         connect(root.left);
//         connect(root.right);
//     }
// }