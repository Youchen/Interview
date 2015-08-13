/**
 * Round 3
 * 
 * The key to the "Gray Code" is REFLACTION!
 */
public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        //2015-07-27 17:32:59 - 2015-07-27 17:40:38 (8 min)
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(n < 0)
            return res;
            
        res.add(0);
        if(n == 0)
            return res;
        
        int power = 0;
        while(res.size() < (int) Math.pow(2, n)){
            int size = res.size();
            for(int i = size - 1; i >= 0; i--){
                res.add(res.get(i) + (int) Math.pow(2, power));
            }
            power++;
        }
        return res;
    }
}





/**
 * Round 2 - still cannot get right.
 * DO THIS AGAIN
 * 
 * Note:
 *      Remember the idea:
 *          - reverse add
 *          - add integers NOT binary bit addition then convert.
 */
public class Solution {
    public ArrayList<Integer> grayCode(int n) {//2015-05-06 11:00:16 - 2015-05-06 11:06:34 (6 min)
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        if(n <= 0)
            return res;
            
        int power = 0;
        while(res.size() < (int)Math.pow(2, n)){
            int i = res.size() - 1;
            
            while(i >= 0){
                res.add(res.get(i) + (int) Math.pow(2, power));
                i--;
            }
            power++;
        }
        return res;
    }
}






/**
 * O(2^n)
 * O(2^n)
 * 208 ms
 * 
 * Note:
 *      The key point of the solution is to acknowledge that 
 *          the order of the gray code. Looks like the following:
 *      0: 0
 *      1: 0, 1
 *      2: 00, 01, 11, 10;
 *      3: 000, 001, 011, 010, 110, 111, 101, 100
 * 
 *      Observe the above sequence, every next line is reverse repeating the 
 *          last line plus the left-most digit.
 */
public class Solution {
    public ArrayList<Integer> grayCode(int n) {//23:25 - 23:38
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        if(n == 0) return res;
        
        int power = 0;
        
        while( res.size() != (int) Math.pow(2, n) ){
            //i is decreasing i >= 0
            int i = res.size() - 1;
            while(i >= 0){
                res.add(res.get(i) + (int) Math.pow(2, power));
                i--;
            }
            power++;
        }
        return res;
    }
}