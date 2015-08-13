/**
 * Remember this algorithm
 */
public class Solution {
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        //2015-05-26 21:12:36 - 2015-05-26 21:18:20 (6 min)
        ArrayList<Long> res = new ArrayList<Long>();
        if(A == null || A.size() == 0)
            return res;
        
        int len = A.size();
        long[] lProduct = new long[len];
        long[] rProduct = new long[len];
        
        //compute lProduct
        lProduct[0] = 1;
        for(int i = 1; i < len; i++)
            lProduct[i] = lProduct[ i - 1 ] * A.get(i - 1);
            
        //compute rProduct
        rProduct[len - 1] = 1;
        for(int i = len - 2; i >= 0; i--)
            rProduct[i] = rProduct[i + 1] * A.get(i + 1);
            
        for(int i = 0; i < len; i++){
            res.add(lProduct[i] * rProduct[i]);
        }
        return res;
    }
}


