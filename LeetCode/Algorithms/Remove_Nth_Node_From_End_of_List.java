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







/**
 * Round 2
 * O(n) => scan twice
 * O(1)
 * Naive way
 */ 
public class Solution {
    ListNode removeNthFromEnd(ListNode head, int n) {
        //2015-06-10 18:45:35 - 2015-06-10 18:55:08 ( 10 min )
        if(head == null || n == 0)
            return head;
        
        //get length;
        ListNode iterator = head;
        int count = 1;
        while(iterator != null){
            iterator = iterator.next;
            count++;
        }
        count--;
        
        //compute the "Nth" - 1 from the beginning.
        n = count - n;
        //meaning (n + 1)th needs to be deleted.
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        iterator = dummy;
        
        //find the (n + 1)th
        for(int i = 0; i < n; i++){
            iterator = iterator.next;
        }
        iterator.next = iterator.next.next;
        
        return dummy.next;
            
    }
}












/**
 * O(n)
 * O(n)
 * 251 ms
 * 
 * LinkedList
 * Two-pointers
 * 
 * Note:
 *      Analyze the special small input case!
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //My Solution: O(n) O(n) 251 ms
        if(head.next == null) return null;
        
        ListNode[] p = new ListNode[n+1];
        p[0] = head;
        for(int i = 1; i < p.length; i++){
            p[i] = p[i - 1].next;
        }
        
        if(p[p.length - 1] == null){
            head = head.next;
            return head;
        }
        
        
        while(p[p.length - 1].next != null){
            for(int i = 0; i < p.length; i++)
                p[i] = p[i].next;
        }
        p[0].next = p[1].next;
        return head;
        
        
        
        
        
        /**
         * idea From 
         *      http://fisherlei.blogspot.com/2012/12/leetcode-remove-nth-node-from-end-of.html
         * O(n)
         * O(1)
         * 245 ms
         */
        // ListNode p1 = head, p2 = head;
        // for(int i = 0; i < n; i++)
        //     p2 = p2.next;
        // if(p2 == null){//remove the head.
        //     head = head.next;
        //     return head;
        // }
        // while(p2.next != null){
        //     p1 = p1.next;
        //     p2 = p2.next;
        // }
        // p1.next = p1.next.next;
        // return head;
    }
}