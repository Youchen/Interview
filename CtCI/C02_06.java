package _02;
/**
 * LeetCode: Linked List Cycle II.
 * O(n)
 * O(1)
 * 
 * LinkedList
 * slow-fast pointers
 * 
 * Note:
 * 		This is the 2nd time doing this.
 * 		Solved within 7 min.
 */
public class C02_06 {
	public ListNode detectCycle(ListNode head) {//7 min (1:39 - 1:46)
		if(head == null || head.next == null) return null;
		
		//ensured that there must be two nodes in this list.
		ListNode p1 = head, p2 = head;
		while(true) {
			p1 = p1.next;
			
			if(p2.next == null) return null;
			else
				p2 = p2.next.next;
			
			if(p2 == null) return null;
			
			if(p1 == p2) break;
		}
		p1 = head;
		while(p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
}
