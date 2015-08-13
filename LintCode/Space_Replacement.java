/**
 * Need to fully understand the problem.
 */
public class Solution {
    public int replaceBlank(char[] string, int length) {
        //2015-06-17 00:15:51 - pause 2015-06-17 00:45:00
        //2015-06-17 11:02:06 - 2015-06-17 11:10:37 (38 min)
        if(string == null || length == 0)
            return 0;
        
        int spaceCount = 0;
        
        for(char c : string)
            if( c == ' ')
                spaceCount++;
            
        int totalLength = length + spaceCount * 2;
        length--;
        for(int i = totalLength - 1; i >= 0; i--){
            
            if(string[length] != ' ')
                string[i] = string[length--];
            else{
                string[i--] = '0';
                string[i--] = '2';
                string[i] = '%';
                length--;
            }
        }
        return totalLength;
    }
}
