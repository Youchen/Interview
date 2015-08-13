public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //2015-06-29 17:21:57 - 2015-06-29 17:24:34 (3 min)
        
        int[] res = new int[2];
        if(numbers == null || numbers.length == 0)
            return null;
        
        int left = 0, right = numbers.length - 1;
        while(left < right){
            if(numbers[left] + numbers[right] == target){
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
            else if(left <= numbers.length - 1 && numbers[left] + numbers[right] < target){
                left++;
            }
            else if(right >= 0 && numbers[left] + numbers[right] > target)
                right--;
        }
        return res;
    }
}