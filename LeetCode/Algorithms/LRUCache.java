/**
 * Round 2
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
public class LRUCache {
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
    public LRUCache(int capacity) {
        
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











import java.util.*;
/**
 * 369 ms
 * This is the best way to solve.
 * http://www.acmerblog.com/leetcode-lru-cache-lru-5745.html
 */
// public class LRUCache extends LinkedHashMap<Integer, Integer> {
// 	private int capacity;

// 	public LRUCache(int capacity){
// 		super(1, 0.75f, true);
// 		this.capacity = capacity;
// 	}

// 	public Integer get(Object key){
// 		Integer v = super.get(key);
// 		return (v != null)? v : -1;
// 	}

// 	public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
// 		return this.size() > capacity;
// 	}

// 	public void set(int key, int value){
// 		super.put(key, value);
// 	}
// }


/**
 * 364 ms
 * This is the manual way to implement the LRUCache.
 * http://www.programcreek.com/2013/03/leetcode-lru-cache-java/
 * http://www.cnblogs.com/springfor/p/3869393.html
 */

public class LRUCache{
	private HashMap<Integer, DoubleLLNode> map
			= new HashMap<Integer, DoubleLLNode>();
	private DoubleLLNode head;
	private DoubleLLNode end;
	private int capacity;
	private int len;

	public LRUCache(int capacity){
		this.capacity = capacity;
		len = 0;
	}

	public void removeNode(DoubleLLNode n){
		DoubleLLNode pre = n.pre;
		DoubleLLNode post = n.next;

		if(pre != null){
			pre.next = post;
		}else{//n is head
			head = post;
		}

		if(post != null){
			post.pre = pre;
		}else{//n is end;
			end = pre;
		}
	}

	public void setHead(DoubleLLNode n){
		n.next = head;
		n.pre = null;
		if(head != null){
			head.pre = n;
		}
		head = n;
		if(end == null){//before this method call, the LL is empty.
			end = n;
		}
	}

	public int get(int key){
		if(map.containsKey(key)){
			DoubleLLNode latest = map.get(key);
			removeNode(latest);
			setHead(latest);
			return latest.value;
		}else{
			return -1;
		}
	}

	public void set(int key, int value){
		if(map.containsKey(key)){
			DoubleLLNode oldNode = map.get(key);
			oldNode.value = value;
			removeNode(oldNode);
			setHead(oldNode);
		}else{//No key found
			DoubleLLNode newNode = new DoubleLLNode(key, value);
			if(len < capacity){
				map.put(key, newNode);
				setHead(newNode);
				len++;
			}else{//full
				map.remove(end.key);
				end = end.pre;
				if(end != null)
				    end.next = null;
				map.put(key, newNode);
				setHead(newNode);
			}
		}
	}
}





class DoubleLLNode{
	public int key;
	public int value;
	public DoubleLLNode pre;
	public DoubleLLNode next;

	public DoubleLLNode(int key, int value){
		this.value = value;
		this.key = key;
	}
}







/**
 * 1st trail FAIL.
 */
//public class LRUCache {
    
    
//     private int max, elements = 0;
//     private Hashtable<Integer, Integer> ht;
//     private DoubleLLNode head, tail;
    
//     // private int lruKey;
    
//     public LRUCache(int capacity) {
//         max = capacity;
//         ht = new Hashtable<Integer, Integer>();
//     }
    
//     public int get(int key) {
//         if(!ht.containsKey(key)) return -1;
        
//         lruKey = key;
        
//         int val = ht.get(key);
        
//         ht.remove(key);
//         elements--;
        
//         return val;
//     }
//     /**
//      * Set or insert the value if the key is not already present. 
//      * When the cache reached its capacity, 
//      *      it should invalidate the least recently used item before inserting a new item.
//      */
//     public void set(int key, int value) {
//         if(ht.containsKey(key)){
//             //No need to consider the capacity of the LL.
//             ht.put(key, value);//overwrite the key value pair.
//             removeNode(key);
//             addOnHead(key);
            
//         }else{//no this key found. Needs to add.
//             DoubleLLNode newNode = new DoubleLLNode(key);//wrap the key into DoubleLLNode.
//             if(elements < max){
//                 //add this newNode to the head of the doubleLL.
//                 addOnHead(newNode);
//                 elements++;
//                 ht.put(key, value);
//             }else{//full
//                 ht.remove(end.key);
//                 ht.put(key, value);
                
//                 //remove the end node of DoubleLL
//                 end = end.pre;
//                 if(end != null)
//                     end.next = null;
//                 addOnHead(key, value);
//             }
//         }
        
        
        
//         // if(! ht.containsKey(key)){
//         //     if(elements < max){//not full
//         //         lruKey = key;
//         //         ht.put(key, value);
//         //         elements++;
//         //     }else{//full
//         //         ht.remove(lruKey);
//         //         ht.put(key, value);
//         //         lruKey = key;
//         //     }
//         // }else{//has this key
//         //     if(elements < max){//not full
//         //         lruKey = key;
//         //         ht.put(key, value);
//         //         elements++;
//         //     }else{//full
//         //         ht.remove(lruKey);
//         //         ht.put(key, value);
//         //         lruKey = key;
//         //     }
//         // }
        
//     }
//     public void addOnHead(DoubleLLNode n){
//         n.next = head;
//         if(head != null)
//             head.pre = n;
//         head = n;
//         if(end == null)
//             end = n;
//     }
//     public void removeNode(DoubleLLNode n){
//         DoubleLLNode preNode = n.pre;
//         // DoubleLLNode cur = n;
//         DoubleLLNode nextNode = n.next;
        
//         //deal with the preNode;
//         if(preNode != null){
//             preNode.next = nextNode;
//             //nextNode.pre = preNode;
//         }else{
//             head = nextNode;
//         }
        
//         //deal with the nextNode;
//         if(nextNode != null){
//             nextNode.pre = preNode;
//         }else{//n is the end
//             end = preNode;
//         }
//     }
// }

// public class DoubleLLNode{
//     public int key;
//     public DoubleLLNode pre;
//     public DoubleLLNode next;
    
//     public DoubleLLNode(int key){
//         this.key = key;
//         pre = null;
//         next = null;
//     }
//}