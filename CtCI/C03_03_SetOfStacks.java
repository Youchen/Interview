package _03;
import java.util.*;

public class C03_03_SetOfStacks extends ArrayList<Stack<Integer>>{
	int capacity = 100; //default value is 100;
	int curStack = 0;
	int ele_stack = 0;//element in current stack.
	
	ArrayList<Stack<Integer>> al;
	
	public C03_03_SetOfStacks(int c) {
		capacity = c;
		
		al = new ArrayList<Stack<Integer>>();
//		Stack<Integer> s = new Stack<Integer>();
//		al.add(s);
		al.add(new Stack<Integer>());
		
		curStack++;
	}
	
	public void push(int d) {
		if(ele_stack < capacity) {//if =, need new stack.
			al.get(curStack).push(d);
			ele_stack++;
		}
		else {//initialize new stack.
//			Stack<Integer> s = new Stack<Integer>();
			al.add(new Stack<Integer>());
			curStack++;
			al.get(curStack).push(d);
			ele_stack = 1;
		}
	}
	public int pop() throws Exception{
		
		if(ele_stack == 0) {
			throw new Exception("No item yet in Stack.");
		}
		int value = al.get(curStack).pop();
		ele_stack--;
		if(ele_stack == 0) {
			al.remove(curStack);
			curStack--;
			ele_stack = capacity;
		}
		return value;
	}
	public int pop(int index) throws Exception{
		/**
		 * No "right answer" here, just talk with interviewer regarding
		 * 		the trade-offs.
		 */
		if(ele_stack == 0) {
			throw new Exception("No item yet in Stack.");
		}
		int value = al.get(curStack).pop();
		/**
		 * here I can implement the "update" way, like push the next stack 
		 * 		bottom item into the current stack, then push the next next
		 * 		stack bottom item into the next stack etc.
		 * But this will cause large time complexities.
		 * 
		 * Or I may just pop the pointed stack, but later on, there will be a problem,
		 * 		because if all the stacks which follows this stack are empty, I assumed that
		 * 		this stack will be reached at a full capacity.
		 */
		return value;
	}
	public int peek() throws Exception{
		if(ele_stack == 0) {
			throw new Exception("No item yet in Stack.");
		}
		return al.get(curStack).peek();
	}
	public boolean isEmpty() {
		return ele_stack == 0;
	}
}
