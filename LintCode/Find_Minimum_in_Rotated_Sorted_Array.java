public class Solution {
    public int findMin(int[] num) {
        //2015-05-27 17:32:51 - 2015-05-27 17:42:52 (10 min)
        if(num == null || num.length == 0)
        	return Integer.MIN_VALUE;

        int left = 0, right = num.length - 1;
        while(left + 1 < right){
        	int mid = left + (right - left) / 2;
        	if(num[left] < num[mid]){//left is sorted
        		if(num[right] < num[left])
        			left = mid;
        		else
        			right = mid;
        	}else if(num[mid] < num[right]){//right is sorted
        		if(num[mid] > num[mid - 1])
        			right = mid;
        		else
        			left = mid;
        	}
        }
        if(num[left] < num[right])
        	return num[left];
        return num[right];
    }
}


