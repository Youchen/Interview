/** 
 * Bianry Tree BFS
 *
 * Problem "Binary Tree Level Order Traversal"
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        //2015-05-19 17:51:48 - 2015-05-19 18:00:31 (9 min)
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while(! q.isEmpty()){
            ArrayList<Integer> list = new ArrayList<Integer>();
            int size = q.size();
            
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
