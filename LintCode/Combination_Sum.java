public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        //2015-05-05 18:11:36 pause 18:19 resume 18:21 - 2015-05-05 18:27:37 (14 min)
        // write your code here
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(candidates == null || candidates.length == 0)
            return res;
        
        Arrays.sort(candidates);
        helper(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
        
    }
    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int[] nums, int t, int pos){
        if(t < 0)
            return;
        if(t == 0){
            res.add(new ArrayList(list));
            return;
        }
        
        for(int i = pos; i < nums.length; i++){
            list.add(nums[i]);
            helper(res, list, nums, t - nums[i], i); 
            list.remove(list.size() - 1);
        }
    }
}

