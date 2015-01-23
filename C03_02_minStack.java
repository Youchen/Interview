package _03;
import java.util.*;
/**
 * DO THIS AGAIN!
 *
 */
public class C03_02_minStack extends Stack<Integer> {
	
	Stack<Integer> minS;//= new Stack<Integer>();
	
	public C03_02_minStack() {
		minS = new Stack<Integer>();
	}
	
	public void push(int d) {
		if(d <= CurMin() )
			minS.push(d);
		super.push(d);
	}
	public Integer pop() {
		if(super.peek() == CurMin() )
			minS.pop();
		return super.pop();
	}
	
	public int CurMin() {
		if(minS.isEmpty())
			return Integer.MAX_VALUE;
		return minS.peek();
	}
}
