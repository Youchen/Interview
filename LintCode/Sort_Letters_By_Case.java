public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //2015-06-01 14:38:49
        if(chars == null || chars.length <= 1)
            return;
        
        int left = 0, right = chars.length - 1;
        // while(left <= right){
        //     while(left <= right && chars[left] <= 'z'  && chars[left] >= 'a' ) left++;
        //     while(left <= right && chars[right] >= 'A' && chars[right] <= 'Z' ) right--;
            
        //     //swap
        //     if(left <= right){
        //         char temp = chars[left];
        //         chars[left] = chars[right];
        //         chars[right] = temp;
        //         left++;
        //         right--;
        //     }
        // }
        while(left < right){
            while(left < right && chars[left] <= 'z'  && chars[left] >= 'a' ) left++;
            while(left < right && chars[right] >= 'A' && chars[right] <= 'Z' ) right--;
            
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
        }
        return;
    }
}


