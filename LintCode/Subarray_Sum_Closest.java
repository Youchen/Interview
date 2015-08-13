/**
 * O(n log n)
 * O(n)
 * 
 * Cost so much time.
 * DO THIS AGAIN!
 * 
 * Note:
 *      after sorting, you need to + 1 on the min value index.
 *
 * 
 * Ex:
 *      arr:        [ 6 -4 -8  3  1  7 ]
 * 
 *      prefix sum: [ 6  2 -6 -3 -2  5 ]
 *      index:        0  1  2  3  4  5
 * 
 *      sorting:     -6 -3 -2  2  5  6
 * 
 *      index:        2  3  4  1  5  0
 *      abs diff:        3  1  4  3  1
 *
 *      the solution should be 4 4 or 1 5
 *      that's the (minIndex + 1) to maxIndex.
 */
public class Solution {
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        //2015-06-24 00:45:26 pause 2015-06-24 01:12:10
        //2015-06-24 09:08:32
        //2015-06-24 09:59:30 (new algorithm) pause 2015-06-24 10:38:55
        //pause 2015-06-24 11:05:02 - 2015-06-24 15:41:51 (~ 20 min)
        //(27 + 51 = 78 min for own algorithm)
        //(39 + 20 = 59 min)
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0)
            return res;
        
        res.add(0);
        res.add(0);
        int len = nums.length;
        int[] sum = new int[len];
        sum[0] = nums[0];
        
        //<prefixSum, endAtIndex>
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(sum[0], 0);
        
        for(int i = 1; i < len; i++){
            sum[i] = sum[i - 1] + nums[i];
            
            if(map.containsKey(sum[i]) ){
                res.set(0, map.get(sum[i]) + 1);
                res.set(1, i);
                return res;
            }else
                map.put(sum[i], i);
        }
        Arrays.sort(sum);
        
        int closest = Integer.MAX_VALUE;
        
        for(int i = 1; i < len; i++){
            int diff = Math.abs( sum[i] - sum[i - 1] );
            
            if(diff < closest){
                closest = diff;
                
                
                res.set(0, Math.min(
                			map.get(sum[i]), map.get(sum[i - 1])
                			) + 1
                		);
                res.set(1, Math.max(
                			map.get(sum[i]), map.get(sum[i - 1])
                			)
                		);
            }
            
        }
        return res;
    }
}

