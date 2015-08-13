/**
 * The "Boyer-Moore Majority Vote Algorithm" Applied in this problem.
 * Cost longer time.
 * Understand the algorithm again.
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //2015-06-29 11:58:14 - 2015-06-29 12:21:01 (23 min)
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0)
            return res;
            
        int candidate1 = 0, candidate2 = 0;
        int ct1 = 0, ct2 = 0;
        
        for(int i : nums){
            
            if(i == candidate1)
                ct1++;
            else if(i == candidate2)
                ct2++;
            else if(ct1 == 0){
                candidate1 = i;
                ct1 = 1;
            }
            else if(ct2 == 0){
                candidate2 = i;
                ct2 = 1;
            }
            else{
                ct1--;
                ct2--;
            }
        }
        
        ct1 = 0;
        ct2 = 0;
        for(int i : nums){
            if(i == candidate1)
                ct1++;
            else if(i == candidate2)
                ct2++;
        }
        
        if(ct1 > nums.length / 3)
            res.add(candidate1);
        if(ct2 > nums.length / 3)
            res.add(candidate2);
    
        return res;
    }
}