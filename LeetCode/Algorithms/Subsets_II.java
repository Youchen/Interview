/**
 * Round 4
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //2015-07-26 20:28:33 - 2015-07-26 20:34:18 (6 min)
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return res;
        
        Arrays.sort(nums);
        helper(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> res, ArrayList<Integer> list, int pos){
        if( !res.contains(new ArrayList<Integer>(list)) )
            res.add(new ArrayList<Integer>(list));
        
        for(int i = pos; i < nums.length; i++){
            list.add(nums[i]);
            helper(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}


/**
 * Round 3 - nice done.
 *
 * Note:
 *      try this without doing the subset problem.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {//MAY 4 10:50 - 10:57 (7 min)
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums == null)
            return null;
            
        Arrays.sort(nums);
        subsetsWithDup_helper(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    private void subsetsWithDup_helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int[] nums, int pos){
        if( ! res.contains(new ArrayList<Integer>(list)) )
            res.add(new ArrayList<Integer>(list));
        
        for(int i = pos; i < nums.length; i++){
            list.add(nums[i]);
            subsetsWithDup_helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}



/**
 * Round 2 - 3/27
 * O(2^n)?
 * O(n)
 * 283 ms
 * 
 * Note:
 *      Nice done!
 *      Be careful on the result, because result is a "Set", it cannot have duplicates.
 */
public class Solution {
    // public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
    //     ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    //     if(num == null || num.length == 0)
    //         return res;
    //     Arrays.sort(num);
    //     helper(res, num, new ArrayList<Integer>(), 0);
    //     return res;
    // }
    // private void helper(ArrayList<ArrayList<Integer>> res, int[] num, ArrayList<Integer> list, int pos){
    //     if(! res.contains(new ArrayList<Integer>(list)))//just adding this line!
    //         res.add(new ArrayList<Integer>(list));
    //     for(int i = pos; i < num.length; i++){
    //         list.add(num[i]);
    //         helper(res, num, list, i + 1);
    //         list.remove(list.size() - 1);
    //     }
    // }
    
    
    
    
    //2nd round. Mar 26 20:15
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0)
            return res;

        Arrays.sort(num);
        helper(res, new ArrayList<Integer>(), num, 0);
        return res;
    }
    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int[] num, int pos){
        if(! res.contains(new ArrayList<Integer>(list)))
            res.add(new ArrayList<Integer>(list));
            
        for(int i = pos; i < num.length; i++){
            list.add(num[i]);
            /**
             * below you cannot write pos + 1 instead of i + 1.
             * Since each iteration, after list add num[i], you need to pass the next number close to num[i]
             *      to the next step recursion instead of the num[pos], because num[pos] will remain same
             *      in that step recursion.
             */
            helper(res, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }
}







/**
 * O(2^n)?
 * O(n)
 * 283 ms
 * 
 * Note:
 *      Nice done!
 *      Be careful on the result, because result is a "Set", it cannot have duplicates.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0)
            return res;
        Arrays.sort(num);
        helper(res, num, new ArrayList<Integer>(), 0);
        return res;
    }
    private void helper(ArrayList<ArrayList<Integer>> res, int[] num, ArrayList<Integer> list, int pos){
        if(! res.contains(new ArrayList<Integer>(list)))//just adding this line!
            res.add(new ArrayList<Integer>(list));
        for(int i = pos; i < num.length; i++){
            list.add(num[i]);
            helper(res, num, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}