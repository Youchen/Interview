/**
 * Round 2
 * Review!
 * 
 * The idea is:
 *      p1 is writing poitner, p2 is iterating pointer.
 *          both points to the 1st index.
 * 
 *      if nums[p2] == nums[p2 - 1], just p2++ {here is i++}
 *      if !=, just let nums[p1] == nums[p2], then p1++ for next round.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        //2015-09-03 00:51:17 - 2015-09-03 01:03:44 (12 min)
        if(nums.length < 2) 
            return nums.length;
        int id = 1;
        
        for(int i = 1; i < nums.length; i++) 
            if(nums[i] != nums[i-1]) 
                nums[id++] = nums[i];
            
        return id;
    }
}






/**
 * Round 4
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int size = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[size] != nums[i])
                nums[++size] = nums[i];
        }
        return size + 1;
    }
}



/**
 * Round 3 - best way is using for loop
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int size = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[size] != nums[i])
                // size++;
                nums[++size] = nums[i];
        }
        return size + 1;
    }
}





/**
 * Round 3
 * Note:
 *      Pay attention to the return type
 *          needs to return pointer index or the array length at pointer.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {//2015-05-11 15:39:49 - 2015-05-11 15:47:25 (8 min)
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        
        int p1 = 0, p2 = 1;
        while(p2 <= nums.length - 1){
            if(nums[p2] == nums[p1])
                p2++;
            else{
                p1++;
                nums[p1] = nums[p2];
            }
        }
        return p1 + 1;
    }
}







/**
 * Round 2 - 4/6 (4 min)
 * O(n)
 * O(1)
 * 259 ms
 */
public class Solution {
    public int removeDuplicates(int[] A) {//20:17 - 20:21 (4 min)
        if(A == null || A.length == 0)
            return 0;
        
        int left = 1, right = 1;
        while(right < A.length){
            if(A[right] != A[right - 1]){
                A[left] = A[right];
                left++;
            }
            right++;
        }
        return left;
    }
}





/**
 * O(n)
 * 264 ms
 * 
 * Array
 *      Two pointers
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        /**
         * This Problem cost so much time,
         * Do it again.
         */
        if(A.length <= 1) return A.length;
        int i = 0, j = 1;
        while(j < A.length){
            if(A[j] == A[i]) j++;
            else{
                i++;
                A[i] = A[j];
                j++;
            }
        }
        return i + 1;
        
//       //HashSet
// 		HashSet<Integer> hs = new HashSet<Integer>();
// 		for(int item : A)
// 			hs.add(item);
// 		int index = 0;
// 		for(Object item : hs.toArray())
// 			A[index++] = (int) item;

// 		for(int i : A)
// 			System.out.println(i + " ");
		
// 		return hs.size();
        
        
    }//method
}