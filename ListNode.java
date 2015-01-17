package _02;

public class ListNode {
	public int val;
	public ListNode next;
	
	public ListNode(int data) {
		val = data;
		next = null;
	}
	//default to acknowledge that the Node here is the
	//		head node in Linked List.
	public void append(int data) {
		ListNode temp = new ListNode(data);
		ListNode n = this;
		while(n.next != null)
			n = n.next;
		n.next = temp;
	}
	
	public void print() {
		if(this == null) return;
		ListNode temp = this;
		while(true) {
			System.out.print(temp.val + " ");
			temp = temp.next;
			if(temp == null) break;
		}
		System.out.println();
	}
}
