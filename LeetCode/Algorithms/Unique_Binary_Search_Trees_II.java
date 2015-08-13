/**
 * Review.
 * Not easy to code right.
 * 
 * Reference:
 *      http://blog.csdn.net/linhuanmars/article/details/24761437
 * 
 * 这道题是求解所有可行的二叉查找树，从Unique Binary Search Trees中我们已经知道，
 * 可行的二叉查找树的数量是相应的卡特兰数，不是一个多项式时间的数量级，所以我们要
 * 求解所有的树，自然是不能多项式时间内完成的了。
 * 
 * 算法上还是用求解NP问题的方法来求解，也就是N-Queens中介绍的在循环中调用递归函数
 * 求解子问题。
 * 
 * 思路是每次一次选取一个结点为根，然后递归求解左右子树的所有结果，最后根据左右子
 * 树的返回的所有子树，依次选取然后接上（每个左边的子树跟所有右边的子树匹配，而每
 * 个右边的子树也要跟所有的左边子树匹配，总共有左右子树数量的乘积种情况），构造好
 * 之后作为当前树的结果返回。
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        //2015-07-26 18:13:18 - 2015-07-26 18:19:28 (6 min)
        return helper(1, n);
    }
    private ArrayList<TreeNode> helper(int start, int end){
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        
        if(start > end){
            res.add(null);
            return res;
            // return null;// can not write as this line.
        }
        
        for(int i = start; i <= end; i++){
            ArrayList<TreeNode> leftList = helper(start, i - 1);
            ArrayList<TreeNode> rightList = helper(i + 1, end);
            
            for(int j = 0; j < leftList.size(); j++){
                for(int k = 0; k < rightList.size(); k++){
                    TreeNode root = new TreeNode(i);
                    
                    root.left = leftList.get(j);
                    root.right = rightList.get(k);
                    
                    res.add(root);
                }
            }
        }
        return res;
    }
}





/**
 * Recursion solution.
 * similar to the permutation one.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        //2015-06-28 22:58:07 - 2015-06-28 23:04:03 (6 min)
        return helper(1, n);
    }
    private ArrayList<TreeNode> helper(int start, int end){
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        
        if(start > end){
            res.add(null);
            return res;
        }
        
        for(int i = start; i <= end; i++){
            ArrayList<TreeNode> leftList = helper(start, i - 1);
            ArrayList<TreeNode> rightList = helper(i + 1, end);
            
            for(int j = 0; j < leftList.size(); j++){
                for(int k = 0; k < rightList.size(); k++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftList.get(j);
                    root.right = rightList.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}