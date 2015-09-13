public class Solution {
    public boolean canPermutePalindrome(String s) {
        //2015-09-13 17:12:59 pause 2015-09-13 17:13:54
        //2015-09-13 17:16:30 - 2015-09-13 17:20:02 (5 min)
        if(s == null || s.length() == 0)
            return true;
        
        HashSet<Character> charSet = new HashSet<Character>();
        for(char c : s.toCharArray()){
            if(charSet.contains(c))
                charSet.remove(c);
            else
                charSet.add(c);
        }
        
        if(s.length() % 2 == 0)
            return charSet.isEmpty();
        else
            return charSet.size() == 1;
    }
}