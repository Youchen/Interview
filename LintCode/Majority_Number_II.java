/**
 * The idea is three DIFFERENT numbers conteract each other.
 */
public class Solution {
    public int majorityNumber(ArrayList<Integer> nums) {
        //2015-06-21 22:38:03 - 2015-06-21 22:47:54 (9 min)
        if(nums == null || nums.size() == 0)
            return -1;
        
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
        
        //confirm which one is majority.
        for(int i : nums){
            if(i == candidate1)
                ct1++;
            else if(i == candidate2)
                ct2++;
        }
        
        return ct1 > ct2 ? candidate1 : candidate2;
    }
}