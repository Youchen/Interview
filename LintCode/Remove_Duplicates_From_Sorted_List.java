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
