/**
 * Round 3 - Not proficient
 * DO THIS AGAIN!
 * 
 * Note:
 *      idea is to eliminate the duplicates ( which means only two identical elements exist).
 *      for example:
 *          [1, 2, 2]
 *      when we finish scannning the first 2, we do not need to scan the 2nd 2.
 *      since the first 2 has already includes all the permutations which
 *      begins with number 2 (Like 212, 221).
 *      if you scan the 2nd 2, the result will be the same as 212, 221.
 */
class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        //2015-06-14 14:29:26 pause 2015-06-14 14:43:37
        //resume 2015-06-14 14:51:02 - 2015-06-14 14:53:36 (16 min)
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums == null)
            return res;
        
        Collections.sort(nums);
        permutaUnique_Helper(nums, new ArrayList<Integer>(), res, new boolean[nums.size()] );
        return res;
        
    }
    
    private void permutaUnique_Helper(ArrayList<Integer> nums, 
                    ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res, boolean[] visited){
                        
        if(list.size() == nums.size() &&
                                 ! list.contains  (new ArrayList<Integer>(list))){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.size(); i++){
            if(i >= 1 && visited[i - 1] && nums.get(i - 1) == nums.get(i))
                continue;
                
            if( ! visited[i] ){
            
                list.add(nums.get(i));
                visited[i] = true;
                
                permutaUnique_Helper(nums, list, res, visited);
                
                list.remove(list.size() - 1);
                visited[i] = false; 
            }
            
        }
        
    }
}


