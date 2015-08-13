/**
 * Round 2.1
 * O(n) one-time scan
 * O(1)
 * 
 * Note:
 *      idea is the following:
 *          two pointers at the head position.
 *          let one pointer move n steps first, then both of them move
 *              at the same time, when the prior pointer reach to the end,
 *              the pointer behind points to the nodes that needs to delete.
 */ 
public class Solution {
    ListNode removeNthFromEnd(ListNode head, int n) {
        //2015-06-10 21:47:23 - 2015-06-10 22:03:58 (16 min)
        if(head == null || n == 0)
            return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, post = dummy;
        
        //post => (n + 1)th node from beginning
        for(int i = 0; i < n; i++)
            post = post.next;
        
        while(post.next != null){
            pre = pre.next;
            post = post.next;
        }
        
        pre.next = pre.next.next;
        return dummy.next;
    }
}

