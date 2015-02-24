public ArrayList<LinkedList<TreeNode>> createLL(TreeNode root){
	ArrayList<LinkedList<TreeNode>> al;
	if(root == null)
		return al;

	al = new ArrayList<LinkedList<TreeNode>>();
	LinkedList<TreeNode> ll = new LinkedList<TreeNode>()

	ll.add(root);

	while(ll.size() > 0){
		al.add(ll);
		LinkedList<TreeNode> parent = ll;
		ll = new LinkedList<TreeNode>();

		for(TreeNode t : parent){
			if(t.left != null)
				ll.add(t.left);
			if(t.right != null)
				ll.add(t.right);
		}
	}
	return al;

}