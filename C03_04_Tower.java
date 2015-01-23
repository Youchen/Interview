package _03;
import java.util.*;
/**
 * DO IT AGAIN.
 *
 * Psedo Code:
 * 		public void moveDisks(int n, Tower origin, Tower destination, Tower buffer){
 * 			//base case
 * 			if(n == 0) return;
 * 
 * 			//move top n - 1 to buffer
 * 			moveDisks(n - 1, origin, buffer, destination);
 * 			
 * 			//move the bottom one from origin to destination
 * 			moveBottom(origin, destination);
 * 	
 * 			//move the top n - 1 from buffer to destination
 * 			moveDisks(n - 1, buffer, destination, origin);
 */
public class C03_04_Tower {
	public Stack<Integer> s;
//	public int index;
	public char name;
	public static int moves = 0;
	
	public C03_04_Tower(char i) {
		s = new Stack<Integer>();
		name = i;
	}

	public void add(int i) {
		if( ! s.isEmpty() && s.peek() <= i) {
			System.out.println("Can NOT move to Tower " + i + ".");
		}else {
			s.push(i);
		}
	}

	public void moveTopTo(C03_04_Tower des) {
		int top = s.pop();
		des.add(top);
		moves++;
		System.out.println(moves + ": Move disk " + top + " from " + name + " to " + des.name + ".");
	}

	public void moveDisks(int n, C03_04_Tower destination, C03_04_Tower buffer) {
		if(n > 0) {
			moveDisks(n - 1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n - 1, destination, this);
		}
	}
}
