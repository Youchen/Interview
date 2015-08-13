public class MergeSort_Stanford{
	/**
	 *  2015-05-19 15:33:01
	 *	https://github.com/girum11/stanford-algorithms/blob/master/src/io/girum/stanford/week1/mergesort/Mergesort.java
	 */
	public static int[] mergesort(int[] array) {
		if (array.length <= 1) {
			return array;
		}

		// Sort left half.
		int[] leftHalf = mergesort(Arrays.copyOfRange(array, 0, array.length / 2));

		// Sort right half.
		int[] rightHalf = mergesort(Arrays.copyOfRange(array, array.length / 2, array.length));

		// Merge the sorted halves.
		return merge(leftHalf, rightHalf);
	}


	private static int[] merge(int[] leftHalf, int[] rightHalf) {
		int i = 0, j = 0, k = 0;
		int[] mergedArray = new int[leftHalf.length + rightHalf.length];

		// Steps through the halves as long as both sides don't step off of their respective edges.
		while (i < leftHalf.length && j < rightHalf.length) {
			if (leftHalf[i] < rightHalf[j]) {
				mergedArray[k] = leftHalf[i];
				i++;
			} else {
				mergedArray[k] = rightHalf[j];
				j++;
			}

			k++;
		}

		// Copy over any remaining elements from each of the remaining halves.
		for (; i < leftHalf.length; i++, k++) {
			mergedArray[k] = leftHalf[i];
		}

		for (; j < rightHalf.length; j++, k++) {
			mergedArray[k] = rightHalf[j];
		}

		return mergedArray;
	}
}

























//old version
public class _xx_MergeSort {
	public static int[] concat(int a, int[] b) {
		int[] c = new int[1 + b.length];
		c[0] = a;
		int indexC = 1;
		for (int bElement : b) {
			c[indexC++] = bElement;
		}
		return c;
	}
	/*
	 * def merge( A, B ):
			if empty( A ):
				return B
			if empty( B ):
				return A
			if A[ 0 ] < B[ 0 ]:
				return concat( A[ 0 ], merge( A[ 1...A_n ], B ) )
			else:
				return concat( B[ 0 ], merge( A, B[ 1...B_n ] ) )
	 */
	public static int[] merge(int[] a, int[] b) {
		if(a.length == 0) return b;
		if(b.length == 0) return a;
		if(a[0] < b[0]) {
			int[] a1_end = new int[a.length - 1];
			int a1_endIndex = 0;
			for (int i = 1; i < a.length; i++) {
				a1_end[a1_endIndex++] = a[i];
			}
			return concat( a[0], merge(a1_end, b));
		}
		else {
			int[] b1_end = new int[b.length - 1];
			int b1_endIndex = 0;
			for (int i = 1; i < b.length; i++) {
				b1_end[b1_endIndex++] = b[i];
			}
			return concat( b[0], merge(a, b1_end));
		}
	}
	/*
	 * def mergeSort( A, n ):
		if n = 1:
			return A # it is already sorted
		middle = floor( n / 2 )
		leftHalf = A[ 1...middle ]
		rightHalf = A[ ( middle + 1 )...n ]
		return merge( mergeSort( leftHalf, middle ), mergeSort( rightHalf, n - middle ) )
	 */
	public static int[] mergeSort(int[] arr, int length) {
		int middle;

		if(length == 1) return arr;
		
		middle = Math.floorDiv(length, 2);
		
		int[] left = new int[middle];
		for (int i = 0; i <= middle - 1; i++) {
			left[i] = arr[i];
		}
		
		int[] right = new int[length - middle];
		int rightIndex = 0;
		for (int i = middle; i <= length - 1; i++) {
			right[rightIndex++] = arr[i];
		}
		
		return merge( mergeSort(left, middle), mergeSort(right, length - middle) );
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 4, 1, 3, 5};
		arr = mergeSort(arr, arr.length);
		for(int i : arr) {
			System.out.println(i);
		}
	}
}
