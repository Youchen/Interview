/**
 * DO THIS AGAIN
 */
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        //2015-07-10 14:47:42 - 2015-07-10 15:04:42 (17 min)
        if(s == null || t == null || Math.abs( s.length() - t.length() ) >= 2 )
            return false;
        
        int slen = s.length(), tlen = t.length();
        for(int i = 0; i < Math.min(slen, tlen); i++){
            //if they have diff length
            if(s.charAt(i) != t.charAt(i)){
                if(slen > tlen)
                    return s.substring(i + 1).equals(t.substring(i));
                else if(slen < tlen)
                    return s.substring(i).equals(t.substring(i + 1));
                else
                    return s.substring(i + 1).equals(t.substring(i + 1));
            }
        }
        //if they have the same length.
        return Math.abs(slen - tlen) == 1;
    }
}