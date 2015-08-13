class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0)
            return res;
        
        res.add(new ArrayList<Integer>());
        
        for(int n : nums){
            
            for(int size = res.size(); size > 0; size--){
                ArrayList<Integer> firstList = res.get(0);
                res.remove(0);
                
                for(int i = 0; i <= firstList.size(); i++){
                    ArrayList<Integer> temp = new ArrayList<Integer>(firstList);
                    
                    temp.add(i, n);
                    res.add(temp);
                }
            }
        }
        return res;
    }
}

