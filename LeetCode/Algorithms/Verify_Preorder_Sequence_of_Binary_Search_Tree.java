/**
 * O(n)
 * O(1)
 * 
 * Hard to think O(1) space way.
 * Need to pollute the original array.
 *
 * Reference:
 *		https://leetcode.com/discuss/51543/java-o-n-and-o-1-extra-space
 *		http://www.snippetexample.com/2015/03/verify-preorder-sequence-in-binary-search-tree/
 */
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        //2015-08-15 19:17:59 - 2015-08-15 19:23:54
        if(preorder == null || preorder.length == 0)
            return true;
        
        int leftHightest = Integer.MIN_VALUE;
        int i = -1;
        
        for(int e : preorder){
            if(e < leftHightest)
                return false;
                
            while(i >= 0 && e > preorder[i])
                leftHightest = preorder[i--];
                
            preorder[++i] = e;
        }
        return true;
    }
}





/**
 * O(n)
 * O(n)
 * 
 * Note:
 *      Practice more, a little confusing
 * 
 * Regards the tree traversal, see the graph 
 * 		http://www.cs.cmu.edu/~pattis/15-1XX/15-200/lectures/treeprocessing/images/traversals.gif
 *
 *
 * Reference:
 *		https://leetcode.com/discuss/51543/java-o-n-and-o-1-extra-space
 *		http://www.snippetexample.com/2015/03/verify-preorder-sequence-in-binary-search-tree/
 */
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        //2015-08-14 21:40:46 (first meet time)
        //2015-08-15 17:15:49 - 2015-08-15 17:18:33
        if(preorder == null || preorder.length <= 1)
            return true;
        
        Stack<Integer> s = new Stack<Integer>();
        int leftHighest = Integer.MIN_VALUE;
        
        for(int i: preorder){
            if(i < leftHighest)
                return false;
                
            while(! s.isEmpty() && i > s.peek())
                leftHighest = s.pop();
            
            s.push(i);
        }
        return true;  
    }
}