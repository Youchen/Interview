/**
 * The easy way to do is mod 9
 * This is called "Digital root".
 */
public class Solution {
    public int addDigits(int num) {
        return num == 0 ? 0 : (num % 9 == 0 ? 9 : num % 9);
    }
}



public class Solution {
    public int addDigits(int num) {
        if(num <= 9)
            return num;
            
        int unit = 0, sum = 0;
        
        while(num >= 10){
            unit = num % 10;
            num /= 10;
            
            sum += unit;
            while(sum >= 10){
                sum = sum / 10 + sum % 10;
            }
        }
        

        sum += num;
        while (sum >= 10)
            sum = sum / 10 + sum % 10;
        return sum;
    }
}