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
