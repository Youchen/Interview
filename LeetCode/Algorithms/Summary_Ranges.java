/**
 * Make the algorithm and logical thinking smoothly.
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        //2015-06-26 20:37:42 - 2015-06-26 20:41:35 (4 min)
        List<String> res = new ArrayList<String>();
        if(nums == null || nums.length == 0) return res;
    
        if(nums.length == 1){
            res.add( nums[0] + "" );
            return res;
        }
        
        for(int i = 0; i < nums.length; i++){
            int rangeStart = nums[i];
            while( i + 1 < nums.length && nums[i + 1] - nums[i] == 1)
                i++;
                
            if(nums[i] == rangeStart){
                res.add(nums[i] + "");
            }
            else
                res.add( rangeStart + "->" + nums[i]);
        }
        return res;
    }
}






public class Solution {
    public List<String> summaryRanges(int[] nums) {
        //2015-06-26 20:37:42 - 2015-06-26 20:41:35 (4 min)
        List<String> res = new ArrayList<String>();
        if(nums == null || nums.length == 0) return res;
    
        if(nums.length == 1){
            res.add( nums[0] + "" );
            return res;
        }
        
        for(int i = 0; i < nums.length; i++){
            int rangeStart = nums[i];
            while( i + 1 < nums.length && nums[i + 1] - nums[i] == 1)
                i++;
                
            if(nums[i] == rangeStart){
                res.add(nums[i] + "");
            }
            else
                res.add( rangeStart + "->" + nums[i]);
        }
        return res;
    }
}








public class Solution {
    public List<String> summaryRanges(int[] nums) {
        //2015-06-26 16:48:07 pause 2015-06-26 17:11:38
        //2015-06-26 19:56:35 - 2015-06-26 20:08:10 (23 + 12 = 35 min)
        List<String> res = new ArrayList<String>();
        if(nums == null || nums.length == 0)
            return res;
        
        int len = nums.length;
        int startIndex = 0;// e = 1;
        res.add( Integer.toString(nums[startIndex]) );
        int listEditingIndex = 0;
        
        if(len == 1){
            res.set(0, Integer.toString(nums[0]) );
            return res;
        }
        
        for(int i = 1; i < len; i++){
            
            //case 1235
            if(nums[i] - nums[i - 1] != 1){
                if(i - startIndex >= 2)
                    res.set( listEditingIndex , 
                        Integer.toString(nums[startIndex]) + "->" + Integer.toString( nums[i - 1] )  );
                startIndex = i;
                res.add( Integer.toString( nums[startIndex] ) );
                listEditingIndex++;
            }
            
            //case 1234
            else if(nums[i] - nums[i - 1] == 1 && i == len - 1){
                res.set( listEditingIndex, 
                    Integer.toString( nums[startIndex] ) + "->" + Integer.toString( nums[i] ) );
            }
        }
        return res;
    }
}