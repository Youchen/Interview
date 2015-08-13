package _03;

public class C03_04_test {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		int n = 10;
		C03_04_Tower[] t = new C03_04_Tower[n];
		for(char i = 'A'; i - 'A' <= 2; i++) {
			t[i - 'A'] = new C03_04_Tower(i);
		}
		
		for(int i = n; i >= 1; i--) {
			t[0].add(i);
		}
		t[0].moveDisks(n, t[2], t[1]);
		System.out.println("**Spent " + Long.toString(System.currentTimeMillis() - time) + " ms.**");
	}
}
