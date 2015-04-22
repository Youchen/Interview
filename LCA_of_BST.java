/**
 *	Problem:
 *		http://articles.leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-search-tree.html
 * According to Wikipedia:
 *		where we allow a node to be a descendant of itself
 */



/**BST no duplicates - iterative approach
 * 4/22 15:26 - 15:30 (4 min)
 * O(h) h = BS height
 * O(1)
 */
public Node lca(Node root, Node u, Node v){
	if(root == null || u == null || v == null)
		return null;

	while(true){
		if(root.val < Math.min(u.val, v.val))
			root = root.right;
		else if (root.val > Math.max(u.val, v.val)) 
			root = root.left;
		else
			return root;
	}
}


/** BST no duplicates - recursive approach
 * 4/22 15:34 - 15:36 (2 min)
 * O(h) h = height
 * O(1)
 */
public Node lca(Node root, Node u, Node v){
	if(root == null || u == null || v == null)
		return null;

	if(root.val < Math.min(u.val, v.val))
		lca(root.right, u, v);
	else if (root.val > Math.max(u.val, v.val)) 
		lca(root.left, u, v);
	else
		return root;
}


