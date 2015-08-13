/**
 * Round 2
 * Very tricky way for applying the hash table.
 * Great Idea, remember this!
 * 
 * The algorithm is like this:
 *      Given an array and tell you that there must exist an consecutive
 *          Array that the sum of them is 0.
 *      You may accumulatively add them one by one and update the hashMap like
 *          < sum, index >
 *      For example:
 *          [5, 1, 2, -3, 4]
 *      the process is the following:
 *          < 0, -1 > (pre-stored value, for the case [ 1, 2, -3 ] )
 *          < 5, 0 >
 *          < 6, 1 >
 *          < 8, 2 >
 *          < 5, 3 > Here, you can see we have alreay got the key 5 in
 *                      HashMap, so we assure that from index 0 to index 3
 *                      we add zero value (since they are identical).
 *                      so the sum between index 0 and 3 is zero (acturally,
 *                      it's index 1 ~ 3 ).
 *          return [1, 3] that's fine.
 */
public class Solution {
    public ArrayList<Integer> subarraySum(int[] nums) {
        //2015-06-17 23:44:15 - 2015-06-17 23:47:54 (3 min)
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        res.add(0);
        if(nums == null || nums.length == 0)
            return res;
        
        //< sum, index >
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0, -1);
        
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            
            if( ! hm.containsKey(sum)){
                hm.put(sum, i);
            }else{
                res.set(0, hm.get(sum) + 1);
                res.set(1, i);
                return res;
            }
        }
        return res;
    }
}












/**
 * Remember this algorithm.
 */
public class Solution {
    public ArrayList<Integer> subarraySum(int[] nums) {
        //2015-05-26 19:58:14 - 2015-05-26 20:05:20 (7 min)
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        res.add(0);
        if(nums == null || nums.length == 0)
            return res;
        
        //HashMap<sum, index>
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        hs.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(hs.containsKey(sum)){
                res.set(0, hs.get(sum) + 1);
                res.set(1, i);
                return res;
            }else{
                hs.put(sum, i);
            }
                
        }
        return res;
    }
}

