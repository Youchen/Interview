
/**
 * #1 w/ Buffer(HashSet)
 * Time: O(n)
 * Space: O(n) = O(2 + n)
 * 
 * #2 w/o Buffer(brute force traverse)
 * Time: O(n^2)
 * Space: O(1) = O(2)
 * 
 * Linked List Node
 * 		Note : Check the null pointer!!
 */
import java.util.*;
public class C02_01 {
	public static void main(String[] args) {
		
		Node n = new Node(1);
		for(int i = 2; i <= 5; i++)
			n.append(i);
		n.print();
		n.append(2);
		n.append(5);
		n.append(5);
		n.print();
		//test
//		test(n);
//		System.out.println("new");
//		n.print();
		
//		deleteDuplicates(n);
//		deleteDups_Correct(n);
		deleteDuplicates_NoBuffer(n);
		n.print();
	}
	public static void deleteDuplicates(Node n) {
		Node temp = n;
		if(temp.next == null) return;
		
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(n.d);
		
		Node temp2 = temp.next;
		while(true) {
			if(!hs.add(temp2.d)) {
				temp.next = temp2.next;
				temp2 = temp.next;
				if(temp2 == null) break;
			}
			else {
				temp2 = temp2.next;
				temp = temp.next;
				if(temp2 == null) break;
			}
		}
	}
	
	public static void deleteDups_Correct(Node n){
		Hashtable table = new Hashtable();
		Node pre = null;
		while(n != null){
			if(table.containsKey(n.d))
				pre.next = n.next;
			else{
				table.put(n.d, true);
				pre = n;
			}
			n = n.next;
		}
	}
	
	public static void deleteDuplicates_NoBuffer(Node n) {
		Node runner;
		Node pre;
		
		while(n != null) {
			pre = n;
			runner = n.next;
			while(runner != null) {
				if(runner.d == n.d) {
					pre.next = runner.next;
				}
				else
					pre = pre.next;
				runner = runner.next;
			}
			n = n.next;
		}
	}
	/**
	 * This saying that modifying the parameter passed in, 
	 * 		does not affect the original List.
	 */
	public static void test(Node n) {
		while(n != null) {
			n = n.next;
		}
	}
}
