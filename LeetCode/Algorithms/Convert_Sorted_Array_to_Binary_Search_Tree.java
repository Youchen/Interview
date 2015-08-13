/**
 * Round 4
 * 
 * Not proficient.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        //2015-07-31 22:30:08 - 2015-07-31 22:40:11 (10 min)
        if(nums == null || nums.length == 0)
            return null;
        
        int len = nums.length;
        return convert(nums, 0, len - 1);
    }
    private TreeNode convert(int[] nums, int start, int end){
        if(start > end)
            return null;
        
        int mid = start + (end - start) / 2;


        TreeNode root = new TreeNode(nums[mid]);//way 1
        root.left = convert(nums, start, mid - 1);//way 1



        //Above and below, either way will be fine.



        // TreeNode left = convert(nums, start, mid - 1);//way 2
        // TreeNode root = new TreeNode(nums[mid]);//way 2
        // root.left = left;//way 2



        root.right = convert(nums, mid + 1, end);
        
        return root;
    }
}







/**
 * Round 3
 * Nice done.
 * DO THIS AGAIN.
 * Not sure if I can make this right after couple of days.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        //2015-05-21 13:09:58 - 2015-05-21 13:14:04 (5 min)
        if(nums == null || nums.length == 0)
            return null;
        
        return buildTree(nums, 0, nums.length - 1);
        
    }
    private TreeNode buildTree(int[] nums, int start, int end){
        if(start > end)
            return null;
        
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid - 1);
        root.right = buildTree(nums, mid + 1, end);
        
        return root;
    }
}





/**
 * Round 3
 * Not so proficient!
 * DO THIS AGAIN!
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
    public TreeNode sortedArrayToBST(int[] nums) {
        //2015-05-20 20:18:32 - 2015-05-20 20:23:52 (5 min)
        if(nums == null || nums.length == 0)
            return null;
        
        return buildTree(nums, 0, nums.length - 1);
    }
    public TreeNode buildTree(int[] nums, int start, int end){
        if(start > end)
            return null;
        
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = buildTree(nums, start, mid - 1);
        TreeNode right = buildTree(nums, mid + 1, end);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}










/**
 * Round 2
 *
 * Optimized Algorithm
 * 294 ms
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null || num.length == 0)
            return null;
        return helper(num, 0, num.length - 1);
    }
    private TreeNode helper(int[] num, int left, int right){
        if(right < left)
            return null;
        
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = helper(num, left, mid - 1);
        root.right = helper(num, mid + 1, right);
        
        return root;
    }
}






/**
 * O(n)
 * O(log(num.length))
 * 289 ms
 * 
 * Note:
 *      the algorithm could be simplified.
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {//4/29 13:24 - 13:43 (19 min)
        if(num == null || num.length == 0)
            return null;
        TreeNode root = new TreeNode(num[num.length / 2]);
        return helper(num, root, 0, num.length - 1);
    }
    private TreeNode helper(int[] num, TreeNode root, int left, int right){
        if(right < left)
            return null;
            
        int mid = left + (right - left) / 2;
        root = new TreeNode(num[mid]);
        
        root.left = helper(num, root, left, mid - 1);
        root.right = helper(num, root, mid + 1, right);
        
        return root;
    }
}






/**
 * 1/29
 * DO THIS AGAIN.
 * 
 * 294 ms
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return createTree(num, 0, num.length - 1);
    }
    
    public TreeNode createTree(int[] arr, int start, int end){
        if(start > end)
            return null;
            
        int mid = (start + end) / 2;
        TreeNode t = new TreeNode(arr[mid]);
        t.left = createTree(arr, start, mid - 1);
        t.right = createTree(arr, mid + 1, end);
        return t;
    }
    
    
}