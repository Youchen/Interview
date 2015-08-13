/**
 * Round 2
 * O(n)
 * O(n) since we need to have a copy, beside the returned deep copy list.
 *          I used O(1) auxiliary space.
 * 
 * Note:
 *      Be carefull with the availability of the pointer.
 *      See marked line for detail.
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        //2015-06-11 20:58:58 - 2015-06-11 21:25:45 (27 min)
        if( head == null )
            return null;
        
        //make copy node after each node
        copyAfterEach(head);
        //copy random pointer
        copyRandomPointer(head);
        //separate two linked list.
        return separateTwo(head);
        
    }
    private void copyAfterEach(RandomListNode head){
        RandomListNode iter = head;
        while(iter != null){
            RandomListNode copy = new RandomListNode(iter.label);
            copy.next = iter.next;
            iter.next = copy;
            
            iter = copy.next;
        }
    }
    private void copyRandomPointer(RandomListNode head){
        RandomListNode iter = head;
        while(iter != null){
            if( iter.random != null )//<==== did not have this line when coded.
                iter.next.random = iter.random.next;
            iter = iter.next.next;
        }
    }
    private RandomListNode separateTwo(RandomListNode head){
        RandomListNode deepCopy = new RandomListNode(0);
        RandomListNode headIter = head;
        RandomListNode deepCopyIter = deepCopy;
        
        while(headIter != null){
            deepCopyIter.next = headIter.next;
            headIter.next = headIter.next.next;
            
            headIter = headIter.next;
            deepCopyIter = deepCopyIter.next;
        }
        return deepCopy.next;
    }
}












import java.util.*;
/**
 * DO IT AGAIN.
 * O(n) since O(3n)
 * O(n)
 * 312 ms
 * 
 * LinkedList
 * 
 * Note:
 *      Think about the idea deeply.
 *      Try to find a special way to solve.
 * 
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    //1st Submission 37 min
    //2nd Submission 37 min
    //3rd Submission 38 min (Accepted)
    public RandomListNode copyRandomList(RandomListNode head) {//01182015 23:05 - 23:43
        if(head == null) return null;
        
        //insert duplicate node after each original node 
        RandomListNode p = head;
        while(p != null){
            RandomListNode temp = new RandomListNode(p.label);
            temp.next = p.next;
            p.next = temp;
            
            p = p.next.next;
        }
        
        //copy random pointers.
        p = head;
        while(p != null){
            if(p.random != null)
                p.next.random = p.random.next;
            else
                p.next.random = null;
                
            p = p.next.next;
        }
        
        //split two list
        p = head;
        RandomListNode q = p.next.next, returnHead = head.next;
        
        while(q != null){
            p.next.next = q.next;
            p.next = q;
            
            p = p.next;
            q = q.next.next;
        }
        p.next = null;
        
        return returnHead;
    }
}