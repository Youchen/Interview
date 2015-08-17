/**
 * Google
 *
 *	Write a function to convert the array into alternate increasing decreasing numbers:
 *		a[0] <= a[1] >= a[2] <= a[3] >=...
 *
 * 	Note: You should solve it in place and one pass.
 */
public void wiggle_Sort(int[] arr){
	if(arr == null || arr.length == 0)
			return;
	
	int len = arr.length;
	int pre = arr[0];
	boolean inc = true;
	
	for(int i = 1; i < len; i++) {
		if( (inc && pre <= arr[i]) ||
			(!inc && pre >= arr[i])) {
			arr[i - 1] = pre;
			pre = arr[i];
		}
		else
			arr[i - 1] = arr[i];
		
		inc = !inc;
	}
	arr[len - 1] = pre;
}