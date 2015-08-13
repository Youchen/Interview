package _03;
import java.util.*;
/**
 * O(n^2)
 * O(n)
 * 
 * Stack
 */
public class C03_06{
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 0; i < 6; i++) {
			int val = ran(1, 100);
			s.push(val);
			System.out.println(val);
		}
		s = sortStack(s);
		System.out.println("Stack sorted.");
		while(! s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
	public static Stack<Integer> sortStack(Stack<Integer> s) {
		if(s.isEmpty() || s.size() == 1) return s;
		
		Stack<Integer> temp = new Stack<Integer>();
		int count = 0;
		
		while(! s.isEmpty()) {
			int i = s.pop();
			if(! temp.isEmpty() && i > temp.peek()) {
				while(! temp.isEmpty() && temp.peek() < i) {
					s.push(temp.pop());
					count++;
				}
				temp.push(i);
				while(count > 0) {
					temp.push(s.pop());
					count--;
				}
			}else {
				temp.push(i);
			}
		}
		return temp;
	}
	public static int ran(int low, int high) {
		Random r = new Random();
		return r.nextInt(high - low) + low;
	}
}
