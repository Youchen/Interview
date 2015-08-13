package _03;
import java.util.*;
/**
 * ReConsider this again.
 * 
 * Note:
 * 		Learn the "lazy" way of algorithm from this problem.
 * 		lazy way:(important & time complexity efficient)
 * 			implement Queue by 2 stack, it's no need to update the out 
 * 			stack everytime when the in stack got new element.
 * 
 * 			It's time complexity efficient by the way that 
 * 			we update the out stack only when we need to poll(pop) this queue
 * 			but the out stack is empty.
 */


/**
 * 1st implementation.
 */
//public class C0 3_05_MyQueue {
	
//	public Stack<Integer> in;
//	public Stack<Integer> out;
//	
//	public C03_05_MyQueue(){
//		in = new Stack<Integer>();
//		out = new Stack<Integer>();
//	}
//	public void add(int i) {
//		if(out.isEmpty()) {
//			out.push(i);
//		}else {
//			while(!out.isEmpty()) {
//				int val = out.pop();
//				in.push(val);
//			}
//			in.push(i);
//			while(! in.isEmpty()) {
//				int val = in.pop();
//				out.push(val);
//			}
//		}//else
//	}//add
//	public int poll() throws Exception{
//		if(out.isEmpty()) {
//			throw new Exception("Cannot poll, since queue is empty!");
//		}
//		return out.pop();
//	}
//}
/**
 * Book's idea
 */
public class C03_05_MyQueue<T> {
	
	public Stack<T> newS;
	public Stack<T> oldS;
	
	public C03_05_MyQueue(){
		newS = new Stack<T>();
		oldS = new Stack<T>();
	}
	public void add(T i) {
		newS.push(i);
	}//add
	public void shiftStacks() {
		if(oldS.isEmpty()) {//if oldS is not empty, then no need for shift.
			while(!newS.isEmpty()) {
				oldS.push(newS.pop());
			}
		}//if
	}
	public T poll() throws Exception{
		if(oldS.isEmpty() && newS.isEmpty()) {
			throw new Exception("Cannot poll, since queue is empty!");
		}
		shiftStacks();
		return oldS.pop();
	}
	public T peek() {
		shiftStacks();
		return oldS.peek();
	}
}
