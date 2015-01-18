package _02;
import java.util.*;
/**
 * O(n)
 * O(n)
 * 
 * LinkedList
 * ArryList or Stack.
 * 
 * Implement a function to check if a linked list is a palindrome.
 * 
 * Idea of book:
 * 		1. build a linked list which reverse the original one.
 * 			compare the new one with the original one, one node by one node.
 * 			only compare half size of the list.
 * 		2. by using stack and slow faster pointer.
 * 			when the faster pointer reaches the end, pop the stack and compare
 * 			the poped value with slow pointer.
 * 		3. Recursive
 * 			
 */
public class C02_07 {
	public static void main(String[] args) {
		ListNode ln = new ListNode(1);
		ln.append(2);
		ln.append(3);
		ln.append(2);
		ln.append(1);
		System.out.println(isPalindrome(ln));
		
		ListNode ln2 = new ListNode(1);
		System.out.println(isPalindrome(ln2));
		
		ListNode ln3 = new ListNode(1);
		ln3.append(2);
		System.out.println(isPalindrome(ln3));
	}
	public static boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null) return true;
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		while(head != null) {
			al.add(head.val);
			head = head.next;
		}
		int i = 0, j = al.size() - 1;
		while(i <= j) {
			if(al.get(i) != al.get(j))
				return false;
			i++;
			j--;
		}
		return true;
		
	}
}
