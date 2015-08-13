/**
 * O(n)
 * 
 * String.
 * 		To check if a string have some substring, use contains.
 * 			contains invokes indexOf(String str) //return -1 if no such substring.
 * 		To check the rotation of the string, simply double the string and use contains.
 */
public class C01_08 {//1559
	/**
	 * Check if s2 is rotation of s1 using only one call to isSubstring.
	 * 
	 * s2 = "waterwattle" is rotation of
	 * s1 = "erwattlewat"
	 */
	public static void main(String[] args) {
		String s2 = "waterwattle";
		String s1 = "erwattlewat";
		System.out.println(isRotation_CorrectAnswer(s1, s2));

	}
	public boolean isRotation(String s1, String s2) {//22 min FAIL
		if(s1.length() != s2.length()) return false;
		int i = 0, begin, s2Index = 0;
		while(i < s1.length() && s1.charAt(i) != s2.charAt(0) )
			i++;
		begin = i;
		while(i < s1.length()) {
			if(s1.charAt(i) != s2.charAt(s2Index))
				return false;
			else {
				i++;
				s2Index++;
			}
		}//while
		return isSubstring(s1.substring(0, begin), s2);
	}

	public static boolean isSubstring(String cd, String bcde) {//13 min
		int i = 0;
		while( bcde.charAt(i) != cd.charAt(0) && i <= bcde.length() - 1)
			i++;
		if(i == bcde.length() ) return false;

		for(int j = 0; j < cd.length(); j++) {
			if( cd.charAt(j) != bcde.charAt(i) )
				return false;
			else {
				i++;
				if(i == bcde.length() - 1 && j < cd.length())
					return false;
			}
		}
		return true;
	}

	public static boolean isRotation_CorrectAnswer(String s1, String s2) {
		int len = s1.length();
		if(s2.length() == len) {
			return isSubstring_CorrectAnswer(s2, s1 + s1);//this takes n + 2n for contatenate s1 w/ s1. O(n);
		}
		return false;
	}
	public static boolean isSubstring_CorrectAnswer(String s1, String s2) {
		return s2.contains(s1);
	}
}