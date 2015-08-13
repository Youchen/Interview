public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) { 
        //2015-05-27 13:25:26 pause 2015-05-27 13:26:20
        //resume 2015-05-27 13:28:50 - 2015-05-27 13:43:14
        ArrayList<ArrayList<Integer>> res = 
                                        new ArrayList<ArrayList<Integer>>();
        if(numbers == null || numbers.length <= 3)
            return res;
        
        Arrays.sort(numbers);
        int len = numbers.length;
        for(int i = 0; i <= len - 4; i++){
            //igore the duplicates
            while(i >= 1 && i <= len - 4 && numbers[i - 1] == numbers[i])
                i++;

            for(int j = i + 1; j <= len - 3; j++){//3sum
                //igore the duplicates
                // while(j >= 3 && j <= len - 3 && numbers[j - 1] == numbers[j])
                //     j++;

                int left = j + 1, right = len - 1;
                while(left < right){
                    int sum = numbers[i] + numbers[j] + 
                                numbers[left] + numbers[right];
                    if(sum == target){
                        ArrayList<Integer> ans = new ArrayList<Integer>();
                        ans.add(numbers[i]);
                        ans.add(numbers[j]);
                        ans.add(numbers[left]);
                        ans.add(numbers[right]);

                        if(! res.contains(ans))
                            res.add(ans);
                        left++;
                        right--;
                    }
                    if(sum < target)
                        left++;
                    if(sum > target)
                        right--;
                }
            }
        }
        return res;
    }
}