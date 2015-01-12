

public class Node {
	public int d;
	public Node next;
	
	public Node(int data) {
		d = data;
		next = null;
	}
	//default to acknowledge that the Node here is the
	//		head node in Linked List.
	public void append(int data) {
		Node temp = new Node(data);
		Node n = this;
		while(n.next != null)
			n = n.next;
		n.next = temp;
	}
	
	public void print() {
		Node temp = this;
		while(true) {
			System.out.print(temp.d + " ");
			temp = temp.next;
			if(temp == null) break;
		}
		System.out.println();
	}
}

