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






/**
 * BT - recursive
 * O(n)
 * O(h) - h is the height of the tree.
 *
 * Reference: 
 * 		http://articles.leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-tree-part-i.html
 */
public Node lca(Node root, Node p, Node q){
	if(root == null) 
		return null;
	if(root == p || root == q)
		return root;

	Node left = lca(root.left, p, q);
	Node right = lca(root.right, p, q);

	if(left != null && right != null)
		return root;
	return (left != null) ? left : right;
}



/**
 *	BT - iterative ?
 */







/**
 * BT - with parent pointer
 * Reference:
 * 		http://www.shuatiblog.com/blog/2014/06/10/Lowest-Common-Ancestor-Tree-II/
 */
public Node lca(Node root, Node u, Node v){
	int h1 = getHeight(u);
	int h2 = getHeight(v);

	//swap if u is deeper than v
	if(h1 > h2){
		swap(h1, h2);
		swap(u, v);
	}

	//so here, h1 <= h2
	int dh = h2 - h1;
	for(int h = 0; h < dh; h++)
		u = u.parent;

	while(u != null && v != null){
		if( u == v ) return u;
		u = u.parent;
		v = v.parent;
	}
}

private int getHeight(Node u){
	int height = 0;
	while(u != null){
		height++;
		u = u.parent;
	}
	return height;
}












