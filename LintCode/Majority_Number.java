/**
 * Round 2
 * The idea is
 *      two numbers, if they are diffrent, throw them out.
 *      .........................the same, count++;
 * 
 * consider array : 1, 1, 1, 1, 2, 2, 2
 *      1, 2
 *      1, 2
 *      1, 2
 *      1
 */
public class Solution {
    public int majorityNumber(ArrayList<Integer> nums) {
        //2015-06-21 18:30:09 - 2015-06-21 18:33:19 (3 min)
        if(nums == null || nums.size() == 0)
            return -1;
        
        int candidate = 0, count = 0;
        for(int i = 0; i < nums.size(); i++){
            if(count == 0){
                candidate = nums.get(i);
                count++;
            }else{
                if(nums.get(i) == candidate)
                    count++;
                else
                    count--;
            }
        }
        return candidate;
    }
}












public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> num) {
        //2015-05-29 17:30:06 - 2015-05-29 18:03:23 (33 min)
        if(nums == null || nums.size() == 0)
            return 0;
        
        int candidate = nums.get(0), count = 1;
        for(int i = 1; i < nums.size(); i++){
            if(count > nums.size() / 2)
                return candidate;
            
            if(nums.get(i) == candidate){
                count++;
            }else{
                count--;
                if(count == 0){
                    candidate = nums.get(i);
                    count = 1;
                }
            }
        }
        
        //examing if the array is like 1, 2, 3, 4 (no majority number)
        count = 0;
        for(int i = 0; i < nums.size(); i++){
            if(nums.get(i) == candidate){
                count++;
                if(count >= nums.size() / 2)
                    return candidate;
            }
        }
        if(count < nums.size() / 2)
            return -1;
        
        return candidate;
        
        
        
        //Simple solution.
        //  if (num == null || num.size() == 0) {
        //     return -1;
        // }
        
        // int maj = num.get(0);
        
        // int len = num.size();
        // int cnt = 1;
        // for (int i = 1; i < len; i++) {
        //     if (cnt == 0) {
        //         maj = num.get(i);
        //         cnt = 1;
        //     } else if (num.get(i) != maj) {
        //         cnt--;
        //     } else {
        //         cnt++;
        //     }
        // }
        
        // return maj;
    }
}


