package _03;

public class C03_01_test {
	public static void main(String[] args) {
		C03_01_StackArr s = new C03_01_StackArr(2);
		try {
			s.push(1, 1);
			s.push(1, 2);
//			s.push(1, 3);
			System.out.println(s.pop(1));
		
			s.push(2, 1);
			s.push(2, 2);
//			s.push(2, 3);
			System.out.println(s.pop(2));
		}catch(Exception e) {e.printStackTrace();}
		
	}
	
}
