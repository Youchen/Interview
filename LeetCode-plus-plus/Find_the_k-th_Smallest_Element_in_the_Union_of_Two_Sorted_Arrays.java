/**
 * 4/16 (9 min)
 * Find the k-th Smallest Element in the Union of Two Sorted Arrays 
 *
 * Given two sorted arrays A, B of size m and n respectively. 
 * Find the k-th smallest element in the union of A and B. 
 * You can assume that there are no duplicate elements. 
 *
 * This algorithm is related to the problem:
 *			Median of Two sorted Arrays.
 *
 * Reference:
 * 		http://articles.leetcode.com/2011/01/find-k-th-smallest-element-in-union-of.html
 */
//As = Astart (inclusive), Ae = Aend (exclusive).
public double f(int A[], int As, int Ae, int B[], int Bs, int Be, int k){//20:55 - 21:04 (9 min)
	//range
	int m = Ae - As;
	int n = Be - Bs;

	if(m <= 0 && n <= 0)
		return 0;
	if(m <= 0 && n > 0)
		return B[Bs + k - 1];
	if(m < 0 && n <= 0)
		return A[As + k - 1];

	//below is the case if both m, n > 0
	int midA = As + (Ae - As) / 2;
	int midB = Bs + (Be - Bs) / 2;

	if(A[midA] <= B[midB]){
		if(k - 1 <= (m / 2 + n / 2))//drop B2
			return f(A, As, Ae, B, Bs, midB, k);
		else//drop A1
			return f(A, midA + 1, Ae, B, Bs, Be, k - m / 2 - 1);
	}else{//>
		if(k - 1 <= (m / 2 + n / 2))//drop A2
			return f(A, As, midA, B, Bs, midB, k);
		else//drop B1
			return f(A, As, Ae, B, midB + 1, Be, k - n / 2 - 1);
	}
}