/**
 * I did this twice.
 * First time was to initial the LinkedList with first digit value, then while loop.
 *      It's not the best solution.
 *
 * Note:
 *      Just consider before implementation.
 *      Do not initial the Linkedlist with one value then go into while loop if it can go into while loop at the first time.
 *
 *      Try to solve the problem occurred in smart way, like
 *          you may return head.next instead of head.
 */
/**
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
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        //2015-05-05 18:31:21 - 2015-05-05 18:53:06 (22 min)
        // write your code here
        if(l1 == null && l2 == null)
            return null;
        else if(l1 != null && l2 == null)
            return l1;
        else if(l1 == null && l2 != null)
            return l2;
            
        //l1 != null && l2 != null
        //19:00 - 19:07 (7 min)
        ListNode p1 = l1, p2 = l2;
        ListNode tempNode = new ListNode(0);
        ListNode head = tempNode;
        int value1, value2, tempSum, carry = 0;
        
        while(p1 != null || p2 != null){
            value1 = (p1 == null)? 0 : p1.val;
            value2 = (p2 == null)? 0 : p2.val;
            
            tempSum = carry + value1 + value2;
            carry = tempSum / 10;
            
            tempNode.next = new ListNode(tempSum % 10);
            
            tempNode = tempNode.next;
            p1 = (p1 == null)? p1 : p1.next;
            p2 = (p2 == null)? p2 : p2.next;
        }
        
        if(carry > 0)
            tempNode.next = new ListNode(carry);
            
        return head.next;
    }
}

