/**
  * Iterative
  *     Review this code. So nice!
  * 
  * Reference:
  *     https://leetcode.com/discuss/34474/in-place-iterative-and-recursive-java-solution
  */
public class Solution {
    public ListNode reverseList(ListNode head) {
        //2015-05-13 15:35:34 - 2015-05-13 15:38:21 (3 min)
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}





/**
  * Recursive
  *     Review this code. So nice!
  * 
  * Reference:
  *     https://leetcode.com/discuss/34474/in-place-iterative-and-recursive-java-solution
  */
public class Solution {
    public ListNode reverseList(ListNode head) {
        //2015-05-13 15:16:22 - 2015-05-13 15:19:50 (3 min)
        return reverseList(head, null);
    }
    private ListNode reverseList(ListNode head, ListNode newHead){
        if(head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseList(next, head);
    }
}






/**
 * Need to have two pointers.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        //2015-05-13 00:37:08 -18 - 2015-05-13 01:03:48 (8 min)
        if(head == null)
            return null;
        
        ListNode p1 = head, p2 = head.next;
        ListNode dummy = new ListNode(0);
        
        while(p1 != null){
            p1.next = dummy.next;
            dummy.next = p1;
            p1 = p2;
            if(p2 != null)
                p2 = p2.next;
        }
        return dummy.next;
    }
}