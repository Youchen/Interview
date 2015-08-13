/**
 * Round 3
 * First try to solve by DP. FAILED.
 * 
 * How to decide using DP?
 *      1. One of the following three
 *          a) Maximum/Minimum
 *          b) Yes/No 
 *          c) Count(*)
 *      2. Can not sort / swap
 * 
 * All possible ... You need to think about searching!
 */
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        //2015-06-12 10:21:53 pause 2015-06-12 10:37:00
        //resume 2015-06-12 10:59:25 (20 min using dp failed)
        //refresh 2015-06-12 11:03:04 - 2015-06-12 11:14:59 ( 11 min )
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if(s == null || s.length() == 0)
            return res;
        
        partitionHelper(s, res, new ArrayList<String>(), 0);
        return res;
    }
    private void partitionHelper(String s, ArrayList<ArrayList<String>> res,
                                    ArrayList<String> list, int pos){
        if(pos == s.length()){
            res.add(new ArrayList<String>(list));
            return;
        }
        
        for(int i = pos; i < s.length(); i++){
            String sub = s.substring(pos, i + 1);
            
            if(isPalindrome(sub)){
                list.add(sub);
                partitionHelper(s, res, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}









/**
 * Round 2 - still cannot get it.
 * DO THIS AGAIN.
 * 
 * Note:
 *      the breaking order is like for example:
 * 
 *      abcc:
 * 
 *      a | bcc     a | b | cc      a | b | c | c (OK)
 *      ab | cc     ab | c | c (X)
 *      abc | c (X)
 * 
 * 
 *      aab:
 * 
 *      a | ab      a | a | b (OK)
 *      aa | b (OK)
 * 
 */
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {//2015-05-04 14:07:00 pause 14:30 resume 15:00 - 2015-05-04 17:52:31 (3h+)
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if(s == null || s.length() == 0)
            return res;
        
        helper(res, new ArrayList<String>(), s, 0);
        return res;
    }
    
    private void helper(ArrayList<ArrayList<String>> res, ArrayList<String> list, String s, int pos){
        if(pos == s.length())
            res.add(new ArrayList<String>(list));
        
        for(int i = pos + 1; i < s.length() + 1; i++){
            String sub = s.substring(pos, i);
            
            if(! isPalindrome(sub))
                continue;
            
            list.add(sub);
            helper(res, list, s, i);
            list.remove(list.size() - 1);
        }
        
    }
    
    private boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}







/**
 * suppose s.length() = n;
 * O(1Cn + 2Cn + 3Cn + ... + nCn) = O(2^n - 1)
 * O(n)
 * 261 ms
 *
 * Note:
 *      for the proof of the time complexity equation.
 *      think the case when x = 1 in following equation:
 *          (1 + x)^n = nC0*x^0 + nC1*x + nC2*x^2 + nC3*x^3 + .... + nC(n-1)*x^(n-1) + nCn * x^n
 *                2^n = 1 + nC1 + nC2* + nC3* + .... + nC(n-1) + nCn
 */
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if(s == null || s.length() == 0) return res;
        
        //s is not null && s.length() >= 1
        helper(res, new ArrayList<String>(), s, 0);
        return res;
    }
    private void helper(ArrayList<ArrayList<String>> res, ArrayList<String> list, String s, int pos){
        if(pos == s.length()){
            res.add(new ArrayList<String>(list));
            return;
        }
        for(int i = pos + 1; i <= s.length(); i++){//be careful with equal sign in "i <= s.length()"
            String sub = s.substring(pos, i);
            
            if(! isP(sub)) continue;
            
            list.add(sub);
            helper(res, list, s, i);//here, since the initial value of i in for loop is "pos + 1", no need to have "i + 1" here.
            list.remove(list.size() - 1);
        }
    }
    private boolean isP(String s){
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}