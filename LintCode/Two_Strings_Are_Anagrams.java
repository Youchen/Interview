public class Solution {
    public boolean anagram(String s, String t) {
        //2015-05-25 23:33:51
        if((s == null && t != null) || (s != null && t == null)
            || s.length() != t.length())
            return false;

        char [] sSorted = s.toCharArray();
        Arrays.sort(sSorted);
        char [] tSorted = t.toCharArray();
        Arrays.sort(tSorted);
        
        int index = 0;
        for(char c: sSorted){
            if(tSorted[index++] != c)
                return false;
        }
        return true;
    }
};

