/**
 *
 * Eye-Review
 */
public class Solution{
    public int minCut(String s){
        if(s == null || s.length() <= 1)
            return 0;

        //ini
        int[] cut = new int[s.length()];
        boolean[][] isPa = getIsP(s);

        cut[0] = 0;//first char needs 0 cut to become palindrome.

        //f[i] = min ( min(f[j]) (j < i, s[j + 1, i] is palindrome), 
        //              f[j] + 1 )
        //function: f[i] = MIN{f[j]+1}, j < i && j+1 ~ i这一 段是一个回文串
        
        for(int i = 1; i < s.length(); i++){
            //s[i] needs at most i cut to become palindrome.
            cut[i] = i;
            
            if(isPa[0][i]){
                cut[i] = 0;
                continue;
            }
                
            for(int j = 1; j <= i; j++)
                if(isPa[j][i])
                    cut[i] = Math.min(cut[i], cut[j - 1] + 1);
        }
        
        return cut[cut.length - 1];
    }
    
    private boolean[][] getIsP (String s){
        int len = s.length();
        boolean[][] dict = new boolean[len][len];
    
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                if( s.charAt(i) == s.charAt(j)  && ( j - 2 <= i || dict[i + 1][j - 1] )
                    )
                    dict[i][j] = true;
            }
        }
        return dict;
    }
}






/**
 * Round 2
 * O(n^2)
 * O(n^2)
 * Cost so much time
 * DO THIS AGAIN.
 * 
 * Note:
 *      declare cut[s.length()] is ok. no need for cut[s.length() + 1]
 *      
 *      getDict:
 *          you need to use i traverse from back to the beginning
 *          use j to traverse from i to the end.
 * 
 *      need to add a line between two for loops.
 *      if(isPa[0][i]) cut[i] = 0;
 */
public class Solution{
    public int minCut(String s){
        //2015-06-04 12:34:20 pause 2015-06-04 12:38:54
        //resume 2015-06-05 14:51:22 pause 2015-06-05 15:20:38
        //resume 2015-06-05 17:22:01 - 2015-06-06 18:25:55
        if(s == null || s.length() <= 1)
            return 0;

        //ini
        int[] cut = new int[s.length()];
        boolean[][] isPa = getIsP(s);

        cut[0] = 0;//first char needs 0 cut to become palindrome.

        //f[i] = min ( min(f[j]) (j < i, s[j + 1, i] is palindrome), 
        //              f[j] + 1 )
        //function: f[i] = MIN{f[j]+1}, j < i && j+1 ~ i这一 段是一个回文串
        
        for(int i = 1; i < s.length(); i++){
            //s[i] needs at most i cut to become palindrome.
            cut[i] = i;
            
            if(isPa[0][i]) cut[i] = 0;
            for(int j = 1; j <= i; j++){
                
                if(isPa[j][i] )
                    cut[i] = Math.min(cut[i], cut[j - 1] + 1);

            }
        }
        return cut[cut.length - 1];
    }
    private boolean[][] getIsP (String s){
        int len = s.length();
        boolean[][] dict = new boolean[len][len];
    
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                if( s.charAt(i) == s.charAt(j)  && ( j - 2 <= i || dict[i + 1][j - 1] )
                    )
                    dict[i][j] = true;
            }
        }
        return dict;
    }
}










/**
 * Cost lots of time.
 * DO THIS AGAIN!
 */
public class Solution{
    public int minCut(String s){
        if(s == null || s.length() == 0)
            return 0;

        int[] cut = new int[s.length() + 1];
        boolean[][] isPa = getIsP(s);

        cut[0] = 0;
        for(int i = 1; i <= s.length(); i++){
            cut[i] = Integer.MAX_VALUE;
            for(int j = 1; j <= i; j++){
                if(isPa[i - j][i - 1] && cut[i - j] != Integer.MAX_VALUE){
                    cut[i] = Math.min(cut[i], cut[i - j] + 1);
                }
            }
        }
        return cut[s.length()] - 1;

    }

    private boolean[][] getIsP(String s){
        int len = s.length();
        boolean[][] isP = new boolean[len][len];

        for(int i = 0; i < len; i++)
            isP[i][i] = true;

        for(int i = 0; i < len - 1; i++)
            isP[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));

        for(int length = 2; length < len; length++){
            for(int start = 0; start + length < len; start++){
                isP[start][start + length]
                    = isP[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }
        return isP;
    }
}






/**
 * O(n^2)
 * O(n^2)
 * TLE
 */
public class Solution {
    public int minCut(String s) {
        //2015-05-23 15:30:31 - 2015-05-23 15:42:50 (TLE) pause 2015-05-23 15:55:42
        //"" is palindrome as well.
        if(s == null || s.length() == 0)
            return 0;
        
        //minCut[i] is the minCut in position s[i]
        //to generate the palindrome. INCLUSIVE
        int[] minCut = new int[s.length()];
        
        //ini
        minCut[0] = 0;
        boolean[][] palinMemo = new boolean[s.length()][s.length()];
        
        //function
        for(int i = 1; i < minCut.length; i++){
            int tempMin = Integer.MAX_VALUE;
            
            if(isPalindrome(s, 0, i, palinMemo)){
                   minCut[i] = 0;
                   continue;
            }
                
            for(int j = 0; j < i; j++){
                
                if(isPalindrome(s, j + 1, i, palinMemo))
                  tempMin = Math.min(tempMin, minCut[j] + 1);
            }
            
            minCut[i] = tempMin;
        }
        return minCut[s.length() - 1];
    }
    
    public boolean isPalindrome(String s, int start, int end, boolean[][] palinMemo){
        if(start == end)
            return true;
            
        int startCopy = start, endCopy = end;
        while(start < end){
            if(palinMemo[start][end] == true)
                return true;
                
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        palinMemo[startCopy][endCopy] = true;
        return true;
    }
    
}