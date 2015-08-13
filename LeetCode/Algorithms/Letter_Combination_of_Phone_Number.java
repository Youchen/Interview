/**
 * Round 4
 */
public class Solution{
    public ArrayList<String> letterCombinations(String digits){
        //2015-07-27 23:39:16 pause 2015-07-27 23:52:10
        //2015-07-28 09:55:27 - 2015-07-28 10:06:30 (24 min)
        ArrayList<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0)
            return res;

        String[] buttons = {
            " ", 
            "", "abc", "def", 
            "ghi", "jkl", "mno", 
            "pqrs", "tuv", "wxyz"
        };

        lcHelper(digits, res, new String(), buttons, 0);
        return res;
    }
    public void lcHelper(String digits, ArrayList<String> res, String list, String[] buttons, int digitsIndex){
        if(list.length() == digits.length()){
            res.add(new String(list));
            return;
        }
        String letters = buttons[digits.charAt(digitsIndex) - '0'];

        for(int i = 0; i < letters.length(); i++){
            list += letters.charAt(i);
            lcHelper(digits, res, list, buttons, digitsIndex + 1);
            list = list.substring(0, list.length() - 1);
        }
    }
}





/**
 * Round 3 - still cannot get it right without seeing the solution.
 * DO THIS AGAIN.
 * 
 * Note:
 *      Confused by the digits conversion to letters
 *      thought it should has double for-loops.
 */
public class Solution {
    public ArrayList<String> letterCombinations(String digits) {//2015-05-05 17:02:55 pause 17:24 resume 17:50
        ArrayList<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0)
            return res;
        
        String[] pad = {
            " ", 
            "", "abc", "def", 
            "ghi", "jkl", "mno", 
            "pqrs", "tuv", "wxyz"
        };
        helper(res, new String(), digits, pad, 0);
        return res;
    }
    private void helper(ArrayList<String> res, String list, String digits, String[] pad, int pos){
        if(list.length() == digits.length()){
            res.add(new String(list));
            return;
        }
        
        String letters = pad[digits.charAt(pos) - '0'];
        for(int i = 0; i < letters.length(); i++){
            list += letters.charAt(i);
            helper(res, list, digits, pad, pos + 1);
            list = list.substring(0, list.length() - 1);
        }
    }
}





/**
 * Round 2 - 3/27
 */
public class Solution {
    public ArrayList<String> letterCombinations(String digits){
        ArrayList<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0)
            return res;
    
        String[] pad = {
            " ", 
            "", "abc", "def", 
            "ghi", "jkl", "mno", 
            "pqrs", "tuv", "wxyz"
        };
        helper(res, "", pad, digits, 0);
        return res;
    }
    // private void helper(ArrayList<String> res, String list, String[] pad, String digits, int pos){
    //  if(list.length() == digits.length() ){
    //      res.add(new String(list));
    //      return;
    //  }
    
    //  String letters = pad[digits.charAt(pos) - '0'];
    //  for(int i = 0; i < letters.length(); i++){
    //      list +=  letters.charAt(i);
    //      helper(res, list, pad, digits, pos + 1);
    //      list = list.substring(0, list.length() - 1);
    //  }
    // }
    
    
    //2nd round Mar 27 - 12:32 - 12:40
    private void helper(ArrayList<String> res, String sub, String[] pad, String digits, int pos){
        if(sub.length() == digits.length()){
            res.add(new String(sub));
            return;
        }
        String letters = pad[digits.charAt(pos) - '0'];
        for(int i = 0; i < letters.length(); i++){
            sub += letters.charAt(i);
            /**
              * Notes on "pos + 1":
              * Since every recursion step, you need to pass the next position of
              *         the ORIGINAL String instead of the next position of the letters.
              */
            helper(res, sub, pad, digits, pos + 1);
            sub = sub.substring(0, sub.length() - 1);
        }
    }
}









/**
 * O(?)
 * O(?)
 * 192 ms
 * 
 * Note:
 *      Try to understand it again!
 */
public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0)
            return res;
            
        String[] pad = new String[]{
            	" ", 
            	"", "abc", "def", 
            	"ghi", "jkl", "mno", 
            	"pqrs", "tuv", "wxyz"
        };
        helper(res, digits, "", pad, 0);
        return res;
    }
    private void helper(ArrayList<String> res, String digits, String list, String[] pad, int pos){
        if(list.length() == digits.length()){
            res.add(new String(list));
            return;//Here is very important!!! must return!
        }
        
        String letter = pad[digits.charAt(pos) - '0'];
        for(int i = 0; i < letter.length(); i++){
            list += letter.charAt(i);
            helper(res, digits, list, pad, pos + 1);
            list = list.substring(0, list.length() - 1);
        }
    }
}