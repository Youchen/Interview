/**
 * O(n * n * L * 26) ?
 * O(dict.length) ?
 * 
 * Note:
 *      This is graph BFS problem.
 * 
 * DO THIS AGAIN.
 * 
 * Reference:
 *      http://blog.csdn.net/linhuanmars/article/details/23029973
 */
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        //2015-06-15 15:00:18 - 2015-06-15 15:10:08 (10 min)
        if(start.equals(end) || dict.size() == 0)
            return 0;
        
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        dict.remove(start);
        
        int length = 1;
    
        while(! q.isEmpty()){
            int qSize = q.size();
            
            for(int i = 0; i < qSize; i++){
                String current = q.poll();
                
                for(int j = 0; j < current.length(); j++){
                    
                    for(char c = 'a'; c <= 'z'; c++){
                        
                        if(current.charAt(j) != c){
                            String currentReplace1 = replace(current, j, c);
                            
                            if(currentReplace1.equals(end))
                                return length + 1;
                            
                            if(dict.contains(currentReplace1)){
                                q.offer(currentReplace1);
                                dict.remove(currentReplace1);
                            }
                                
                        }
                        
                    }
                }
            }
            
            length++;
        }
        return 0;
    }
    private String replace(String s, int index, char c){
        char[] charArr = s.toCharArray();
        charArr[index] = c;
        return new String(charArr);
    }
}









/**
 * By using the Subset Template - TLE
 */
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        //2015-06-15 09:32:48 pause 2015-06-15 09:46:33
        if(start.equals(end) || dict.size() == 0)
            return 0;
        
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        int ansLength = 1;
        
        ArrayList<String> dictList = new ArrayList<String>();
        dictList.addAll(dict);
        
        // if(dictList.contains(start))
        //     dictList.remove(start);
        
        search(start, end, dictList, min, 0 );
        return min[0];
    }
    private void search(String start, String end, ArrayList<String> dict, int[] min, int ansLength ){
        
        if( start.equals(end) ){
            min[0] = Math.min(min[0], ansLength + 1);
            // ansLength = ansLength - 1;
            return;
        }
        
        for(int i = 0; i < dict.size(); i++){
            String wordFromDict = dict.get(i);
            
            //if differ by 1, then deep search
            if(differBy1(wordFromDict, start) ){
                dict.remove( wordFromDict );
                search(wordFromDict, end, dict, min, ansLength + 1);
                dict.add( wordFromDict );
            }
        }
    }
    private boolean differBy1(String word1, String word2){
        if(word1.equals(word2))
            return false;
            
        boolean diffBy1 = false;
        for(int i = 0; i < word1.length(); i++){
            if( !diffBy1 && word1.charAt(i) != word2.charAt(i) )
                diffBy1 = true;
            else if(diffBy1 && word1.charAt(i) != word2.charAt(i) )
                return false;
        }
        return true;
    }
}

