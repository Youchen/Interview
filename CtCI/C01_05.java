/**
 * O(n)
 * 
 * StringBuffer
 * 		append()
 */
public class C01_05 {
	public String compressBad(String str) {
		if(str.length() <= 1) return str;
		
		//str.length() must >= 2;
		int count = 1;
		char cur;
		StringBuffer sb = new StringBuffer();

		cur = str.charAt(0);
		sb.append(cur);

		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == cur) {
				count++;
			}//if
			else {
				sb.append(String.valueOf(count));
				count = 1;
				cur = str.charAt(i);
				sb.append(cur);
			}//else
		}//for
		sb.append(String.valueOf(count));
		
		if(sb.toString().length() > str.length() ) return str;
		else
			return sb.toString();
	}//method
}//class
