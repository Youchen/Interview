/**
 * O(n)
 * O(n)
 * 
 * Nice idea.
 * Do This Again.
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        //2015-06-24 23:38:23 - 2015-06-24 23:40:17 (2 min)
        
        int[] sArr = new int[128];
        int[] tArr = new int[128];
        
        for(int i = 0; i < s.length(); i++){
            if( sArr[ s.charAt(i) ] != tArr[ t.charAt(i) ] )
                return false;
            sArr[ s.charAt(i) ] = tArr[ t.charAt(i) ] = i + 1;
        }
        
        return true;
    }
} 
        
        
        
        
/**  Fail the last test case. **/
// public class Solution {
    // public boolean isIsomorphic(String s, String t) {
        //2015-06-24 22:39:55 pause 2015-06-24 23:00:10
        // if(s.length() == 1)
        //     return true;
            
        
        // int len = s.length();
        
        // for(int sp = 1, tp = 1; sp <= len - 1; sp++, tp++){
        //     if(sp == len - 1 && tp != t.length() - 1)
        //         return false;
        //     if(sp != len - 1 && tp == t.length() - 1)
        //         return false;
            
        //     if(s.charAt(sp) == s.charAt(sp - 1) && 
        //         t.charAt(tp) != t.charAt(tp - 1) )
        //             return false;
                    
        //     else if(s.charAt(sp) != s.charAt(sp - 1) &&
        //             t.charAt(tp) == t.charAt(tp - 1) )
        //             return false;
        // }
        // return true;
//     }
// }