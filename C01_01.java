/**
 * O(1)
 * 		all the answers said it's O(n), but I figured that
 * 			it will at most spend O(1) time complexity since
 * 			the char set is a defined number, like it's at most 
 * 			128 for ASCII.
 * #1
 * HashSet
 * 		constructor
 * 		add() //return boolean
 * String
 * 		toCharArray();
 * 
 * #2
 * Array
 * char
 * 		int(char) could get ASCII code for this char
 * String
 * 		toCharArray();
 */
import java.util.HashSet;
public class C01_01 {
	public static boolean allCharUnique(String str) {
		HashSet<Character> hs = new HashSet<Character>();
		for(char c: str.toCharArray())
			if( ! hs.add(c)) return false;
		return true;
	}
	public static boolean allCharUnique_NoDataStruc(String str) {
		boolean[] flag = new boolean[128];
		for(int i = 0; i < flag.length; i++)
			flag[i]= false;
		
		for(char c: str.toCharArray()) {
			if (flag[(int)c] == true) 
				return false;
			else
				flag[(int)c] = true;
		}
		return true;
	}
}