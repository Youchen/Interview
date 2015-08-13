public class Solution {
    public int maxPathSum(TreeNode root) {
        //2015-06-02 19:33:11 - 2015-06-02 20:22:52 (49 min)
        if(root == null)
            return 0;
        
        //max (root, root.val + left, root.val + right, root.val + left + right)
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        
        findMax(root, max);
        return max[0];
    }
    private int findMax(TreeNode root, int[] max){
        if(root == null)
            return 0;
        
        int left = findMax(root.left, max);
        int right = findMax(root.right, max);
        
        int singleMax = Math.max(root.val,
                            Math.max(root.val + left, root.val + right
                                ));
        max[0] = Math.max(singleMax,
                Math.max(max[0], root.val + left + right
                        ));
        return singleMax;
    }
}