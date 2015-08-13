public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        //2015-06-02 23:57:31 pause 2015-06-03 00:17:57
        //resume 2015-06-03 00:19:26 - 2015-06-03 01:04:04 (65 min)
        if(triangle == null || triangle.size() == 0)
            return 0;
        
        int n = triangle.size();
        
        //memo[i] store the min value went from the top position.
        int[] memo = new int[n];
        
        ArrayList<Integer> lastRow = triangle.get(n - 1);
        for(int i = 0; i < lastRow.size(); i++){
            memo[i] = lastRow.get(i);
        }
        
        for(int i = n - 2; i >= 0; i--){
            lastRow = triangle.get(i);
            for(int j = 0; j < lastRow.size(); j++){
                memo[j] = Math.min(memo[j], memo[j + 1]) + lastRow.get(j);
            }
        }
        
        return memo[0];
    }
}


