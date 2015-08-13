/**
 * Reference:
 *      https://leetcode.com/discuss/22592/java-10-lines-solution-with-stack
 */
public class Solution {
    public String simplifyPath(String path) {
        //2015-06-26 21:30:16 - 2015-06-26 21:39:00 ( 9 min )
        if(path == null || path.length() == 0)
            return "";
        
        Stack<String> stk = new Stack<String>();
        
        for(String dir : path.split("/") ){
            if(dir.equals("..") && !stk.isEmpty())
                stk.pop();
            else if( !dir.equals("..") && !dir.equals(".") && !dir.equals(""))
                stk.push(dir);
        }
        
        String res = "";
        while(!stk.isEmpty()) res = "/" + stk.pop() + res;
        
        return res.length() == 0 ? "/" : res;
    }
}