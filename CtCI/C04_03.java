public static TreeNode helper(int[] arr, int start, int end){
	if(start > end)
		return null;

	int mid = (start + end) / 2;
	TreeNode n = new TreeNode(arr[mid]);
	n.left = helper(arr[], start, mid - 1);
	n.right = helper(arr[], mid + 1, end);
	return n;
}



public static TreeNode createBST(int[] arr){
	return helper(arr, 0, arr.length - 1);
}