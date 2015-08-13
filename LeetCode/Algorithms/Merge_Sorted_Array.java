/**
 * Round 3
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {//2015-05-11 16:32:16 - 2015-05-11 16:37:15 (5 min)
        if(nums2 == null || nums2.length == 0)
            return;
            
        m--;
        n--;
        int index = nums1.length - 1;
        while(m >= 0 || n >= 0){
            if(m < 0)
                nums1[index--] = nums2[n--];
            else if(n < 0)
                nums1[index--] = nums1[m--];
            else if(nums1[m] >= nums2[n]){
                nums1[index--] = nums1[m--];
            }
            else if(nums1[m] < nums2[n]){
                nums1[index--] = nums2[n--];
            }
        }
    }
}






/**
 * Round 2 4/16 15 min
 */
public class Solution {
    public void merge(int A[], int m, int B[], int n) {//5 min + 19:06 - 19:16 = 15 min
        if(B == null || B.length == 0)
            return;
            
        int Ap = A.length - 1;//pointer of A from the end.
        m--;
        n--;
        
        while(m >= 0 || n >= 0){
            if(m < 0){
                A[Ap] = B[n];
                n--;
            }
            else if(n < 0){
                A[Ap] = A[m];
                m--;
            }
            //m !< 0 && n !< 0
            else if(A[m] >= B[n]){
                A[Ap] = A[m];
                m--;
            }
            else if(A[m] < B[n]){
                A[Ap] = B[n];
                n--;
            }
            Ap--;
        }
    }
}





/**
 * O(m + n)
 * O(1)
 * 205 ms
 * 
 * Note:
 *      Easy but error-prone problem.
 */
public class Solution {
    public void merge(int A[], int m, int B[], int n) {//20:57 - 21:12 (13 min)
        if(A == null || B == null)//here, you should not have m == 0 || n == 0 consider the case [] [1] 
            return;
        
        //use m, n as two pointers
        m--;
        n--;
        int cur = A.length - 1;
        while(cur >= 0){
            if(m >= 0 && n >= 0){
                if(A[m] <= B[n])
                    A[cur] = B[n--];
                else
                    A[cur] = A[m--];
            }   
            else if(m < 0 && n >= 0)
                A[cur] = B[n--];
            else
                A[cur] = A[m--];
            cur--;
        }
    }
}









/**
 * O(m + n)
 * O(1)
 * 196 ms
 */
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // if(B.length == 0) return;
        if(n == 0) return;//nothing to merge.
        if(m == 0){//copy B to A.
            for(int i = 0; i < n; i++)
                A[i] = B[i];
            return;
        }
        /**
         * A is like 3, 4, 5, 7, 10, _ , _ , _ , _ , _ , _ ... m = 5
         * B is like 4, 7, 9, 14, _ , _ , _ ... n = 4
         * 
         * Merge them.
         */
         int index = m + n - 1;
         m--; n--;
         while (m >= 0 && n >= 0)
            A[index--] = (A[m] > B[n])? A[m--] : B[n--];
            
        if(m < 0)
            while(n >= 0)
                A[index--] = B[n--];
        /**
         * If all the elements of B are merged into A.
         * No need to copy the rest of A elements into A.
         */
        // else if(n < 0)
        //     while(m >= 0)
        //         A[index--] = A[m--];
    }
}