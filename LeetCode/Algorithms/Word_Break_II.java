/**
 * Still cannot get.
 *
 * Reference
 *      https://leetcode.com/discuss/27464/my-concise-answer
 */
public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        
        for(int j = s.length() - 1; j >= 0; j--){
            if(dict.contains(s.substring(j)))
                break;
            else{
                if(j == 0)
                    return result;
            }
        }

        for(int i = 0; i < s.length()-1; i++)
        {
            if(dict.contains(s.substring(0,i+1)))
            {
                List<String> strs = wordBreak(s.substring(i+1,s.length()),dict);
                if(strs.size() != 0)
                    for(Iterator<String> it = strs.iterator();it.hasNext();)
                    {
                        result.add(s.substring(0,i+1)+" "+it.next());
                    }
            }
        }
        if(dict.contains(s)) result.add(s);
        return result;
    }
}






/**
 * My solution is TLE
 *
 * Code Ganker Reference:
 *      http://blog.csdn.net/linhuanmars/article/details/22452163
 */
//*************************************** TLE **************************************************
public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> wordDict) {
        //2015-05-24 16:10:53 pause 2015-05-24 16:14:10
        //2015-07-06 00:20:04 - 2015-07-06 00:41:37 (TLE);
        
        ArrayList<String> res = new ArrayList<String>();
        if(
            ((s == null || s.length() == 0) && !wordDict.isEmpty()) ||
            ((s != null || s.length() != 0) && wordDict.isEmpty())
            )
            return res;
            
        wordBreakHelper(s, wordDict, new ArrayList<String>(), res);
        return res;
    }
    private void wordBreakHelper(String s, Set<String> wordDict, ArrayList<String> candidate, ArrayList<String> res){
        if(wordDict.contains(s)){
            if( ! candidate.isEmpty()){
                //res.add(candidate) + s
                String temp = candidate.get(0);
                for(int i = 1; i < candidate.size(); i++){
                    temp = temp + " " + candidate.get(i);
                }
                temp = temp + " " + s;
                res.add(temp);
            }else
                res.add(s);
                
            return;
        }
        
        
        for(int i = 0; i < s.length(); i++){
            String word = s.substring(0, i + 1);
            
            if(wordDict.contains(word)){
                candidate.add(word);
                wordBreakHelper(s.substring(i + 1), wordDict, candidate, res);
                candidate.remove(candidate.size() - 1);
            }
        }
        
        
    }
}











/**
 * Reference
 *      http://www.jiuzhang.com/solutions/word-break-ii/
 */
public class Solution{
    public ArrayList<String> wordBreak(String s, Set<String> dict){
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        return wordBreakHelper(s, dict, map);
    }

    public ArrayList<String> wordBreakHelper(String s, Set<String> dict, Map<String, ArrayList<String>> memo){
        if(memo.containsKey(s))
            return memo.get(s);

        ArrayList<String> res = new ArrayList<String>();
        int len = s.length();
        if(len <= 0)
            return res;

        for(int i = 1; i <= len; i++){
            String subfix = s.substring(0, i);

            if(dict.contains(subfix)){
                if(i == len)
                    res.add(subfix);
                else{
                    String prefix = s.substring(i);
                    ArrayList<String> tmp = wordBreakHelper(prefix, dict, memo);

                    for(String item : tmp){
                        item = subfix + " " + item;
                        res.add(item);
                    }
                }
            }
        }

        memo.put(s, res);
        return res;
    }
}