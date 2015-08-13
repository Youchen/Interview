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
