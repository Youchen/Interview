/**
 * Round 2
 * The idea is
 *      two numbers, if they are diffrent, throw them out.
 *      .........................the same, count++;
 * 
 * consider array : 1, 1, 1, 1, 2, 2, 2
 *      1, 2
 *      1, 2
 *      1, 2
 *      1
 */
public class Solution {
    public int majorityElement(int[] nums) {
        //2015-06-21 18:36:07 - 2015-06-21 18:37:17 (1 min)
        if(nums == null || nums.length == 0)
            return 0;
        
        int candidate = 0, count = 0;
        for(int i : nums){
            if(count == 0){
                candidate = i;
                count++;
            }else{
                if(i == candidate)
                    count++;
                else
                    count--;
            }
        }
        return candidate;
    }
}







import java.util.*;
public class Solution {
    public int majorityElement(int[] num) {
        Hashtable<Integer, Integer> hs = new Hashtable<Integer, Integer>();
        for(int i : num){
            if( ! hs.containsKey(i) )
                hs.put(i, 1);
            else
                hs.put(i, hs.get(i) + 1);
                
            if(hs.get(i) > Math.floor(num.length / 2.0))
                return i;
        }
        return -1;   
    }
}