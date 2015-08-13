package _03;

import java.util.*;
/**
 * The disadvantage of this implementation is that
 * 		for example, if the first (let's say a ) billion animals are all cats
 * 		then this algorithm needs to traverse billion times to find a dog.
 */
public class C03_07_my {
	/**
	 * This linked list is maintained as
	 * 		head is the oldest animal and tail is the newest.
	 * 
	 * All animals are represented in the list by integers.
	 * Cat and dog are in the same list, but
	 * 		cat is represented by odd numbers.
	 * 		dog is represented by even numbers.
	 */
	LinkedList<Integer> l;
	
	public C03_07_my() {
		l = new LinkedList<Integer>();
	}
	public void enqueue(int i) {
		l.add(i);
	}
	public int dequeueAny() throws Exception{
		if(! l.isEmpty() )
			return l.removeFirst();
		throw new Exception("No animal in this shelter.");
	}
	public int dequeueDog() {
		int index = 0;
		Integer p = l.get(index++);//p as a traversal pointer from head.
		while(p.intValue() % 2 != 0)
			p = l.get(index++);
		int dog = l.remove(--index);
		return dog;
	}
	public int dequeueCat() {
		int index = 0;
		Integer p = l.get(index++);//p as a traversal pointer from head.
		while(p.intValue() % 2 != 1)
			p = l.get(index++);
		int cat = l.remove(--index);
		return cat;
	}
}
