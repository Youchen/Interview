/**
 * Round 2
 */
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








/**
 * O(nlogn + n^2) = O(n^2)
 * O(n)
 * 272 ms
 * 
 * Note:
 *      This is the k-sum series problem.
 *      Sort the array, use 1 iterator and 2 pointers.
 *          These 2 pointers are going to "press" or iterate from the both side
 *      if num[iterator] + num[left] + num[right] == 0
 *          left++, right--;
 *          if num[left] and num[right] both did not change, left--, right++ 
 *              until at least one(num[left] or num[right]) is different than before.
 *      if num[iterator] + num[left] + num[right] < 0
 *          left++;
 *      if num[iterator] + num[left] + num[right] > 0
 *          right--;
 */
import java.util.*;
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        ArrayList<Integer> list;
        if(num.length <= 2) return lists;
        
        
        //now, the num must have 3 or more elements.
        Arrays.sort(num);
        int len = num.length;
        int iterator = 0, left, right, sum;
        while(iterator <= len - 3){
            while(iterator >= 1 && iterator <= len - 3 && num[iterator] == num[iterator - 1])
                iterator++;
            left = iterator + 1;
            right = len - 1;
            
            while(left < right){
                sum = num[left] + num[right] + num[iterator];
                if(sum == 0){
                    list = new ArrayList<Integer>();
                    list.add(num[iterator]);
                    list.add(num[left]);
                    list.add(num[right]);
                    lists.add(list);
                    left++;
                    right--;
                    while(left < right && (num[left] == num[left - 1] && num[right] == num[right + 1]) ){
                        left++;
                        right--;
                    }
                    if(left >= right) break;
                }
                else if(sum < 0)
                    left++;
                else if(sum > 0)
                    right--;
            }
            iterator++;
        }//while
        
        return lists;
    }
}