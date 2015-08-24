/**
 * This is nice idea.
 * 
 * Reference:
 *      https://leetcode.com/discuss/52703/2-4-lines-every-language
 */
public class Solution {
    public boolean isUgly(int num) {
        if(num <= 0)
            return false;
            
        for(int i = 2; i <= 5; i++){
            while(num % i == 0)
                num /= i;
        }
        return num == 1;
    }
}





public class Solution {
    public boolean isUgly(int num) {
        //2015-08-22 20:56:23 - 2015-08-22 21:01:24 (5 min)
        if(num <= 0)
            return false;
        
        if(num == 1)
            return true;
        
        while(num > 1){
            if(num % 2 != 0)
                break;
            num /= 2;
        }
        if(num == 1)
            return true;
            
            
            
        while(num > 1){
            if(num % 3 != 0)
                break;
            num /= 3;
        }
        if(num == 1)
            return true;
        
        
        while(num > 1){
            if(num % 5!= 0)
                break;
            num /= 5;
        }
        if(num == 1)
            return true;
        
        
        return false;
    }
}