/**
 * char array to String
 * String str = String.valueOf(char[] charArr);
 */
public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public ArrayList<String> anagrams(String[] strs) {
        //2015-05-25 23:16:03
        ArrayList<String> res = new ArrayList<String>();
        if(strs == null || strs.length == 0)
            return res;
        
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        for(int i = 0; i < strs.length; i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String tempStr = String.valueOf(temp);
            if(! hm.containsKey(tempStr)){
                ArrayList<String> al = new ArrayList<String>();
            	al.add(strs[i]);
                hm.put(tempStr, al);
            }
                
            else
                hm.get(tempStr).add(strs[i]);
        }
        for(ArrayList<String> iterator: hm.values()){
            if(iterator.size() >= 2)
                res.addAll(iterator);
        }
        return res;
    }
}

