/**
 * Round 3
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if(s == null || s.length() <= 3 || s.length() >= 13)
            return res;
        
        helper(s, res, new String(), 3);
        return res;
    }
    private void helper(String s, ArrayList<String> res, String seg, int segTime){
        //2015-07-28 10:44:30 - 2015-07-28 10:51:33 (7 min)
        if(segTime == 0 && validSeg(s)){
            res.add(new String(seg) + s);
            return;
        }
        
        for(int i = 1; i <= 3 && i < s.length(); i++){
            String sub = s.substring(0, i);
            if(validSeg(sub))
                helper(s.substring(i), res, seg + sub + ".", segTime - 1);
        }
    }
    private boolean validSeg(String s){
        if(s.length() > 3 || s.length() == 0)
            return false;
        if(s.charAt(0) == '0')
            return s.equals("0");

        int value = Integer.parseInt(s);
        if(value > 255)
            return false;
        return true;
    }
}






/**
 * Round 2.1 - still have some bugs.
 * DO THIS AGAIN
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {//2015-05-05 13:20:44 - 2015-05-05 13:34:52 (14 min)
        ArrayList<String> res = new ArrayList<String>();
        if(s == null || s.length() <= 3 || s.length() >= 13)
            return res;
        
        helper(res, new String(), s, 3);
        return res;
    }
    private void helper(ArrayList<String> res, String temp, String s, int segTime){
        if(segTime == 0 && validSeg(s))
            res.add(temp + s);
        
        for(int i = 1; i <= 3 && i <= s.length(); i++){
            String sub = s.substring(0, i);
            if(! validSeg(sub))
                continue;
            else
                helper(res, temp + sub + ".", s.substring(i), segTime - 1);
        }
    }
    private boolean validSeg(String s){
        if(s.length() > 3 || s.length() == 0)
            return false;
        if(s.charAt(0) == '0')
            return s.equals("0");

        int value = Integer.parseInt(s);
        if(value > 255)
            return false;
        return true;
    }
}





/**
 * Round 2 - Cost so much time
 * DO THIS AGAIN
 */
public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {//2015-05-04 18:10:51 - 2015-05-04 23:20:36 (5h+)
        ArrayList<String> res = new ArrayList<String>();
        if(s == null || s.length() <= 3 || s.length() > 12)
            return res;
        
        helper(res, new String(), s, 3);
        return res;
    }
    private void helper(ArrayList<String> res, String temp, String s, int seg){
        if(seg == 0 && validIPseg(s) ){
            res.add(temp + s);
            return;
        }
        
        for(int i = 1; i <= 3 && i < s.length(); i++){
            String sub = s.substring(0, i);
            if(validIPseg(sub))
                helper(res, temp + sub + ".", s.substring(i), seg - 1);
        }
    }
    /**
     * 010, 0030, 000201 are ILligal
     */
    private boolean validIPseg(String sub){
        if(sub.charAt(0) == '0')
            return sub.equals("0");
        if(sub.length() > 3)
            return false;
            
        int num = Integer.parseInt(sub);
        if(num > 255)
            return false;
        return true;
    }
}




/**
 * O(?)
 * O(?)
 * 252 ms
 * 
 * Note: 
 *      This problem is different than the typical backtracking ones.
 *      Need to have a new structure to solve. (i.e. use count, temp...)
 */
public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {//17:55
        ArrayList<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0 || s.length() >= 13)//Ip address at most has 12 digits.
            return res;
        
        helper(res, "", s, 0);
        return res;
    }
    private void helper(ArrayList<String> res, String temp, String s, int count){
       if(count == 3 && validIP(s)){
           res.add(temp + s);
       }
       
       for(int i = 1; i <= 3 && i < s.length(); i++){
           String sub = s.substring(0, i);
           if(validIP(sub))
                helper(res, temp + sub + ".", s.substring(i), count + 1);
       }
    }
    private boolean validIP(String s){
        /**
         * It's should be aknowledged that "010", "001" "03" are all ILLEGAL!!!
         * 
         * Test case:
         *      Input:      "010010"
         *      Expected:	["0.10.0.10","0.100.1.0"]
         */
        if (s.charAt(0)=='0') return s.equals("0");//this line is very important!!!
        if(s.length() >= 4)
            return false;
        int intIP = Integer.parseInt(s);
        if(intIP >= 0 && intIP <= 255)
            return true;
        return false;
    }
}