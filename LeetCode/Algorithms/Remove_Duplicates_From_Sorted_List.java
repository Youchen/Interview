/**
 * Round 2
 * 
 * Be more proficient!
 * DO THIS AGAIN!
 */
public class Solution {
    public static ListNode deleteDuplicates(ListNode head) { 
        //2015-06-10 16:00:52 - 2015-06-10 16:08:43 (8 min)
        if(head == null || head.next == null)
            return head;
        
        ListNode pre = head, cur = head.next;
        while(cur != null){
            if(cur.val == pre.val){
                while(cur != null && cur.val == pre.val)
                    cur = cur.next;
                pre.next = cur;
                pre = pre.next;
                if(cur != null)
                    cur = cur.next;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return head;
    }  
}






/**
 * O(n)
 * O(1)
 * 261 ms
 * 
 * Linked List
 * Two pointers
 * 
 * Note: check head == null first, 
 *          then head.next == null;
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p2 != null){
            while(p2.val == p1.val){
                p2 = p2.next;
                if(p2 == null) {
                    p1.next = p2;
                    break;
                }//if
            }
            if(p2 != null){
                p1.next = p2;
                p1 = p1.next;
                p2 = p2.next;
            }
        }//while
        return head;
    }
}