/**
 * Round 3
 * 
 * Not proficient.
 * DO THIS AGAIN.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        //2015-07-31 22:14:51 - 2015-07-31 22:26:19 (12 min)
        if(head == null)
            return null;
        
        int count = 1;
        ListNode c = head;
        while(c.next != null){
            c = c.next;
            count++;
        }
        
        ArrayList<ListNode> al = new ArrayList<ListNode>();
        al.add(head);
        
        return convert(al, 0, count - 1);
    }
    private TreeNode convert(ArrayList<ListNode> al, int start, int end){
        if(start > end)
            return null;
        
        int mid = start + (end - start) / 2;
        TreeNode left = convert(al, start, mid - 1);
        
        TreeNode root = new TreeNode(al.get(0).val);
        root.left = left;
        al.set(0, al.get(0).next);
        
        root.right = convert(al, mid + 1, end);
        
        return root;
    }
}





/**
 * Round 2
 * 
 * DO THIS AGAIN.
 * 
 * Note:
 *      Still cannot do.
 *      The idea is in-order traversal.
 */ 
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {  
        //2015-06-11 21:45:33 - 2015-06-11 22:02:38
        if( head == null )
            return null;
        
        int len = getLen(head);
        
        ArrayList<ListNode> al = new ArrayList<ListNode>();
        al.add(head);
        
        return sortedListToBST_helper(al, 0, len - 1);//indexical start/end.
    }
    private int getLen(ListNode head){
        if(head == null)
            return 0;
        
        int count = 1;
        ListNode iter = head;
        while(iter != null){
            iter = iter.next;
            count++;
        }
        return count - 1;
    }
    private TreeNode sortedListToBST_helper( 
                                ArrayList<ListNode> al, int start, int end){
        if(start > end)
            return null;
        
        int mid = start + (end - start ) / 2;
        TreeNode left = sortedListToBST_helper( al, start, mid - 1);
        
        TreeNode root = new TreeNode(al.get(0).val);
        root.left = left;
        
        al.set(0, al.get(0).next);
        
        root.right = sortedListToBST_helper(al, mid + 1, end);
        
        return root;
    }
}












/**
 * Nice done.
 * Feels like I am guessing right.
 * DO THIS AGAIN!
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        //2015-05-21 12:57:47 - 2015-05-21 13:06:30 (9 min)
        if(head == null)
            return null;
        
        /**
         * Count the ListNode.
         */
        int count = 0;
        ListNode p = head;
        while(p != null){
            p = p.next;
            count++;
        }
        
        ArrayList<ListNode> al = new ArrayList<ListNode>();
        al.add(head);
        
        return buildTree(al, 0, count - 1);
    }
    
    private TreeNode buildTree(ArrayList<ListNode> al, int start, int end){
        if(start > end)
            return null;
        
        int mid = start + (end - start) / 2;
        TreeNode left = buildTree(al, start, mid - 1);
        
        TreeNode root = new TreeNode(al.get(0).val);
        root.left = left;
        
        al.set(0, al.get(0).next);
        
        root.right = buildTree(al, mid + 1, end);
        
        return root;
        
    }
}





/**
 * O(n)
 * O(log n)
 * 
 * So hard.
 * DO THIS AGAIN.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        //2015-05-20 20:38:35 - 2015-05-20 21:09:51
        if(head == null)
            return null;
        
        ListNode cur = head;
        int count = 0;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        ArrayList<ListNode> al = new ArrayList<ListNode>();
        al.add(head);
        return buildTree(al, 0, count - 1);
    }
    private TreeNode buildTree(ArrayList<ListNode> al, int start, int end){
        if(start > end)
            return null;
        
        int mid = start + (end - start) / 2;
        TreeNode left = buildTree(al, start, mid - 1);
        
        TreeNode root = new TreeNode(al.get(0).val);
        root.left = left;
        
        al.set(0, al.get(0).next);
        root.right = buildTree(al, mid + 1, end);
        
        
        return root;
    }
}