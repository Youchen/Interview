/**
 * Round 2
 * DO THIS AGAIN
 * Note:
 *      since s is immutable, so just using char[] to solve.
 *      String trim()
 *      String replaceAll(String regex, String replacement)
 */
public class Solution {
    public String reverseWords(String s) {//2015-05-12 19:52:11 - 2015-05-12 20:09:18 (17 min)
        if(s == null || s.length() == 0)
            return s.trim();
            
        s = s.trim();
        s = s.replaceAll("\\s+", " ");
        return reverseWords(s.toCharArray());
    }
    public String reverseWords(char[] s){
        reverse(s, 0, s.length - 1);
        for(int i = 0, j = 0; j <= s.length; j++){
            if(j == s.length || s[j] == ' '){
                reverse(s, i, j - 1);
                i = j + 1;
            }
        }
        return String.valueOf(s);
    }
    public void reverse(char[] s, int start, int end){
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            
            start++;
            end--;
        }
        return;
    }
}





/**
 * Round 2
 * DO THIS AGAIN
 */
public class Solution {
    public String reverseWords(String s) {//2015-05-12 18:20:53 - 2015-05-12 18:39:24 (19 min)
        if(s == null || s.length() == 0)
            return s;
        s = s.trim();
        
        s = reverse(s, 0, s.length() - 1);
        //every word reverse
        int start = 0;
        while(true){
            int end = s.indexOf(' ', start);
            if(end == -1)
                break;
            s = reverse(s, start, end - 1);
            while(s.charAt(end) == ' '){
                start = end + 1;
                end++;
            }
        }
        //reverse the last segment.
        return reverse(s, start, s.length() - 1).replaceAll(" +", " ");
    }
    private String reverse(String s, int start, int end){
        char[] sArr = s.toCharArray();
        while(start < end){
            char temp = sArr[start];
            sArr[start] = sArr[end];
            sArr[end] = temp;
            
            start++;
            end--;
        }
        return String.valueOf(sArr);
    }
}









/**
 * O(n)
 * O(n + n) = O(n)
 * 540 ms
 * 
 * Note:
 *      Simple one.
 */
public class Solution {
    public String reverseWords(String s) {//4/19 00:56 - 1:10 (14 min)
        if(s == null || s.length() <= 0)
            return s;
            
        s = s.trim();
        
        String res = "", word = "";
        int p = 0;
        while(p < s.length()){
            while(p < s.length() && s.charAt(p) == ' ')
                p++;
            while(p < s.length() && s.charAt(p) != ' '){
                word += s.charAt(p);
                p++;
            }
            res = word + res;
            res = " " + res;
            word = "";
        }
        
        res = res.trim();
        return res;
    }
}