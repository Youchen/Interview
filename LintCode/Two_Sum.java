public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        //2015-05-27 00:58:50 - 2015-05-27 01:08:41 (10 min)
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        if(numbers == null || numbers.length == 0)
            return ans;
        
        //HashMap <number, Index>
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++){
            hm.put(numbers[i], i + 1);
        }
        
        for(int i = 0; i < numbers.length; i++){
            if(hm.containsKey(target - numbers[i])){
                ans[0] = Math.min(i + 1, hm.get(target - numbers[i]));
                ans[1] = Math.max(i + 1, hm.get(target - numbers[i]));
            }
        }
        return ans;
    }
}

