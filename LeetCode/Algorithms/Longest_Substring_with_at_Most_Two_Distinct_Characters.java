/**
 * O()?
 * O(1)
 * 
 * idea is two pointers, right move to right, when there are 3 unique chars bet. left and right.
 *      right pointer stop move.
 *      then left pointer jump to the first occuring place of 2nd unique char. right jump to here
 *          as well.
 *      repeat above. and update the max during the process.
 * 
 *
 * Follow up: what about the longest substring of K distinct characters?
 *          http://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/
 *
 */
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        //2015-06-29 18:37:16 pause 2015-06-29 18:38:24
        //2015-06-29 21:28:58 pause 2015-06-29 21:51:44
        //2015-06-29 21:59:05 - 2015-06-29 22:13:42 (1 + 23 + 14 = 38 min)
        if(s.length() <= 2)
            return s.length();
        
        int len = s.length();
        int max = 0;
        
        int left = 0;
        int right = 0;
        
        while(right <= len - 1 && left <= len - 1){
            char char1 = s.charAt(left);
            while( right <= len - 1 && s.charAt(right) == char1 ){right++;}
            right--;//right is the last char of char1
            
            max = Math.max(max, right - left + 1);//substring contains only 1 char
            
            int mid = right + 1;//first char of char2
            
            if(mid != len){
                right++;//first char of char2;
                
                char char2 = s.charAt(mid);
                while( right <= len - 1 && 
                        (s.charAt(right) == char2 || s.charAt(right) == char1)
                     ){right++;}
                right--;//right is the last char of char2
                max = Math.max(max, right - left + 1);
            }
            left = mid;
            right = mid;
        }
        
        return max;
    }
}