public static int height(TreeNode t){
	if(t == null) return 0;
	return Math.max( height(t.left), height(t.right) ) + 1;
}

public static boolean isBalance(TreeNode t){
	if(t == null) return true;

	int diff = height(t.left) - height(t.right);
	if(diff > 1)
		return false;
	else
		return isBalance(t.left) && isBalance(t.right);
}





public static int height(TreeNode t){
	if(t == null) return 0;

	/*check left*/
	int lH = height(t.left);
	if(lH == -1)
		return -1;

	int rH = height(t.right);
	if(rH = -1)
		return -1;

	int diff = Math.abs(lH - rH);
	if(diff > 1)
		return -1;
	else
		return Math.max(lH, rH) + 1;
}

public static boolean isBalanced(TreeNode t){
	if(height(t) == -1)
		return false;
	return true;
}
















