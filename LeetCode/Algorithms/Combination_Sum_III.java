/**
 * 
 * Find all possible combinations of k numbers that add up to a number n, given that 
 * only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * 
 * Ensure that numbers within the set are sorted in ascending order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: k = 3, n = 7
 * 
 * Output:
 * 
 * [[1,2,4]]
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: k = 3, n = 9
 * 
 * Output:
 * 
 * [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * 
 * 
 * 
 * Hide Tags Array Backtracking
 * Hide Similar Problems (M) Combination Sum
 */


/**
 * Round 2
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        //2015-07-24 20:44:32 - 2015-07-24 20:59:43 (15 min)
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(k <= 0){
            if(n > 0 || n < 0)
                return null;
            else
                return res;  
        }
        if(n < 0)
            return null;
        
        combinationSum3(k, n, res, new ArrayList<Integer>(), 1 );
        return res;
    }
    private void combinationSum3(int k, int n, List<List<Integer>> res, ArrayList<Integer> list, int pos){
        if(k == 0 && n == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if(k < 0 || n < 0)
            return;
            
        for(int i = pos; i <= 9; i++){
            list.add(i);
            combinationSum3(k - 1, n - i, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}






public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        //2015-05-31 19:02:19 - 2015-05-31 19:13:33 (11 min)
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if( k <= 0 || n <= 0 )
            return res;
        
        comHelper(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }
    private void comHelper(List<List<Integer>> res, ArrayList<Integer> list, int k, int n, int start){
        if(k < 0 || n < 0)
            return;
        if(k == 0 && n == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        
        for(int i = start; i <= 9; i++){
            list.add(i);
            comHelper(res, list, k - 1, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}