/**
 * Round 2
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







/**
 * O(ListLength) since O(m + n) < O(List_length)
 * O(n) since O(n - m + 2 + 1) < O(n - m) < O(n)
 * 200 ms 
 * 
 * LinkedList
 * Two-pointers
 * 
 * Note:
 *      Be careful for the variable using.
 *      Better keep in mind if the var is changed or not before using it.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {//35 min
        if(head == null || head.next == null || m == n) return head;
        
        ListNode p1 = head, p2 = head;
        int len = n - m + 1;
        int[] value = new int[len];
        m--;
        
        while(m >= 1){
        	m--;
        	p1 = p1.next;
        	p2 = p2.next;
        }//while
        
        //p1 stay here, p2 traverse untial n;
        for(int i = 0; i <= len - 1; i++){//before here is i <= n - m, actually, m is changed to 0.
            value[i] = p2.val;
            p2 = p2.next;
        }
        
        for(int i = len - 1; i >= 0; i--){
            p1.val = value[i];
            p1 = p1.next;
        }
        
        return head; 
    }
}