/**
 * #1 O(n)
 * String
 * 		equals(), length(), char cast to int
 * 
 * #2 O(1)
 * String
 * 		equals(), length(), Arrays.sort()
 * 		char array to String: new String(char[] x)
 */
import java.util.Arrays;
public class C01_03 {
	/**
	 * #1 O(n)
	 */
	public static boolean isPermutation(String a, String b) {
		if(a.equals(b)) return true;
		if(a.length() != b.length()) return false;
		
		int[] aFlag = new int[128];
		
		for(char c : a.toCharArray())
			aFlag[(int)c]++;
		
		for(char c : b.toCharArray()) {
			if(aFlag[(int)c] == 0) return false;
			aFlag[(int)c]--;
		}
		return true;
	}
	
	//#2 Sort Version O(1)
	public static boolean isPermutation_Sort(String a, String b) {
		if(a.length() != b.length()) return false;
		return C01_03.sortArr(a).equals( C01_03.sortArr(b) );
	}
	public static String sortArr(String str) {
		char[] toSort = str.toCharArray();
		Arrays.sort(toSort);
		return new String(toSort);
	}
}
