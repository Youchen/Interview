/**
 * Nice done
 * 
 * Pay attention to the while loop marked
 * you need this line.
 * 
 * I've stucked here for couple of minutes.
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //2015-06-11 20:48:57 - 2015-06-11 20:55:49 ( 7 min )
        if(head == null)
            return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode iter = dummy;
        while(iter.next != null){
            if(iter.next.val == val){
                while(iter.next != null && iter.next.val == val) // <=======
                    iter.next = iter.next.next;
            }else
                iter = iter.next;
        }
        
        return dummy.next;
    }
}