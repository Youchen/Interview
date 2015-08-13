Bug-free Partition:
亲测！ 但是不能有 Duplilcates， 更完美的算法可以参考 lintcode Kth Largest Number.
	int[] nums = {7,4,2,6,3,1,5,9,8};
      
      Random r = new Random();
      int pivot = nums[r.nextInt((nums.length - 1 - 0) + 1) + 0];
      
      System.out.println(pivot);
      
      
        int i = 0;
        int j = nums.length - 1;
      
        while (i + 1 < j) {
            while (nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
      
        System.out.println(Arrays.toString(nums));
      












public class quickSort{
	public static void quickSort(int[] arr, int low, int high) {
		
		if (arr == null || arr.length == 0)
			return;
		
		if (low >= high)
			return;
		
		//pick the pivot
		int pivot = arr[rand(low, high)];
		
		//make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			
			while (arr[j] > pivot) {
				j--;
			}
			
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		
		//recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
		
		if (high > i)
			quickSort(arr, i, high);
	}
	
	//both inclusive
	public static int rand(int f, int t) {
		Random r = new Random();
		return r.nextInt((t - f) + 1) + f;
	}
}