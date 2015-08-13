/**
 * O(n)
 * 
 * StringBuffer
 * 		append(), toString();
 * String	
 */
public class C01_04 {
	public void replaceSpace(char[] str, int len) {
		StringBuffer s = new StringBuffer();
		for(int i = 0; i < len; i++) {
			if(str[i] == ' ')
				s.append("%20");
			else
				s.append(str[i]);
		}
		str = s.toString().toCharArray();
	}
}
