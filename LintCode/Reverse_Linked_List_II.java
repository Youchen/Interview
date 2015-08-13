/**
 * O(n) - scan once
 * O(1)
 * 
 * Note:
 *      Cost so much time.
 *      for the reverse part in the for loop, consider the general case
 *              instead of the initial case.
 *      Great algorithm. Practice for proficiency!
 * 
 * Reference:
 *      https://leetcode.com/discuss/25580/simple-java-solution-with-clear-explanation
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m , int n) {
        //2015-06-10 16:43:10 pause 2015-06-10 17:18:34
        //resume 2015-06-10 18:18:38 - 2015-06-10 18:40:22 ( 57 min )
        if(head == null || head.next == null || m == n)
            return head;
            
        //Nodes >= 2
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        for(int i = 0; i <= m - 2; i++)
            pre = pre.next;
        
        ListNode cur = pre.next;
        ListNode post = cur.next;
    
    
        for(int i = 0; i < n - m; i++){
            cur.next = post.next;
            post.next = pre.next;
            pre.next = post;
            post = cur.next;
        }
        return dummy.next;
    }
}
