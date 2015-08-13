/**
 * Cost so much time.
 * DO THIS AGAIN.
 * 
 * Reference:
 *      http://www.programcreek.com/2012/12/leetcode-regular-expression-matching-in-java/
 * 
 * Analysis:
 * First of all, this is one of the most difficulty problems. 
 *      It is hard to think through all different cases. 
 *      The problem should be simplified to handle 2 basic cases:
 * 
 *      the second char of pattern is "*"
 *      the second char of pattern is not "*"
 * 
 * For the 1st case, 
 *      if the first char of pattern is not ".", 
 *          the first char of pattern and string should be the same. Then continue to match the remaining part.
 * 
 * For the 2nd case, 
 *      if the first char of pattern is "." or first char of pattern == the first i char of string, 
 *          continue to match the remaining part.
 * 
 */
public class Solution{
    public boolean isMatch(String s, String p){
        //2015-07-18 20:26:12 - 2015-07-18 22:19:07 (approx. 2h )
        if(p.length() == 0)
            return s.length() == 0;

        if(p.length() == 1){
            if(p.charAt(0) == '.'){
                if(s.length() == 0 || s.length() >= 2)
                    return false;
                return true;//s.length() == 1
            }
            else{//p is a char
                if(s.length() == 1 && s.equals(p))
                    return true;
                return false;
            }
        }

        if(p.charAt(1) != '*'){
            if(s.length() == 0)
                return false;

            if( p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')
                return isMatch(s.substring(1), p.substring(1) );
            else
                return false;
        }else{
            //   [(char)*]   could be counted as 0 element
            if(isMatch(s, p.substring(2)))
                return true;

            //   [(char)*]   could be counted as 1 or more element
            int i = 0;
            while(i <= s.length() - 1 &&
                    (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')
                 ){
                if(isMatch(s.substring(i + 1), p.substring(2)) )
                    return true;
                i++;
            }
            return false;
        }

    }
}