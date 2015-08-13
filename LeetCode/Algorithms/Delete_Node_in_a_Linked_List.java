/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        //2015-07-18 19:50:02 - 2015-07-18 20:01:01 (11 min)
        if(node == null || node.next == null)
            return;
        
        ListNode p1 = node;
        ListNode p2 = p1.next;
        
        while(p2.next != null){
            p1.val = p2.val;
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.val = p2.val;
        p1.next = null;
    }
}