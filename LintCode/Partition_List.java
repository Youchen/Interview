/**
 * O(n) scan once
 * O(1)
 * 
 * Note:
 *      Maintain two queues, then concatenate them.
 */ 
public class Solution {
    public ListNode partition(ListNode head, int x) {
        //2015-06-10 22:10:15 - 2015-06-10 22:19:00 (9 min)
        if( head == null || head.next == null)
            return head;
        
        ListNode lt = new ListNode(0);
        ListNode ge = new ListNode(0);
        ListNode iter = head, iterLt = lt, iterGe = ge;
        
        while(iter != null){
            if(iter.val < x){
                iterLt.next = iter;
                iter = iter.next;
                
                iterLt = iterLt.next;
                iterLt.next = null;
            }else{
                iterGe.next = iter;
                iter = iter.next;
                
                iterGe = iterGe.next;
                iterGe.next = null;
            }
        }
        iterLt.next = ge.next;
        return lt.next;
    }
}

