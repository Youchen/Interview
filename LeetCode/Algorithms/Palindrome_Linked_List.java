/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        //2015-07-10 00:47:41 - 2015-07-10 01:14:51 ( - 3min = 24 min)
        if(head == null || head.next == null)
            return true;
        
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        
        ListNode halfHead = slow.next;
        slow.next = null;
        
        ListNode reversedHead = reverse(halfHead);
        
        //compare and verify
        slow = head;
        while(reversedHead != null && slow != null){
            if(reversedHead.val != slow.val)
                return false;
            reversedHead = reversedHead.next;
            slow = slow.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode dummy = new ListNode(0);
        ListNode p = head.next;
        
        while(p != null){
            head.next = dummy.next;
            dummy.next = head;
            
            head = p;
            p = p.next;
        }
        
        //add head to dummy list
        head.next = dummy.next;
        dummy.next = head;
        
        return dummy.next;
    }
}