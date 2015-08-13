/**
 * Round 2 - Version 2 by using shifting O(n) algorithm.
 * DO THIS AGAIN.
 */
public class Solution {
    /*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char[] rotateString(char[] A, int offset) {
        // wirte your code here
        //2015-05-12 18:05:05 - 2015-05-12 18:11:29 (6 min)
        if(A == null || A.length == 0 || offset % A.length == 0)
            return A;
        
        offset = offset % A.length;
        while(offset > 0){
            char last = A[A.length - 1];
            for(int i = A.length - 1; i >= 1; i--){
                A[i] = A[i - 1];
            }
            A[0] = last;
            offset--;
        }
        return A;
    }
};






/**
 * Round 2 - Not so good
 * DO THIS AGAIN
 * NOTE:
 *      REMEMBER SanFuFanZhuanFa
 */
public class Solution {
    /*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char[] rotateString(char[] A, int offset) {
        // wirte your code here
        //2015-05-12 17:36:24 - 2015-05-12 17:56:20 (20 min)
        if(A == null || A.length == 0 || offset % A.length <= 0)
            return A;
        
        int offsetMod = offset % A.length;
        reverse(A, 0, A.length - 1);
        reverse(A, 0, offsetMod - 1);
        reverse(A, offsetMod, A.length - 1);
        return A;
    }
    private void reverse(char[] A, int s, int e){
        while(s < e){
            char temp = A[s];
            A[s] = A[e];
            A[e] = temp;
            
            s++;
            e--;
        }
        return;
    }
}





/**
 * O(n)
 * O(n)
 * 778 ms
 * 
 * Note:
 *      Caution: offset might greater than A.length;
 */
public class Solution {
    /*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char[] rotateString(char[] A, int offset) {//1:19 - 1:30 (11 min)
        // wirte your code here
        if(A == null || A.length == 0 || offset == 0 || offset == A.length)
            return A;
        
        offset = offset % A.length;
        
        char[] B = new char[A.length];
        int p = A.length - offset, Bindex = 0;
        while(Bindex < A.length) {
            B[Bindex++] = A[p];
            p++;
            p = p % A.length;
        }
        return B;
    }
}