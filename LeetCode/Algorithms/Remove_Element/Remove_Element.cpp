/**
 * O(n)
 * 14 ms
 * 
 * Array
 */
class Solution {
public:
    int removeElement(int A[], int n, int elem) {
        int size = 0;
		for (int i = 0; i < n; ++i) 
			if (A[i] != elem) 
				A[size++] = A[i];
			
		return size;
    }
};