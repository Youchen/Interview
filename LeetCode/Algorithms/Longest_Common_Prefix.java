public class Solution {
    public String longestCommonPrefix(String[] strs) {
        //2015-05-26 17:32:12 - 2015-05-26 17:50:14 (18 min)
        if(strs == null || strs.length == 0)
            return "";
    
        String candidate = strs[0];
            
        for(int i = 1; i < strs.length; i++){
            int j = 0;
            while(j < candidate.length() && j < strs[i].length() &&
                    strs[i].charAt(j) == candidate.charAt(j))
                j++;
            if(j == 0)
                return "";
            //0 1 2 3
            candidate = candidate.substring(0, j);
        }
        return candidate;
    }
}