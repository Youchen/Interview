/**
 * Be careful
 * Do not confuse on the value of minSum and minDistance.
 */
public class Solution {
    public int threeSumClosest(int[] numbers ,int target) {
        //2015-05-27 12:37:07 pause 2015-05-27 12:53:03 resume 2015-05-27 12:59:09
        //2015-05-27 13:19:14 (36 min)
        if (numbers == null || numbers.length <= 2) 
	        return 0;
        
        Arrays.sort(numbers);
        int iter = 0, left, right, sum, minSum = Integer.MAX_VALUE;
        int len = numbers.length;

        while(iter <= len - 3){
            while (iter >= 1 && iter <= len - 3 && numbers[iter - 1] == numbers[iter])
                iter++;
        	left = iter + 1;
        	right = len - 1;

        	while(left < right){
        		sum = numbers[iter] + numbers[left] + numbers[right];
        		
        		if(sum == target)
        			return sum;//closest one, 0 distance.
        		if(Math.abs(sum - target) < Math.abs(minSum - target))
        			minSum = sum;
        		if(sum > target)
        			right--;
        		if(sum < target)
        			left++;
        	}
        	iter++;
        }
        return minSum;
    }
}