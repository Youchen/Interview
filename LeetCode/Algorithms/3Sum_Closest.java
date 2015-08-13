/**
 * Round 2
 */
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Note: The Solution object is instantiated only once and is reused by
        // each test case.
        if (num == null || num.length < 3) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(num);
        int closet = Integer.MAX_VALUE / 2; // otherwise it will overflow for opeartion (closet-target)'
        for (int i = 0; i < num.length - 2; i++) {
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
                closet = Math.abs(sum - target) < Math.abs(closet - target) ? sum : closet;
            }
        }
        return closet;
    }
}






/**
 * O(nlogn + n^2) = O(n^2)
 * O(1)
 * 236 ms
 * 
 * Note:
 *      Consider carefully
 */
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        //You may assume that each input would have exactly one solution.
        //  Therefore, num must have 3 or more elements.
        Arrays.sort(num);
        
        int iterator = 0, left, right, sum, len = num.length;
        int minDistance = Integer.MAX_VALUE, minSum = -1, distance;
        
        while(iterator <= len - 3 ){
            while(iterator >= 1 && iterator <= len - 3 && num[iterator] == num[iterator - 1])
                iterator++;
            left = iterator + 1;
            right = len - 1;
            
            while(left < right){
                sum = num[iterator] + num[left] + num[right];
                distance = Math.abs(sum - target);
                
                if(distance == 0) {
                    return sum;
                }
                else if(distance < minDistance){
                    minDistance = distance;
                    minSum = sum;
                    
                    if(sum - target > 0){
                        right--;
                        while(right >= 2 &&(num[right] == num[right + 1]))
                            right--;
                    }
                    else if(sum - target < 0){
                        left++;
                        while(left <= len - 2 && (num[left] == num[left - 1]))
                            left++;
                    }
                    if(left >= right) break;
                    
                }
                else if(distance > minDistance && sum - target > 0){
                    right--;
                }
                else if(distance > minDistance && sum - target < 0){
                    left++;
                }
                else if(distance == minDistance){
                    if(sum - target > 0){
                        right--;
                        while(right >= 2 &&(num[right] == num[right + 1]))
                            right--;
                    }
                    else if(sum - target < 0){
                        left++;
                        while(left <= len - 2 && (num[left] == num[left - 1]))
                            left++;
                    }
                    if(left >= right) break;
                }//==
            }//while(left < right)
            iterator++;
        }//while
        return minSum;
    }
}