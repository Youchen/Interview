/**
 * O(n log n)
 * O(1)
 * 
 * recursion part is not so proficient.
 *      solved by seeing the solution.
 * DO THIS AGAIN.
 * 
 * Note:
 *      The most hard part is the recursion in ** sortList ** method.
 *      review this part next time.
 */ 
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode mid = findMid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        
        return merge(left, right);
    }
    private ListNode findMid(ListNode head){
        ListNode pre = head, post = head.next;
        while(post != null && post.next != null){
            pre = pre.next;
            post = post.next.next;
        }
        return pre;
    }
    private ListNode merge(ListNode left, ListNode right){
        if(left == null)
            return right;
        if(right == null)
            return left;
        
        ListNode dummy = new ListNode(0);
        ListNode l = left, r = right, d = dummy;
        
        while(l != null || r != null){
            if(l == null){
                d.next = r;
                break;
            }
            else if(r == null){
                d.next = l;
                break;
            }
            
            if(l.val <= r.val){
                d.next = l;
                l = l.next;
            }else{
                d.next = r;
                r = r.next;
            }
            d = d.next;
            d.next = null;
                
        }
        return dummy.next;
    }
}