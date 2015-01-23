package _03;
import java.util.*;
public class C03_07_books_AnimalQueue {
	LinkedList<C03_07_books_Dog> dog;
	LinkedList<C03_07_books_Cat> cat;
	private int order = 0;//timestamp.
	
	public C03_07_books_AnimalQueue() {
		dog = new LinkedList<C03_07_books_Dog>();
		cat = new LinkedList<C03_07_books_Cat>();
	}
	
	public void enqueue(C03_07_books_Animal a) {
		a.setOrder(order++);
		if(a instanceof C03_07_books_Dog)
			dog.addLast((C03_07_books_Dog) a);
		else
			cat.addLast((C03_07_books_Cat) a);
	}
	
	public C03_07_books_Animal dequeueAny() {
		if(dog.isEmpty())
			return dequeueCat();
		if(cat.isEmpty())
			return dequeueDog();
		
		C03_07_books_Dog d = dog.element();
		C03_07_books_Cat c = cat.element();
		if(d.getOrder() < c.getOrder())
			return dequeueDog();
		else
			return dequeueCat();
			
	}
	
	public C03_07_books_Animal dequeueDog() {
		return dog.removeFirst();
	}
	
	public C03_07_books_Animal dequeueCat() {
		return cat.removeFirst();
	}
	
}
