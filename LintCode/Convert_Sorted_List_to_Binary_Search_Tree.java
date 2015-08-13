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

