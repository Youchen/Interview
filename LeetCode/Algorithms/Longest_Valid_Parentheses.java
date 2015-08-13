/**
 * DO THIS AGAIN.
 * Reference:
 *      http://codeganker.blogspot.com/2014/03/longest-valid-parentheses-leetcode.html
 */
public class Solution {
    public int longestValidParentheses(String s) {
        //2015-07-21 16:28:38 - 2015-07-21 16:44:12 (16 min)
        if(s == null || s.length() == 0)
            return 0;
        
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        
        int start = 0;
        int max = 0;
        
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '(' )
                stack.push(i);
            else{//is ')'
                if(stack.isEmpty())
                    start = i + 1;
                else{
                    stack.pop();
                    max = stack.isEmpty()?
                            Math.max(max, i - start + 1) :
                            Math.max(max, i - stack.peek());
                    //for why you cannot have "i - stack.peek() + 1"
                    //consider the case "(()", result should be 2.
                    //but it will be 3 if you make it "+ 1".
                }
            }
        }
        return max;
    }
}