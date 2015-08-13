/**
 * learn how to reverse each word which separate by ' '
 * 
 *      int start = 0;
 *      for(int i = 0; i < s.length; i++){
 *          if(s[i] == ' '){
 *             reverse(s, start, i - 1);
 *             start = i + 1;
 *          }
 *      }
 * 
 * Reference:
 *    https://leetcode.com/discuss/24227/my-java-solution-with-explanation
 */
public class Solution {
    public void reverseWords(char[] s) {
        //2015-06-29 17:50:06 - 2015-06-29 18:13:29 (23 min)
        if(s == null || s.length == 0)
            return;
        
        //reverse entire sentence
        reverse(s, 0, s.length - 1);
        
        //reverse every words.
        int start = 0;
        for(int i = 0; i < s.length; i++){
            if(s[i] == ' '){
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        
        //for the last word
        reverse(s, start, s.length - 1);
        
        return;
    }
    private void reverse(char[] s, int start, int end){
        while(start < end){
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}