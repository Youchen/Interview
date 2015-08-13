/**
 * Round 2.1
 * Do THIS AGAIN.
 */
public class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        //2015-06-10 15:46:48 - 2015-06-10 15:58:31 (12 min)
        if( head == null || head.next == null)
            return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        ListNode pre = dummy;
        head = head.next.next;
        
        while(head != null){
            if(head.val == pre.next.val){
                while(head != null && head.val == pre.next.val)
                    head = head.next;
                pre.next = head;
                if(head != null)
                    head = head.next;
            }else{
                pre = pre.next;
                head = head.next;
            }
        }
        return dummy.next;
    }
}












/**
 * Round 2
 * Note:
 *      Needs to review the linked list.
 *      Cost so much time.
 *      DO THIS AGAIN!
 */
public class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        //2015-06-10 11:47:46 pause 2015-06-10 11:50:17
        //resume 2015-06-10 12:05:17 - 2015-06-10 12:26:24 (24 min)
        if(head == null || head.next == null)
            return head;
            
        //must have 2 or more nodes.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy, cur = dummy.next.next;
        while(cur != null){
            if(cur.val == pre.next.val){
                while(cur != null && cur.val == pre.next.val)
                    cur = cur.next;
                pre.next = cur;
                if(cur != null)
                    cur = cur.next;
            }
            else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}










/**
 * O(n)
 * O(1)
 * 261 ms
 * 
 * LinkedList
 * Two pointers
 * 
 * Note:
 *      consider the small special input.
 *      run it in mind before submission.
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
    //1st Submission: 13 min
    //2nd Submission: 17 min (Accepted)
    public ListNode deleteDuplicates(ListNode head) {//01182015 22:37 - 22:54
        if(head == null) return head;
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        
        ListNode p1 = dummy, p2 = head.next;
        
        while(p2 != null){
            if(p2.val == p1.next.val){
                while(p2 != null && p2.val == p1.next.val)
                    p2 = p2.next;
                p1.next = p2;
                if(p2 != null)
                    p2 = p2.next;
            }
            else{
                p1 = p1.next;
                p2 = p2.next;
            }
        }//while
        
        return dummy.next;
    }
}