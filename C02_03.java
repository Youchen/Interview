package _02;
/**
 * DO IT AGAIN!
 * O(1)
 * O(1)
 * LikedList
 * 
 * Note:
 * 		Consider the case if we really need traverse entire list.
 */

public class C02_03 {
	public static void main(String[] args) {
		ListNode ln = new ListNode(1);
		ln.append(2);
		ln.append(3);
		ln.append(4);
		ln.append(5);
		removeMiddle(ln.next.next);
		ln.print();
		
		ListNode ln2 = new ListNode(1);
		removeMiddle(ln2);
		ln2.print();
	}
	public static void removeMiddle(ListNode m) {
		if(m == null || m.next == null) {
			m = null;
			return;
		}
		ListNode n = m.next;
		
		//below is idea from the book solution.
		m.val = n.val;
		m.next = n.next;
		
		//below is my original idea.
//		while(n.next != null) {
//			m.val = n.val;
//			m = m.next;
//			n = n.next;
//		}
//		m.val = n.val;
//		m.next = null;
//		n = null;
	}
}
