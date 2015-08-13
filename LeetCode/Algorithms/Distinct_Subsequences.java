/**
 * O( s.length() * t.length() )
 * 
 * Note:
 *      initiliazation is not limited to set f[0][i] f[i][0].
 *          for this problem, you need to set f[0][0] individully.
 *  
 *      the Function processing, you need to consider it carefully.
 */



//Space O( s.length() * t.length() ) version
public class Solution {
    public int numDistinct(String s, String t) {
        //2015-06-07 16:50:12 pause 2015-06-07 16:52:09
        //resume 2015-06-07 17:18:59 pause 2015-06-07 17:46:27
        //resume 2015-06-07 18:11:52
        
        if( (s == null || s.length() == 0) && 
            (t == null || t.length() == 0) )
            return 1;
        
        int Slen = s.length(), Tlen = t.length();
        //f[i][j] is indicating the number of distinct subsequences of 
        //      first i char in S combined with first j char in T.
        int[][] f = new int[Slen + 1][Tlen + 1];
        
        //ini
        //f[i][0] = 1     f[0][j] = 0
        for(int i = 0; i <= Slen; i++)
            f[i][0] = 1;
        
        f[0][0] = 1;
        
        for(int j = 1; j <= Tlen; j++)
            f[0][j] = 0;
            
        //f[i][j] = f[i - 1][j - 1] + f[i - 1][j] // s[i] == t[j]
        //        = f[i - 1][j] // s[i] != t[j]
        for(int i = 0; i < Slen; i++){
            for(int j = 0; j < Tlen; j++){
                
                f[i + 1][j + 1] = f[i][j + 1];
                if( s.charAt(i) == t.charAt(j) )
                    f[i + 1][j + 1] += f[i][j];
                // else
                //     f[i + 1][j + 1] = f[i][j + 1];
                    
            }
        }
        return f[Slen][Tlen];
    }
}




//Space O( s.length() ) version
public class Solution {
    public int numDistinct(String s, String t) {
        //2015-06-07 16:50:12 pause 2015-06-07 16:52:09 2
        //resume 2015-06-07 17:18:59 pause 2015-06-07 17:46:27 27 min
        //resume 2015-06-07 18:11:52 - 2015-06-07 18:12:56 ( 30 min )
        
        if( (s == null || s.length() == 0) && 
            (t == null || t.length() == 0) )
            return 1;
        
        int Slen = s.length(), Tlen = t.length();
        //f[i][j] is indicating the number of distinct subsequences of 
        //      first i char in S combined with first j char in T.
        int[][] f = new int[2][Tlen + 1];
        
        //ini
        //f[i][0] = 1     f[0][j] = 0
        for(int i = 0; i <= 1; i++)
            f[i][0] = 1;
        
        f[0][0] = 1;
        
        for(int j = 1; j <= Tlen; j++)
            f[0][j] = 0;
            
        //f[i][j] = f[i - 1][j - 1] + f[i - 1][j] // s[i] == t[j]
        //        = f[i - 1][j] // s[i] != t[j]
        for(int i = 0; i < Slen; i++){
            for(int j = 0; j < Tlen; j++){
                
                f[ (i + 1) % 2 ][j + 1] = f[i % 2][j + 1];
                if( s.charAt(i) == t.charAt(j) )
                    f[(i + 1) % 2][j + 1] += f[i % 2][j];
                // else
                //     f[i + 1][j + 1] = f[i][j + 1];
                    
            }
        }
        return f[Slen % 2][Tlen];
    }
}