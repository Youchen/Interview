public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        //2015-05-27 12:12:45 - 2015-05-27 12:23:31 (11 min)
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(numbers.length <= 2)
            return res;
    
        Arrays.sort(numbers);
        int iter = 0, left, right, len = numbers.length;
        
        
        while(iter <= len - 3){
            //to ignore the duplicates value.
            while(iter >= 1 && iter <= len - 3 && numbers[iter - 1] == numbers[iter])
                iter++;
            
            left = iter + 1;
            right = len - 1;
            
            while(left < right){
                int sum = numbers[iter] + numbers[left] + numbers[right];
                if(sum == 0){
                    ArrayList<Integer> ans = new ArrayList<Integer>();
                    ans.add(numbers[iter]);
                    ans.add(numbers[left]);
                    ans.add(numbers[right]);
                    
                    ArrayList<Integer> newAns = new ArrayList<Integer>(ans);
                    if(! res.contains(newAns))
                        res.add(newAns);
                    left++;
                    right--;
                }
                if(sum < 0)
                    left++;
                if(sum > 0)
                    right--;
            }
            iter++;
        }
        return res;
    }
}

