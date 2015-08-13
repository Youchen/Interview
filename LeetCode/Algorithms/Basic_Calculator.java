/**
 *
 * Reference:
 *      https://leetcode.com/discuss/41902/share-my-java-solution
 */
public class Solution {
    public int calculate(String s) {
        //2015-06-26 20:48:37 - 2015-06-26 21:25:30 (37 min)
        if(s == null)
            return 0;
        s.trim();
        if(s.length() == 0)
            return 0;
        
        //remove all whiteSpace.
        s = s.replaceAll("\\s+","");
        
        Stack<Integer> stk = new Stack<Integer>();
        char sign = '+';
        int num = 0;
        
        for(int i = 0; i < s.length(); i++){
            
            char c = s.charAt(i);
            
            if( Character.isDigit(c) ){
                num = num * 10 + c - '0';
            }
            if( !Character.isDigit(c) || i == s.length() - 1){//not digit
                
                if( sign == '-' )
                    stk.push(num * (-1) );
                else if( sign == '+' )
                    stk.push(num);
                else if(sign == '*')
                    stk.push(stk.pop() * num);
                else if(sign == '/')
                    stk.push(stk.pop() / num);
                    
                sign = s.charAt(i);
                num = 0;
            }
        }
        
        int ans = 0;
        while( ! stk.isEmpty() )
            ans += stk.pop();
        
        return ans;
    }
}