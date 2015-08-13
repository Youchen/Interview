/**
 * O(nk)
 * O(1)
 * 
 * Algorithm :
 * From left (significant) to right, delete the first number that is 
 *      larger than its succeeding number. This equals replacement of 
 *      a large number with a small number at the most significant 
 *      position to maximize the change.
 * 
 *      e.g. 178542 -> 17542 -> 1542 -> 142 -> 12
 * 
 * Reference:
 *      http://blog.welkinlan.com/2015/05/29/delete-digits-lintcode-java/
 */
public class Solution {
    public String DeleteDigits(String A, int k) {
        //2015-06-25 15:44:00 - 2015-06-25 15:49:19 (5 min)
        if(k == 0 || A.length() == 0)
            return A;
        
        int len = A.length();
        for(int i = 0; i < k; i++){//delete k times
            for(int j = 0; j < A.length(); j++){//every time, iterate from beginning
                if(j == A.length() - 1 || A.charAt(j) > A.charAt(j + 1) ){
                    A = remove(A, j);
                    break;
                }
            }
        }
        
        int i = 0;
        while(A.charAt(i) == '0')
            i++;
        
        return A.substring(i);
        
    }
    private String remove(String A, int index){
        return A.substring(0, index) + A.substring(index + 1, A.length());
    }
}
