/**
 * Round 2 - 8 min
 *
 */
class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        //2015-05-08 23:56:02 - 2015-05-09 00:04:23 (8 min)
        if(source == null || target == null)
            return -1;
            
        int sLen = source.length(), tLen = target.length();
        if(sLen < tLen)
            return -1;
        if(tLen == 0)//t is "";
            return 0;
            
        for(int i = 0; i <= sLen - tLen; i++){
            
            for(int j = 0; j < tLen; j++){
                if(source.charAt(i + j) != target.charAt(j))
                    break;
                
                if(source.charAt(i + j) == target.charAt(j) && j == tLen - 1)
                    return i;
            }
        }
        return -1;
    }
}









class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        // write your code here
        //2015-05-05 19:14:29 - 19:23 (9 min)
        if(source == null || target == null)
            return -1;
            
        if(target.length() > source.length())
            return -1;
        
        int j = 0;
        for(int i = 0; i < source.length() - target.length() + 1; i++){
            
            for(j = 0; j < target.length(); j++){
                if(source.charAt(i + j) != target.charAt(j))
                    break;
            }
            if(j == target.length())
                return i;
        }
        
        return -1;
    }
}

