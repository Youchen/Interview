public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        if(A == null || B == null)
            return false;
        if(A.length() < B.length())
            return false;
            
        //2015-05-05 19:26:03 - 2015-05-05 19:30:14 (4 min)
        int[] table = new int[26];
        for(int i = 0; i < A.length(); i++){
            table[A.charAt(i) - 'A']++;
        }
        
        for(int j = 0; j < B.length(); j++){
            int index = B.charAt(j) - 'A';
            table[index]--;
            if(table[index] < 0)
                return false;
        }
        return true;
    }
}

