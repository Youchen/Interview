/**
 * O(n)
 * O(n)
 * 
 * idea is too simple:
 *      just like the brute force algorithm.
 *      But it put encoded numbers into HashMap rather than the pure ten-character string.
 * 
 * Reference:
 *      http://yuanhsh.iteye.com/blog/2185976
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        //2015-07-11 21:18:10 - 2015-07-11 21:27:02 (11 min)
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() <= 10)
            return res;
        
        HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        
        
        int tenChar = 0;
        for(int i = 0; i < s.length(); i++){
            tenChar = ( (tenChar << 2) + map.get(s.charAt(i)) ) & 0xFFFFF;
            Integer count = table.get(tenChar);
            
            if(i < 9) continue;
            
            if(count != null && count == 1)
                res.add(s.substring(i - 9, i + 1) );
            
            table.put(tenChar, count == null ? 1 : table.get(tenChar) + 1);
        }
        return res;
    }
}


/**
 * O(n)
 * O(n)
 * 
 * idea is kind like greedy to save space.
 *      we have two containers: list and hashMap
 *      for the incoming ten-char string, 
 *          if both of two containers doesn't contain it, 
 *              it must be new one. so add into hashMap.
 *          if hashMap has it
 *              add to list;
 *              remove it from hashMap
 *          if list has it
 *              ignore this string. go next round.
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        //2015-07-11 20:07:47 - 2015-07-11 20:23:29 (16 min)
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() <= 10)
            return res;
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int len = s.length();
        
        for(int i = 0; i + 10 <= len; i++){
            String tenChar = s.substring(i, i + 10);
            
            if(map.containsKey(tenChar)){
                res.add(tenChar);
                map.remove(tenChar);
            }
            else if ( !res.contains(tenChar) )
                map.put(tenChar, 1);
        }
        
        for(Map.Entry<String, Integer> iter : map.entrySet()){
            if(iter.getValue() >= 2 && ! res.contains(iter.getKey()) )
                res.add(iter.getKey());
        }
        return res; 
    }
}





/**************************** Naive Brute Force version (TLE) *************************/
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // 2015-07-11 19:48:20 pause 2015-07-11 19:52:02
        // 2015-07-11 19:58:35 - 2015-07-11 20:04:31 (TLE)
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() <= 10)
            return res;
        
        int len = s.length(), count = 0;
        
        for(int i = 0; i + 11 <= len; i++){
            String tenChars = s.substring(i, i + 11);
            
            for(int j = i + 1; j + 11 <= len; j++){
                if(s.substring(j, j + 11).equals(tenChars))
                    count++;
            }
            if(count != 0)
                res.add(tenChars);
            count = 0;
        }
        return res;
    }
}