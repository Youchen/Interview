/**
 * Round 4
 * DO THIS AGAIN
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //2015-07-28 22:32:46 - 2015-07-28 22:51:17 (19 min)
        int len1 = nums1.length, len2 = nums2.length;
        int sum = len1 + len2;
        
        if(sum % 2 == 0){
            double res1 = kth(nums1, 0, nums2, 0, sum / 2);
            double res2 = kth(nums1, 0, nums2, 0, sum / 2 + 1);
            return (res1 + res2) / 2.0;
        }else
            return kth(nums1, 0, nums2, 0, sum / 2 + 1);
    }
    private double kth(int[] A, int As, int[] B, int Bs, int k){
        if(As >= A.length)
            return B[Bs + k - 1];
        if(Bs >= B.length)
            return A[As + k - 1];
        
        if(k == 1)
            return Math.min(A[As], B[Bs]);
        
        int A_kth = As + k / 2 - 1 < A.length ? A[As + k / 2 - 1] : Integer.MAX_VALUE;
        int B_kth = Bs + k / 2 - 1 < B.length ? B[Bs + k / 2 - 1] : Integer.MAX_VALUE;
        
        if(A_kth < B_kth)//drop first half of A
            return kth(A, As + k / 2, B, Bs, k - k / 2);
        else
            return kth(A, As, B, Bs + k / 2, k - k / 2);
    }
}




/**
 * Round 3 - Nice done!
 * DO THIS AGAIN
 *      after couple days later
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {//2015-05-12 13:24:50 - 2015-05-12 13:36:31 (12 min)
        if(nums1 == null && nums2 == null)
            return -1;
        
        int len1 = nums1.length, len2 = nums2.length, lenSum = len1 + len2;
        if(lenSum % 2 == 0){
            double res1 = kth(nums1, 0, nums2, 0, lenSum / 2);
            double res2 = kth(nums1, 0, nums2, 0, lenSum / 2 + 1);
            return (res1 + res2) / 2.0;
        }else{
            return kth(nums1, 0, nums2, 0, lenSum / 2 + 1);
        }
    }
    private double kth(int[] A, int As, int[] B, int Bs, int k){
        if(As >= A.length)
            return B[Bs + k - 1];
        if(Bs >= B.length)
            return A[As + k - 1];
        
        if(k == 1)
            return Math.min(A[As], B[Bs]);
        
        int A_kth = As + k / 2 - 1 < A.length ? A[As + k / 2 - 1] : Integer.MAX_VALUE;
        int B_kth = Bs + k / 2 - 1 < B.length ? B[Bs + k / 2 - 1] : Integer.MAX_VALUE;
        
        if(A_kth < B_kth){//drop first half of A
            /**
             * The reason why "As" become "As + k / 2" instead of "As + k / 2 - 1".
             * Consider the case if we need to find the 4th number, after dividing to k / 2 = 2 and k / 2 = 2.
             *      if we drop the first half of A, say drop index of 0 and 1, then for the
             *      next recursion stack, the start of A should be 2, this is the exact result of
             *      As + k / 2
             */
            return kth(A, As + k / 2, B, Bs, k - k / 2);
        }else{//drop first half of B
            return kth(A, As, B, Bs + k / 2, k - k / 2);
        }
    }
}







/**
 * Round 3
 * DO THIS AGAIN
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //2015-05-11 17:06:18 //2015-05-12 00:03:37 - 2015-05-12 00:14:38 (11 min)
        if(nums1 == null && nums2 == null)
            return 0;
            
        if( (nums1.length + nums2.length) % 2 == 0){
            double res1 = kth(nums1, 0, nums2, 0, (nums1.length + nums2.length) / 2);
            double res2 = kth(nums1, 0, nums2, 0, (nums1.length + nums2.length) / 2 + 1);
            return (res1 + res2) / 2.0;
        }
        else
            return kth(nums1, 0, nums2, 0, (nums1.length + nums2.length) / 2 + 1);
    }
    private double kth(int[] nums1, int s1, int[]nums2, int s2, int k){
        if(s1 >= nums1.length)// ==================================Note: here is >= NOT >
            return nums2[s2 + k - 1];
        if(s2 >= nums2.length)// ==================================Note: here is >= NOT >
            return nums1[s1 + k - 1];
        if(k == 1)
            return Math.min(nums1[s1], nums2[s2]);
        
        double val1 = s1 + k / 2 - 1 < nums1.length ?
                nums1[s1 + k / 2 - 1] : Integer.MAX_VALUE;
        double val2 = s2 + k / 2 - 1 < nums2.length ?
                nums2[s2 + k / 2 - 1] : Integer.MAX_VALUE;
            
        if(val1 < val2)//drop nums1 first half
            return kth(nums1, s1 + k / 2, nums2, s2, k - k / 2);// === here is s1 + k / 2 NOT s1 + k / 2 - 1
        else//drop nums2 first half
            return kth(nums1, s1, nums2, s2 + k / 2, k - k / 2);// === here is s2 + k / 2 NOT s2 + k / 2 - 1
    }
}









/**
 * Round 2 4/16 (29 min)
 * Tough one!!
 * 
 * When you think about which part to drop.
 * just think reversely, I mean, think which part is possibily NOT drop.
 *      then the rest part is the one you need to drop.
 */
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {//20:06 - 20:37 (29 min)
        int Alen = A.length, Blen = B.length;
        
        /**
         * In case of overflow, I use % to check their sum is odd or even.
         * 
         * odd + odd = even
         * even + even = even
         * 
         * odd + even = odd
         */
         //The sum of case below is even
        if( (Alen % 2 == 0 && Blen % 2 == 0) ||
            (Alen % 2 != 0 && Blen % 2 != 0) ){
                double r1 = f(A, 0, Alen, B, 0, Blen, (Alen + Blen) / 2);
                double r2 = f(A, 0, Alen, B, 0, Blen, (Alen + Blen) / 2 + 1);
                return (r1 + r2) / 2.0;
        }
        else{
            return f(A, 0, Alen, B, 0, Blen, (Alen + Blen + 1) / 2);
        }
    }
    //As = Astart, Ae = Aend;
    //As is inclusive, Ae is exclusive
    private double f(int A[], int As, int Ae, int B[], int Bs, int Be, int k){
        //range
        int m = Ae - As;
        int n = Be - Bs;
        
        if(m <= 0 && n <= 0)
            return 0;
        if(m <= 0 && n > 0)
            return B[Bs + k - 1];
        if(m > 0 && n <= 0)
            return A[As + k - 1];
        
        //below is the case of both of m, n are > 0
        int midA = As + (Ae - As) / 2;
        int midB = Bs + (Be - Bs) / 2;
        
        if(A[midA] <= B[midB]){
            if(k - 1 <= (m / 2 + n / 2) )//drop second half of B
                return f(A, As, Ae, B, Bs, midB, k);
            else
                return f(A, midA + 1, Ae, B, Bs, Be, k - m / 2 - 1);//Here k - m/2 - 1 is tricky part, just write on paper, you will see how to do it.
        }else{
            if(k - 1 <= (m / 2 + n / 2) )//drop 2nd half of A
                return f(A, As, midA, B, Bs, Be, k);
            else//drop 1st half of B
                return f(A, As, Ae, B, midB + 1, Be, k - n / 2 - 1);
        }
        
    }
}










public class Solution {
    /**
     * inspired by:
     *      http://www.lifeincode.net/programming/leetcode-median-of-two-sorted-arrays-java/
     * 
     * Solution #2
     * O(log(m + n))
     * O(?) //each time, eliminate either half of A OR half of B
     * 472 ms
     * 
     * Note:
     *      This is hard one.
     *      Consider this way, after determine the relation of A[midA] and B[midB], we need to determin the 
     *          relation between k and (n / 2 + m / 2).
     *      At this moment, we need to find out the section (either the 1st half of A(or B) or the 2nd half of A(or B) )
     *          that MUST be DROPED, i.e. the k-th number must not in that section, then search again.
     */
    public double findMedianSortedArrays(int A[], int B[]) {
    	int lengthA = A.length;
    	int lengthB = B.length;

    	if( (lengthA + lengthB) % 2 == 0){
    		double r1 = findMedianSortedArrays(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB) / 2);
    		double r2 = findMedianSortedArrays(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB) / 2 + 1);
    		return (r1 + r2) / 2.0;
    	}else{
    		return findMedianSortedArrays(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB + 1) / 2);
    	}
    }

    //indexical start is inclusive;
    //indexical end is exclusive.
    public double findMedianSortedArrays(int[] A, int startA, int endA, int[] B, int startB, int endB, int k){
    	//length of the range
    	int n = endA - startA;
    	int m = endB - startB;

    	if(n <= 0 && m <= 0) return 0;
    	if(n <= 0 && m > 0)
    		return B[startB + k - 1];
    	if(n > 0 && m <= 0)
    		return A[startA + k - 1];

    	int midA = (startA + endA) / 2;//indexical mid
    	int midB = (startB + endB) / 2;//indexical mid

    	if(A[midA] <= B[midB]){
    		if (k - 1 <= (n / 2 + m / 2)) //k-th element must NOT be in 2nd half of B. search in entire A and 1st half of B.
    			return findMedianSortedArrays(A, startA, endA, B, startB, midB, k);
    		else
    			return findMedianSortedArrays(A, midA + 1, endA, B, startB, endB, k - n / 2 - 1);
    	}else{
    		if (k - 1 <= (n / 2 + m / 2))
    			return findMedianSortedArrays(A, startA, midA, B, startB, endB, k);
    		else
    			return findMedianSortedArrays(A, startA, endA, B, midB + 1, endB, k - m / 2 - 1);
    	}
    }
    
    
    
    
    
    
    
    
    
    /**
     * Solution #1
     * O(m + n)
     * O(m + n)
     * 540 ms
     */
    // public double findMedianSortedArrays(int A[], int B[]) {
        
    //     //Suppose both A and B are legal, and non-empty.
    //     int a = A.length, b = B.length, indexA = 0, indexB = 0, indexC = 0;
    //     double midDouble = (a + b) / 2.0;
        
    //     if((a+b) % 2 == 0) midDouble -= 1;
    //     else midDouble -= 0.5;
        
    //     int mid = (int)midDouble;
        
    //     if(a == 0 && b == 0) return 0;
        
    //     if(a == 0 && b != 0) {
    //     	if(b % 2 == 0) return (B[mid] + B[mid + 1] ) / 2.0;
    //     	else
    //     		return B[mid];
    //     }
    //     if(a != 0 && b == 0) {
    //     	if(a % 2 == 0) return (A[mid] + A[mid + 1] ) / 2.0;
    //     	else
    //     		return A[mid];
    //     }
        
    //     System.out.println("mid: " + mid);
        
    //     //a != 0 && b != 0
    //     int[] C = new int[a + b];
        
    //     while(indexC <= mid + 1){
    //         if(indexA <= a - 1 && indexB <= b - 1 && A[indexA] < B[indexB]){
    //             C[indexC] = A[indexA];
    //             indexA++;
    //         }else if(indexA <= a - 1 && indexB <= b - 1 && A[indexA] >= B[indexB]){
    //             C[indexC] = B[indexB];
    //             indexB++;
    //         }else if(indexA >= a && indexB <= b - 1) {
    //         	C[indexC] = B[indexB];
    //         	indexB++;
    //         }else if(indexB >= b && indexA <= a - 1) {
    //         	C[indexC] = A[indexA];
    //         	indexA++;
    //         }
    //         indexC++;
    //     }
    //     //indexC now is mid + 2;
    //     System.out.println(indexC);
    //     System.out.println(Arrays.toString(C));
        
        
    //     if((a+b) % 2 == 0)
    //         return (C[indexC - 2] + C[indexC - 1] ) / 2.0;
    //     return C[indexC - 2];
    // }
}