/**
 * Round 4
 * Pay attention to List -> ArrayList
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //2015-07-26 20:27:23
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null)
            return res;
        
        Arrays.sort(nums);
        subsets_helper(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    private void subsets_helper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int pos){
        res.add(new ArrayList<Integer>(list));
        
        for(int i = pos; i < nums.length;i++){
            list.add(nums[i]);
            subsets_helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}






//******************************** LintCode ArrayList<Integer> versoin ********************
/**
 * Round 3
 * Need to have Sort method
 *      Collections.sort();
 */
class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        //2015-06-11 22:51:46 - 2015-06-11 23:04:21 ( 13 min )
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.size() == 0)
            return res;
        
        Collections.sort(S);
        subsets_helper(S, res, new ArrayList<Integer>(), 0);
        
        return res;
    }
    private void subsets_helper(ArrayList<Integer> S, 
    ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int pos){
        
        res.add(new ArrayList<Integer>(list));
        
        for(int i = pos; i < S.size(); i++){
            list.add(S.get(i));
            subsets_helper(S, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}






/**
 * Round 2 - not proficient.
 * DO THIS AGAIN.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {//May 4 10:29 - 10:47 (18 min)
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums == null)
            return res;
        
        Arrays.sort(nums);
        subsets_helper(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    private void subsets_helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int[] nums, int pos){
        res.add(new ArrayList<Integer>(list));
        
        for(int i = pos; i < nums.length;i++){
            list.add(nums[i]);
            subsets_helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}



/**
 * O(2^n) why?
 * O(n) why?
 * 204 ms
 * 
 * Note:
 *      This is the template for Permutation problems.
 *      Better remember this and be fast.
 * Reference:
 *      http://www.cnblogs.com/yuzhangcmu/p/4211815.html
 */
public class Solution {
    // public List<List<Integer>> subsets(int[] S) {
    //     List<List<Integer>> res = new ArrayList<List<Integer>>();
    //     if(S == null || S.length == 0)
    //         return res;
        
    //     Arrays.sort(S);
    //     helper(res, new ArrayList<Integer>(), S, 0);
    //     return res;
    // }
    // public void helper(List<List<Integer>> res, List<Integer> list, int[] num, int pos){
    //     res.add(new ArrayList<Integer>(list));//need to build a new List<Integer> based on list. but not "list" itself.
    //     for(int i = pos; i < num.length; i++){
    //         list.add(num[i]);
    //         helper(res, list, num, i + 1);
    //         list.remove(list.size() - 1);
    //     }
    // }
    
    

    
    
    /**
     * Another one, by the principle of add one.
     * O(n^2)
     * O(n)
     * 270 ms
     * 
     * Note: easy to understand and implement.
     */
     public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.length == 0)
            return ans;
            
        Arrays.sort(S);
        ans.add(new ArrayList<Integer>());
        
        for(int i = 0; i < S.length; i++){
            int curAnsSize = ans.size();
            for(int j = 0; j < curAnsSize; j++){
                ArrayList<Integer> cur = new ArrayList<Integer>(ans.get(j));
                cur.add(S[i]);
                ans.add(cur);
            }
        }
        return ans;
     }
}