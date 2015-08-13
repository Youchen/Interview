/**
 * Supopse the two single number that we are finding is a and b.
 * idea is since XOR(all elements in A) = a XOR b (let a XOR b = c)
 *      and a != b => c != 0
 * 
 * so we can separate all the elements into two groups
 *      based on any bit of c which is 1 (since it's where a and b are diffrent)
 * 
 * in the algorithm below, I picked the right-most 1.
 * then, XOR these two groups, the result will be a and b.
 */
public class Solution {
    public List<Integer> singleNumberIII(int[] A) {
        //2015-06-21 17:23:00 -5 min 2015-06-21 17:53:36 (25 min)
        if(A == null || A.length == 0)
            return null;
        
        int XOR = 0;
        for(int i : A)
            XOR ^= i;
        
        //XOR = a ^ b (if a and b are the two single number)
        int a = 0;
        int b = 0;
        
        int rightMostBit = 0;
        //find the right-most 1
        for(int i = 0; i <= 31; i++)
            if( (XOR >> i & 1) == 1) {
                rightMostBit = i;
                break;
            }
            
        //separate all numbers to two groups.
        for(int i : A){
            if( (i >> rightMostBit & 1) == 1)
                a ^= i;
            else
                b ^= i;
        }
        
        List<Integer> res = new ArrayList<Integer>();
        res.add(a);
        res.add(b);
        
        return res;
    }
}
