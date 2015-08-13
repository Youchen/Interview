/**
 * Note:
 *      The critical point is to deal with the overflow of computation.
 *      And it's not easy to design this algorithm.
 *      Remember this !
 * 
 * (a + b) % p = (a % p + b % p) % p （1）
 * (a - b) % p = (a % p - b % p) % p （2）
 * (a * b) % p = (a % p * b % p) % p （3）
 *  a ^ b  % p = ( (a % p) ^ b ) % p （4）
 *
 * Reference:
 *       http://www.eternallyconfuzzled.com/tuts/algorithms/jsw_tut_hashing.aspx
 *
 *   This algorithm is called Bernstein hash
 */
class Solution {
    public int hashCode(char[] key,int HASH_SIZE) {
        // //2015-06-18 21:25:02
        // if(key == null || key.length == 0 || HASH_SIZE == 0)
        //     return -1;
        
        // long sum = 0;
        // int pow = key.length - 1;
        
        // for(int i = 0; i < key.length; i++){
        	
        //     long product = 
        //     key[i] % HASH_SIZE * (long) Math.pow(33 % HASH_SIZE, pow--) % HASH_SIZE % HASH_SIZE;
            
        //     sum += product;
        //     sum = sum % HASH_SIZE;
        // }
        // return (int) sum;
        
        
        
        
        long res = 0;
        for (int i = 0; i < key.length; i++){
            res = 33 * res + (int)key[i];
            res = res % HASH_SIZE;
        }
        return (int)res;
    }
};
