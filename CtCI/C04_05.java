/**
 * DO THIS AGAIN
 */
/**
 * Initial consideration
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
		if(root == null) return true;

		int left, right;
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);

		while(! s.isEmpty()){
			TreeNode temp = s.pop();

			if(temp.val )
		}

	    if (root.left != null && root.left.val >= root.val)
	    	return false;
	    if (root.right != null && root.right.val <= root.val)
	    	return false;

    	return isValidBST(root.left) && isValidBST(root.right);
	}
}

/**
 *  If the BT does not have the duplicates, we could use inorder traversal.
 */
public static ArrayList<Integer> inOrder(TreeNode root){
	if(root == null) return null;

	ArrayList<Integer> al = new ArrayList<Integer>();
	al.addAll(inOrder(root.left.val));
	al.add(root.val);
	al.addAll(inOrder(root.right.val));
	return al;
}


public static boolean isBST(TreeNode root){
	ArrayList<Integer> al = inOrder(root);
	for(int i = 1; i < al.size(); i++)
		if(al.get(i) >= al.get(i - 1))
			return false;
	return true;
}








