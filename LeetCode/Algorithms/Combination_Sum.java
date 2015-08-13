/**
 * Round 2 - not proficient
 * DO THIS AGAIN
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {//2015-05-04 12:28:41 - 2015-05-04 12:47:56 (15 min)
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(candidates == null)
            return res;
        
        Arrays.sort(candidates);
        combinationSumHelper(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }
    private void combinationSumHelper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int[] candidates, int target, int pos){
        if(target < 0)
            return;
        else if(target == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = pos; i < candidates.length; i++){
            list.add(candidates[i]);
            combinationSumHelper(res, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}






/**
 * O(n!)
 * O(n)
 * 294 ms
 * 
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {//17:27 - 17:37
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(candidates == null || candidates.length == 0)
            return res;
            
        Arrays.sort(candidates);
        helper(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }
    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int[] num, int t, int pos){
        if(t < 0)
            return;
        else if(t == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = pos; i < num.length; i++){
            list.add(num[i]);
            helper(res, list, num, t - num[i], i);
            list.remove(list.size() - 1);
        }
    }
}