/**
 * Round 2
 * O(2n) = O(n) the fast pointer mostly scan twice of the list
 *      if the list is a entire huge cycle without any branches.
 * O(1)
 * 
 * Note:
 *      be careful in considering the fast approch to NULL.
 */ 
public class Solution {
    public boolean hasCycle(ListNode head) {  
        //2015-06-11 16:25:21 - 2015-06-11 16:28:28 (3 min)
        if(head == null || head.next == null)
            return false;
        
        ListNode slow = head, fast = head.next;
        while(fast != null){
            if(slow == fast)
                return true;
            if(fast == null || fast.next == null)
                return false;
            
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;//<========== consider what value should be return ?
    }
}



//2015-01-10 
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return true;
        }
        return false;
    }
}