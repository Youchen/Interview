/**
 * Round 2
 * Still cost lots of time.
 * 
 * Pay attention to the index!
 */
public class Solution {
    public int numDecodings(String s) {
        //2015-05-25 18:25:13 - 2015-05-25 18:39:45 (14 min)
        if(s == null || s.length() == 0)
            return 0;
        
        int len = s.length();
        int[] nums = new int[len + 1];
        
        nums[0] = 1;
        nums[1] = s.charAt(0) == '0'? 0 : 1;
        
        //f[i] = f[i - 1] (s[i] != 0)
        //       f[i - 2] + 1 (10 <= s[i-1, i] <= 26)
        for(int i = 2; i < len + 1; i++){
            if(s.charAt(i - 1) != '0')//<========== pay attention here, it's  i - 1 NOT i
                nums[i] = nums[i - 1];
            
            int twoDigits = (s.charAt(i - 2) - '0' ) * 10 + (s.charAt(i - 1) - '0');
            if(twoDigits <= 26 && twoDigits >= 10)
                nums[i] += nums[i - 2];

            //Could do following way in this for loop
            // int strIndex = i - 1; //initialize a strIndex to keep track the corrosponding index in string.
            // if(s.charAt(strIndex) != '0')
            //     nums[i] = nums[i - 1];
                
            // int twoDigits = 10 * (s.charAt(strIndex - 1) - '0') + s.charAt(strIndex) - '0';
            // if(twoDigits <= 26 && twoDigits >= 10)
            //     nums[i] += nums[i - 2];
        }
        return nums[len];
    }
}







/**
 * DO THIS AGAIN.
 * 
 * O(n)
 * O(n)
 * 224 ms
 * 
 */
public class Solution {
    public int numDecodings(String s) {//0:28
        if(s.length() == 0 || s == null) return 0;
        
        //now, s.length() must >= 1
        if(s.charAt(0) == '0') return 0;
        
        //s.charAt(0) != '0' => the first char is valid.
        int[] dpArr = new int[s.length() + 1];
        dpArr[0] = 1;
        dpArr[1] = 1;
        
        //NOTICE: 
        //		arr[i] corresponds to s.substring(i - 1, i);
        for(int i = 2; i <= dpArr.length - 1; i++){
            //if the succeeding char is valid, at least now,
            //      the decoding way is remain the same.
            if(s.charAt(i - 1) != '0')
                dpArr[i] = dpArr[ i - 1 ];
            
            //if the combination of succeeding char AND the previous
            //      char is valid, the decoding way is ++;
            if(Integer.valueOf(s.substring(i - 2, i)) >= 10 && Integer.valueOf(s.substring(i - 2, i)) <= 26){
            		dpArr[i] = dpArr[i] + dpArr[i - 2];
            }
        }
        return dpArr[s.length()];
    }
}