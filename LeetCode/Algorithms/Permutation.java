/**
 * O(n^3)?
 * O(n!)
 * 
 * Iterative Approach
 * 
 * Note:
 *      For marked line 1, size cannot be initialized as
 *          size = 0; size < res.size(); size++
 *      since res.size() is changing!!
 *
 *       For marked line 2, You need to initial the list by firstList.
 *       Since you are like ** copying ** the first list.
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //2015-06-14 21:37:07 - 2015-06-14 21:53:22 (16 min)
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return res;
        
        
        res.add(new ArrayList<Integer>());
        
        for(int n : nums){
            
            for(int size = res.size(); size > 0; size--){//<=========== marked line 1 ============
                List<Integer> firstList = res.pollFirst();
                
                for(int i = 0; i <= firstList.size(); i++){
                    List<Integer> temp = new ArrayList<Integer>(firstList);//<=== marked line 2 ==
                    
                    temp.add(i, n);
                    res.add(temp);
                }
            }
        }
        return res;
    }
}




/**
 * Round 2 - Not proficient
 * DO THIS AGAIN.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] nums) {//2015-05-04 11:03:06 - 2015-05-04 11:15:07 (12 min)
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums == null)
            return res;
        
        Arrays.sort(nums);
        permute_Helper(res, new ArrayList<Integer>(), nums);
        return res;
    }
    private void permute_Helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int[] nums){
        if(list.size() == nums.length)
            res.add(new ArrayList<Integer>(list));
        
        for(int i = 0; i < nums.length; i++){
            if(! list.contains(nums[i])){
                list.add(nums[i]);
                permute_Helper(res, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}





/**
 * O(n!)
 * O(n)?
 * 261 ms
 * 
 * Note:
 *      Typical problem by using the backtracking template.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0)
            return res;
            
        helper(res, new ArrayList<Integer>(), num);
        return res;
    }
    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int[] num){
        if(path.size() == num.length){
            res.add(new ArrayList<Integer>(path));
            // return;
        }
        for(int i = 0; i < num.length; i++){
            if(! path.contains(num[i])){
                path.add(num[i]);
                helper(res, path, num);
                path.remove(path.size() - 1);
            }
        }
    }
}