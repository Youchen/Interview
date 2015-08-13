package _03;

public abstract class C03_07_books_Animal {
	protected String name;
	private int order;
	public C03_07_books_Animal(String n) {
		name = n;
	}
	public void setOrder(int or) {
		order = or;
	}
	public int getOrder() {
		return order;
	}
	public boolean isOlderThan(C03_07_books_Animal a) {
		return this.order < a.getOrder();
	}
}
