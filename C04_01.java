

/**
 * DO THIS AGAIN
 * O(N^2) O(N)
 * 
 * Note:
 * 		Deep understand these 2 methods.
 */
public class C04_01 {
	/**
	 * Method #1
	 * O(n^2)
	 */
	public static boolean isBalanced(TreeNode n) {
		if(n == null) return true;
		int diff = Math.abs(height(n.left) - height(n.right));
		if(diff > 1)
			return false;
		else
			return isBalanced(n.left) && isBalanced(n.right);
	}
	
	public static int height(TreeNode t) {
		if(t == null) return 0;
		return Math.max(height(t.left), height(t.right)) + 1;
	}
	
	/**
	 * Method #2
	 * O(n)
	 */
	public boolean isBalanced_2(TreeNode n) {
		if(height_2(n) == -1)
			return false;
		return true;
	}
	public int height_2(TreeNode t) {
		if(t == null) return 0;
		
		int leftH = height_2(t.left);
			if(leftH == -1)
				return -1;
		
		int rightH = height_2(t.right);
			if(rightH == -1)
				return -1;
		
		int diff = Math.abs(leftH - rightH);
		if(diff > 1)
			return -1;
		else
			return Math.max(leftH, rightH) + 1;
	}
}
