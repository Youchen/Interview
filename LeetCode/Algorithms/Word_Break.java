/**
 * Round 2
 * O(n^2)
 * O(n)
 * 
 * Note:
 *      DO THIS AGAIN.
 *      This algorithm is so nice.
 */
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        //2015-06-03 22:43:37 - 2015-06-03 22:50:36 (7 min)
        if(s == null || s.length() == 0)
            return true;
        
        int sLen = s.length();
        //f[i] is claiming that s[0, i] can be break.
        boolean[] canBreak = new boolean[sLen + 1];
        canBreak[0] = true;
        
        //f[i] = f[j] && s[j + 1, i] can be break.
        for(int i = 0; i < sLen; i++){
            StringBuilder sb = new StringBuilder(s.substring(0, i + 1));
            
            for(int j = 0; j <= i; j++){
                if( canBreak[j] && wordDict.contains(sb.toString()) ){
                    canBreak[i + 1] = true;
                    break;
                }
                sb.deleteCharAt(0);
            }
        }
        return canBreak[sLen];
    }
}












/**
 * O(n^2)
 * O(n) which n is the length of String.
 * 
 * Note:
 *      Very tricky on the marked line below.
 *      Pay attention to the index!!
 */
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        //2015-05-24 14:48:04 pause 2015-05-24 15:20:46 resume 2015-05-24 15:45:05 - 2015-05-24 15:51:59
        //28 min
        if(
            ((s == null || s.length() == 0) && ! wordDict.isEmpty())
            || (wordDict.isEmpty() && (s != null || s.length() != 0))
            )
            return false;
            
        //state
        boolean[] firstIcouldBCut = new boolean[s.length() + 1];
        
        //ini
        firstIcouldBCut[0] = true;
        
        //function
        //f[i] = f[j] && j + 1 - i is a word
        for(int i = 1; i <= s.length(); i++){
            
            for(int j = 0; j < i; j++){
                String jADD1_i = s.substring(j, i);//<=============== here is very tricky!!
                if(firstIcouldBCut[j] && isWord(jADD1_i, wordDict)){
                    firstIcouldBCut[i] = true;
                    break;
                }
            }
        }
        //ans
        return firstIcouldBCut[s.length()];
    }
    private boolean isWord(String s, Set<String> wordDict){
        if(s.length() == 0)
            return true;
        return wordDict.contains(s);
    }
}