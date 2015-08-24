/**
 * Review
 * 
 * Reference:
 *      这道题可以用递归的方法来做。
 *      对于一个输入字符串s，一次获得每个标点符号的
 *          左侧left和右侧right的值，然后两两组合成结果。
 *      http://bbs.itbookstudy.com/t/13481/1/1
 *      
 *      https://leetcode.com/discuss/48477/a-recursive-java-solution-284-ms
 */
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        //2*3-4*5
        //2015-08-22 23:05:23
        
        //the comment line below are also acceptable.
    //     List<Integer> res = new ArrayList<Integer>();
    //     if(input == null || input.length() == 0)
    //         return res;
        
    //     return helper(input);
    // }
    // private List<Integer> helper(String input){
    
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '+' || 
                input.charAt(i) == '-' ||
                input.charAt(i) == '*'){
                    String p1 = input.substring(0, i);
                    String p2 = input.substring(i + 1);
                    
                    List<Integer> res1 = diffWaysToCompute(p1);
                    List<Integer> res2 = diffWaysToCompute(p2);
                    
                    for(int k : res1){
                        for(int j : res2){
                            int c = 0;
                            
                            switch(input.charAt(i)){
                                case '+':
                                    c = k + j;
                                    break;
                                case '-':
                                    c = k - j;
                                    break;
                                case '*':
                                    c = k * j;
                                    break;
                            }
                            list.add(c);
                        }//for j
                    }//for i
            }//if  
        }//for
        
        if(list.size() == 0)
            list.add(Integer.valueOf(input));
        
        return list;
    }
}