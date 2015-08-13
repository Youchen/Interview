/**
 * Pay attention to the details.
 */
/**
 * Definition for ListNode
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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        //2015-06-17 11:30:15 - 3 min - 2015-06-17 12:07:02 ( 34 min )
        if( hashTable == null || hashTable.length == 0)
            return null;
        
        int len = hashTable.length, len2 = len * 2;
        ListNode[] rehashing = new ListNode[len2];
        
        //initialize all to null
        for(int i = 0; i < len2; i++)
            rehashing[i] = null;
        
        int hashCode1 = 0;
        
        for(int i = 0; i < len; i++){
            ListNode curHead = hashTable[i];

            while(curHead != null){
                if(curHead.val >= 0)
                    hashCode1 = curHead.val % len2;
                else
                    hashCode1 = ( curHead.val % len2 + len2 ) % len2;
                
                //separate node from original linked list.
                hashTable[i] = curHead.next;
                curHead.next = null;
                
                ListNode rehashingNode = rehashing[hashCode1];
                
                if(rehashingNode == null)
                    rehashing[hashCode1] = curHead;
                else{
                    while(rehashingNode.next != null)
                        rehashingNode = rehashingNode.next;
                    rehashingNode.next = curHead;
                }
                curHead = hashTable[i];  
            }
        }
        return rehashing;
    }
};

