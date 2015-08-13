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
