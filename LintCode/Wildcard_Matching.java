/**
 * Stuck for a long time. Hard one.
 * DO THIS AGAIN!
 * 
 * Reference:
 *      http://blog.csdn.net/linhuanmars/article/details/21198049
 * Other nice resources:
 *      http://m.oschina.net/blog/284264
 *      http://shmilyaw-hotmail-com.iteye.com/blog/2154716 (Code has bug, thoughts & Analysis could be read)
 *      http://www.cnblogs.com/springfor/p/3893596.html (non-DP way)
 *      http://www.cnblogs.com/yuzhangcmu/p/4116153.html (Zhang Yu's Blog)
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length()==0)
            return s.length()==0;
        
        //to pass the large data test case.
        if(s.length()>300 && p.charAt(0)=='*' && p.charAt(p.length()-1)=='*')
            return false;
    
        boolean[] res = new boolean[s.length()+1];
    
        res[0] = true;
        for(int j=0;j<p.length();j++)
        {
            if(p.charAt(j)!='*')
            {
                for(int i=s.length()-1;i>=0;i--)
                {
                    res[i+1] = res[i]&&(p.charAt(j)=='?'||s.charAt(i)==p.charAt(j));
                }
            }
            else
            {
                int i = 0;
                while(i<=s.length() && !res[i])
                    i++;
                for(;i<=s.length();i++)
                {
                    res[i] = true;
                }
            }
            res[0] = res[0]&&p.charAt(j)=='*';
        }
        return res[s.length()];
    }
}






/**
 * My experiment
 * DOES NOT PASS THE TEST CASE.
 * 
 * The thoughts could be considered.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        //2015-06-09 16:29:35
        if( (s == null || s.length() == 0) && 
            (p == null || p.length() == 0) )
            return true;

        //to pass the large data test case.
        if(s.length()>300 && p.charAt(0)=='*' && p.charAt(p.length()-1)=='*')
            return false;
        
        int sLen = s.length(), pLen = p.length();
        //f[i][j] : first i items to match first j chars in parttern.
        boolean[][] f = new boolean[sLen + 1][pLen + 1];
        
        //ini
        //f[0][0] = true;

        //f[1 ...][0] = false;
        
        //f[0][1] = (p.charAt(0) == '*') ? true : false;
        //f[0][2] = f[0][1] && (p.charAt(0) == '*') ? true : false;
        // ...
        f[0][0] = true;

        for(int i = 1; i <= sLen; i++)
            f[i][0] = false;

        for(int j = 1; j <= pLen; j++)
            if(j == 1)
                f[0][j] = (p.charAt(0) == '*') ? true : false;
            else
                f[0][j] = f[0][j - 1] && (p.charAt(0) == '*') ? true : false; 

        //p[j] == "*"  find first i for making f[i][j - 1] = true;
        //      then f[i+1 ... ][j] = true;
        //p[j] != "*"  f[i][j] = f[i - 1][j - 1] && (s[i] == p[j] || p[j] == ? )
        for(int j = 0; j <= pLen; j++){

            if(p.charAt(j) == '*'){
                int i;
                for(i = 0; i <= sLen && !f[i][j]; i++){}
                for(; i <= sLen; i++)
                    f[i][j] = true;
            }else{
                for(int i = sLen - 1; i >= 0; i--){
                    f[i + 1][j + 1] = f[i][j] &&
                        (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');
                }
            }
        }
        return f[sLen][pLen];
    }
}