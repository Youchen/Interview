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