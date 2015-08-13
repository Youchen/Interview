/**
 * O(n)
 * O(1)
 * 
 * Note:
 *      remember this algorithm!
 *      when slow == fast -> let slow = head
 *      then slow fast move one step at the same time.
 *      when fast.next = slow, slow is the enter point.
 */ 
public class Solution {
    public ListNode detectCycle(ListNode head) {  
        //2015-06-11 16:37:18 - 2015-06-11 16:42:21 (5 min)
        if(head == null || head.next == null)
            return null;
        
        ListNode slow = head, fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null)
                return null;
                
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = head;
        while(fast.next != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

