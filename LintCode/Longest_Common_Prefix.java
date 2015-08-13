public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        //2015-05-26 16:43:22 - 2015-05-26 17:13:12 (30 min)
        if(strs == null || strs.length == 0)
            return "";
        
        if(strs.length == 1)
            return strs[0];
        
        //strs at least have 2 element.
        int index = 0;
        String lcp = "";
        
        while(true){
            for(int i = 1; i < strs.length; i++){
                
                if(index >= strs[i - 1].length() || index >= strs[i].length() ||
                    strs[i - 1].charAt(index) != strs[i].charAt(index)  )
                    return lcp;
                    
                else if(i == strs.length - 1){
                    lcp += strs[i].charAt(index);
                    // index++;
                }
            }
            index++;
        }   
    }
}

