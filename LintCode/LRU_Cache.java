/**
 * Note:
 *      Need to remember the two critical methods that we need to use:
 *          removeNode
 *          setHead
 * 
 * 
 * Need to know the LRU Cache principle.
 * 
 * Reference:
 *      http://androidsrc.net/lru-cache-java-implementation/
 * 
 * LRU Cache is designed for finding the location of desired page on disk. 
 *      It maintains a cache of page number and its location on disk.
 * 
 * Whenever there is a request for new page number, Following operation will be performed.
 * 
 * – If it is present in cache, it is moved to front of the list and location is returned.
 * 
 * – If it is not present , a new page mapping is done. If cache is not full, 
 *      a new entry is added to front otherwise least recently used entry is 
 *      removed and then a new entry to front is added..
 * 
 * It should support two main operation.
 * 
 * set(int key, int value) -To add page number and disk location entry in cache. 
 *          If cache is full, it should discard least recently used entry and add new one.
 * 
 * get(int key)– Return location on disk for given page number else return -1. 
 *          If entry is present, reorder it to front.
 * 
*/
public class Solution {
    //2015-06-17 12:08:50 pause 2015-06-17 12:11:34
    //resume 2015-06-17 12:13:57 pause 2015-06-17 12:20:20
    //2015-06-17 12:48:24 - 2015-06-17 13:48:34 (1 h 10 min)
    private class Node{
        Node pre;
        Node next;
        
        int key;
        int value;
        
        public Node(int k, int v){
            key = k;
            value = v;
            pre = null;
            next = null;
        }
        
        public Node(){
            key = -1;
            value = -1;
            pre = null;
            next = null;
        }
        
        public int getValue(){
            return value;
        }
        
        public void setValue(int v){
            value = v;
        }
    }

    
    
    private int capacity;
    private HashMap<Integer, Node> hm;
    private Node head, tail;
    private int curCapa;
    
    // @param capacity, an integer
    public Solution(int capacity) {
        
        this.capacity = capacity;
        hm = new HashMap<Integer, Node>();
        // head = new Node();
        // tail = new Node();
        curCapa = 0;
    }

    public int get(int key) {
        if ( hm.containsKey(key) ){
            
            Node temp = hm.get(key);
            
            //move temp to head
            removeNode(temp);
            setHead(temp);
            
            return temp.getValue();
        }
        else
            return -1;
    }
    
    public void set(int key, int value) {
        if(hm.containsKey(key)){
            Node temp = hm.get(key);
            temp.setValue(value);
            
            removeNode(temp);
            setHead(temp);
        }else{//no key found
            Node addNode = new Node(key, value);
            if(curCapa == capacity){//full
                //update hashMap
                hm.remove(tail.key);
                tail = tail.pre;
                
                if(tail != null)
                    tail.next = null;

                hm.put(key, addNode);
                setHead(addNode);
            }else{//not full;
                hm.put(key, addNode);
                setHead(addNode);
                curCapa++;
            }
        }
    }

    public void removeNode(Node n){
        Node nPre = n.pre;
        Node nNext = n.next;

        //see if pre node is empty
        //      from this criteria, 
        //      we can know if n is head or not
        if(nPre != null)//not head
            nPre.next = nNext;
        else
            head = nNext;

        //as above, concern nNext;
        if(nNext != null)//not tail
            nNext.pre = nPre;
        else
            tail = nPre;
    }

    public void setHead(Node n){
        n.next = head;
        n.pre = null;

        //You need to consider the head and tail.
        //      see if they are null or not.
        if(head != null)
            head.pre = n;

        head = n;

        if(tail == null)
            tail = n;
    }
}

