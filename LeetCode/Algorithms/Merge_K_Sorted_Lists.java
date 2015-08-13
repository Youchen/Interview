/**
 * Nice done.
 * Review hwo to
 *      instantiate PriorityQueue
 *      write comparator
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //2015-06-11 18:45:51 - 2015-06-11 18:52:53 (7 min)
        if(lists == null || lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, ListNodeComparator);
        for(ListNode ln : lists)
            if(ln != null)
                heap.add(ln);
        
        ListNode dummy = new ListNode(0);
        ListNode iter = dummy;
        
        while( ! heap.isEmpty()){
            ListNode head = heap.poll();
            iter.next = head;
            iter = iter.next;
            if(head.next != null)
                heap.add(head.next);
        }
        return dummy.next;
    }
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>(){
        public int compare(ListNode left, ListNode right){
            if(left == null)
                return -1;
            else if(right == null)
                return 1;
            return left.val - right.val;
        }
    };
}








// ***************************** List version - From lintCode ******************************
/**
 * k = list.size();
 * len = average length of k linked lists.
 * 
 * O( log k * k * len )
 * O(k)
 * 
 * Note:
 *      Pay attention to:
 *          how to write comparator
 *          how to instantiate the priority queue.
 *          marked line (small bugs there when I did the first time.)
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        //2015-06-11 17:52:16
        if( lists == null || lists.size() == 0)
            return null;
        
        if(lists.size() == 1)
            return lists.get(0);
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), listNodeComparator);
        for(int i = 0; i < lists.size(); i++){
            if(lists.get(i) != null)
                heap.add(lists.get(i));
        }
        
        ListNode dummy = new ListNode(0);
        ListNode iter = dummy;
    
        while(! heap.isEmpty()){
            ListNode head = heap.poll();
            iter.next = head;
            iter = iter.next;
        
            if(head.next != null)    //<=========
                heap.add(head.next); //<=========
        }
        return dummy.next;
    }
    private Comparator<ListNode> listNodeComparator =
                                            new Comparator<ListNode>(){
        public int compare(ListNode left, ListNode right){
            if(left == null)
                return 1;
            else if(right == null)
                return -1;
            return left.val - right.val;
        }
    };
}

