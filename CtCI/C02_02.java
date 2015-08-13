package _02;
/**
 * O(n)
 * O(1)
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class C02_02 {
	public static void main(String[] args) {
		ListNode ln = new ListNode(1);
		ln.append(2);
		ln.append(3);
		ln.append(4);
		removeKthToLast(ln, 1).print();
	}
	public static ListNode removeKthToLast(ListNode head, int k) {
		if(head == null) return null;
		
		ListNode p1 = head, p2 = head;
		while(k > 0) {
			p2 = p2.next;
			k--;
		}
		
		if(p2 == null) {
			head = head.next;
			return head;
		}
		
		while(p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		p1.next = p1.next.next;
		return head;
		
	}
}
