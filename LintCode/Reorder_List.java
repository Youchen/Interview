/**
 * O(n + 2 / n + n) = O(n)
 * O(1)
 * 
 * DO THIS AGAIN.
 * 
 * Note:
 *      Stucked on the zigZag concatenation part.
 *      consider carefully!
 */ 
public class Solution {
    public void reorderList(ListNode head) {  
        //2015-06-11 14:23:34 pause 2015-06-11 14:57:09
        //resume 2015-06-11 15:56:34 - 2015-06-11 16:14:07 (34 + 18 = 52 min)
        if(head == null || head.next == null)
            return;
        
        ListNode mid = findMid(head);
        ListNode right = mid.next;
        mid.next = null;
        
        //reverse right Linked list.
        right = reverse(right);
        
        head = merge(head, right);
        
        return;
    }
    private ListNode findMid(ListNode head){
        if(head == null || head.next == null)
            return head;
        
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
            
        ListNode dummy = new ListNode(0);
        ListNode headNext = head.next;
        
        while(headNext != null){
            head.next = dummy.next;
            dummy.next = head;
            
            head = headNext;
            headNext = headNext.next;
        }
        head.next = dummy.next;
        dummy.next = head;
        
        return dummy.next;
    }
    private ListNode merge(ListNode left, ListNode right){
        if(left == null)
            return right;
        if(right == null)
            return left;
        
        ListNode leftPost = left.next;
        ListNode rightPost = right.next;
        
        ListNode dummy = new ListNode(0);
        dummy.next = left;
        
        while( left != null || right != null){
            if(
                (left == null && leftPost == null) ||
                (right == null && rightPost == null)
                )
                break; //<================ this if statement is important!!
            
                
                
            left.next = right;
            left = leftPost;
            if(leftPost != null)
                leftPost = leftPost.next;
            else
                leftPost = null;
                
            right.next = left;
            right = rightPost;
            if(rightPost != null)
                rightPost = rightPost.next;
            else
                rightPost = null;
                
            
        }
        return dummy.next;
    }
}

