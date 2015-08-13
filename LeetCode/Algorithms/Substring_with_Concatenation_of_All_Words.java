/**
 * O(n^2) ? O(n)?
 * O(n)
 * 
 * Note:
 *      Not so hard, just be careful, you will get it!
 * 
 * Reference:
 *      http://blog.csdn.net/linhuanmars/article/details/20342851
 *      I did not copy the reference or even get the idea from it.
 *      You may take a look at this post, Seems he has the same idea with my algorithm.
 *      I don't know.
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        //2015-06-03 23:24:26 - 2015-06-04 00:12:44 ( 48 min )
        List<Integer> al = new ArrayList<Integer>();
        if(
            (s == null || s.length() == 0) && (words == null || words.length == 0)
            )
            return al;
        
        int eachLen = words[0].length();
        int concaLen = words.length * eachLen;
        
        HashMap<String, Integer> hs = new HashMap<String, Integer>();
        for(String ss : words){
            if(! hs.containsKey(ss))
                hs.put(ss, 1);
            else
                hs.put(ss, hs.get(ss) + 1);
        }
        
        for(int i = 0, j; i <= s.length() - concaLen; i++){
            HashMap<String, Integer> curHs = new HashMap<String, Integer>();
            
            for(j = i; j <= i + concaLen - eachLen; j += eachLen ){
                String wordSeg = s.substring(j, j + eachLen);
                
                if(! hs.containsKey(wordSeg) )//wordSeg is not in dic || # wordSeg == 0
                    break;
                    
                //wordSeg is inside the dic
                else if( curHs.containsKey(wordSeg) ){
                    curHs.put(wordSeg, curHs.get(wordSeg) + 1);
                    
                    if( curHs.get(wordSeg) > hs.get(wordSeg) )
                        break;
                    // j += eachLen;
                }
                else{
                    //# wordSeg -- && j = j + eachLen
                    curHs.put(wordSeg, 1);
                    // j += eachLen;
                }
                    
            }
            if(j == i + concaLen)
                al.add(i);
        }
        return al;   
    }
}