/**
 * Round 4
 *
 * Think about why we need 
 *      if(!visited[i]) 
 * if not, TLE will be thrown out.
 * 
 * That's because every time, we iterate from 0, and we need
 *      to ignore the previous computed numbers.
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //2015-07-24 22:38:55 - 2015-07-24 22:59:45 (21 min)
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return res;
            
        Arrays.sort(nums);
        permuteUnique(nums, res, new ArrayList<Integer>(), new boolean[nums.length]);
        return res;
    }
    private void permuteUnique(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited){
        if(list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(i >= 1 && nums[i] == nums[i - 1] && visited[i - 1])
                continue;
                
            if( ! visited[i]){
                list.add(nums[i]);
                visited[i] = true;
                
                permuteUnique(nums, res, list, visited);
                
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}







//*********************************** LintCode arraylist version *******************************
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
                        
        if(list.size() == nums.size() ){
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









/**
 * Round 2 - not proficient
 * DO THIS AGAIN
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] nums) {//2015-05-04 11:43:00 - 2015-05-04 12:23:26 (40 min)
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums == null)
            return res;
        
        Arrays.sort(nums);
        permuteUniqueHelper(res, new ArrayList<Integer>(), nums, new int[nums.length]);
        return res;
    }
    private void permuteUniqueHelper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int[] nums, int[] visited){
        if(list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
            
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == 1) continue;
            if(i > 0 && visited[i - 1] == 1 && nums[i] == nums[i - 1])//Duplicates NOT lots of replicas
                continue;
                
            if( visited[i] == 0){
                list.add(nums[i]);
                visited[i] = 1;
                permuteUniqueHelper(res, list, nums, visited);
                list.remove(list.size() - 1);
                visited[i] = 0;
            }
        }
    }
}







/**
 * O(n!)?
 * O(n)?
 * 283 ms
 * 
 * Note:
 *      Have 1 more array called "visited" to keep track of which one has been added to the list already.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {//21:06
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0)
            return res;
            
        Arrays.sort(num);
        helper(res, new ArrayList<Integer>(), num, new int[num.length]);
        return res;
    }
    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int[] num, int[] visited){
        if(list.size() == num.length){
            res.add(new ArrayList<Integer>(list));
            return;   
        }
        for(int i = 0; i < num.length; i++){
            if(visited[i] == 1) continue;
            if(i > 0 && visited[i - 1] == 1 && num[i - 1] == num[i]) continue;
            
            visited[i] = 1;
            list.add(num[i]);
            
            helper(res, list, num, visited);
            
            visited[i] = 0;
            list.remove(list.size() - 1);
        }
    }
}