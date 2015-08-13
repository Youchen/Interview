public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        //2015-06-02 20:34:49 - 2015-06-02 20:41:48 (7 min)
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while(! q.isEmpty() ){
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                
                list.add(temp.val);
                if(temp.left != null)
                    q.offer(temp.left);
                if(temp.right != null)
                    q.offer(temp.right);
            }
            res.add(new ArrayList<Integer>(list));
        }
        return res;
    }
}

