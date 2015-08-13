/**
 * Round 3
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {//2015-05-05 16:50:38 - 2015-05-05 17:00:00
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n <= 0 || k <= 0 || n < k)
            return res;
        
        helper(n, k, res, new ArrayList<Integer>(), 1);
        return res;
    }
    private void helper(int n, int k, List<List<Integer>> res, ArrayList<Integer> list, int pos){
        //2015-07-28 10:10:02 - 2015-07-28 10:17:25 (7 min)
        if(list.size() == k){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = pos; i <= n; i++){
            list.add(i);
            helper(n, k, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}




/**
 * Round 2 - Nice done!
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {//2015-05-05 16:50:38 - 2015-05-05 17:00:00
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(n <= 0 || k <= 0 || n < k)
            return res;
        
        helper(res, new ArrayList<Integer>(), n, k, 1);
        return res;
    }
    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int n, int k, int pos){
        if(list.size() == k){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = pos; i <= n; i++){
            list.add(i);
            helper(res, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}





/**
 * O(2^n)
 * O(n)
 * 254 ms
 * 
 * Note:
 *      Similar to subset problem.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {//20:45
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(n <= 0 || k <= 0)
            return res;
        
        helper(res, new ArrayList<Integer>(), n, k, 1);
        return res;
    }
    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int n, int k, int pos){
        if(list.size() == k)
            res.add(new ArrayList<Integer>(list));
            
        for(int i = pos; i <= n; i++){
            list.add(i);
            helper(res, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}