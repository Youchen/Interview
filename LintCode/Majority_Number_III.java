/**
 * O(n) since every element enter HashMap once and exit HashMap once
 * O(k)
 * 
 * Note:
 *      How to iterate in HashMap:
 *          for(Map.Entry<Integer, Integer> iter : showTimes.entrySet()){
 *              iter.getKey()
 *              iter.getValue()
 * 
 *      YOU CANNOT REMOVE OR ADD <KEY, VALUE> PAIRS WHEN ITERATING
 *          THE java.util.ConcurrentModificationException WILL BE THROWN.
 *
 */
public class Solution {
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        //2015-06-21 23:00:15 - 2015-06-21 23:44:13
        if(nums == null || nums.size() == 0)
            return -1;
        
        HashMap<Integer, Integer> showTimes = new HashMap<Integer, Integer>();
        
        for(int i : nums){
            
            
            if( showTimes.containsKey(i) ){
                showTimes.put(i, showTimes.get(i) + 1);
            }else{
                showTimes.put(i, 1);
            }


            if(showTimes.size() >= k){
                ArrayList<Integer> removeList = new ArrayList<Integer>();

                for(Map.Entry<Integer, Integer> iter : showTimes.entrySet()){
                    showTimes.put(iter.getKey(), iter.getValue() - 1);

                    if(iter.getValue() == 0)
                        // showTimes.remove(iter.getKey());
                        removeList.add(iter.getKey());
                }

                for(Integer key: removeList)
                    showTimes.remove(key);

            }
            
        }

        if(showTimes.size() == 0)
            return -1;//no such element.

        //we might have [1, k - 1] elements left in the hashMap.
        //      we need to find which one is the majority.
        int max = 0, number = 0;
        
        for(Map.Entry<Integer, Integer> iter : showTimes.entrySet()){
            int count = 0;

            for(int i : nums){
                if( i == iter.getKey() )
                    count++;
            }

            if( count > max ){
                max = count;
                number = iter.getKey();
            }

        }

        return number;
    }
}