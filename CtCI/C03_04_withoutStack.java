package _03;

public class C03_04_withoutStack {
	public static void main(String[] args) {
		move(3, 'A', 'B', 'C');
	}
	public static void move(int n, char ori, char buf, char des) {
		if(n > 0) {
			move(n - 1, ori, des, buf);
			System.out.println("Move " + n + " from " + ori + " to " + des);
			move(n - 1, buf, ori, des);
		}
	}
}
