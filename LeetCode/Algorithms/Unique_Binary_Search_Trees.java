/**
 * Remember count[0] = 1 NOT 0
 *      since null tree IS A KIND of tree.
 */
public class Solution {
    public int numTrees(int n) {
        //2015-07-26 17:49:21 - 2015-07-26 17:56:58 (7 min)
        int[] count = new int[n + 1];
        count[0] = 1;// null tree;
        count[1] = 1;// only one node
        
        if(n <= 1)
            return 1;// since 1 <= n
            
        for(int i = 2; i <= n; i++)
            for(int j = 0; j < i; j++)
                count[i] += count[j] * count[i - 1 - j];
                
        return count[n];
    }
}




/**
 * Round 3
 * f[0] = 1 (null tree)
 * f[1] = 1
 * f[2] = f[0] * f[1] + f[1] * f[0] (left 0 nodes * right 1 nodes + <reversely>)
 * f[3] = f[0] * f[2] + f[1] * f[1] + f[2] * f[0]
 * ...
 * 
 * f[i] = f[0] * f[i - 1] + f[1] * f[i - 2] + ... + f[i - 1] * f[0]
 */
public class Solution {
    public int numTrees(int n) {
        //2015-06-28 17:08:23 - 2015-06-28 17:11:46 (3 min)
        if(n < 0)
            return 0;
        
        int[] count = new int[n + 1];
        count[0] = 1;
        
        if(n >= 1)
            count[1] = 1;
            
        for(int i = 2; i < n + 1; i++)
            for(int j = 0; j <= i - 1; j++)
                count[i] += count[j] * count[i - j - 1];
        
        
        return count[n];
    }
}





/**
 * Round 2
 */
public class Solution {
    public int numTrees(int n) {
        //2015-05-24 19:44:06 - 2015-05-24 19:49:13 (5 min)
        if(n < 0)
            return 0;
        
        int[] count = new int[n + 1];
        count[0] = 1;
        if(n >= 1)
            count[1] = 1;
        for(int i = 2; i < n + 1; i++){
            for(int j = 0, k = i - 1; j < i; j++, k--)
                count[i] += count[j] * count[k];
        }
        return count[n];
    }
}







/**
 * Round 2
 * O(n^2)
 * O(n)
 * 
 * Still cannot get the index right.
 */
public class Solution {
    public int numTrees(int n) {
        //5/25 19:27 pause 19:34 resume 19:36 - 19:42 (15 min)
        if(n < 0)
            return 0;
        if(n <= 1) 
            return 1;
        //tree[i] indicating how many trees can be formed if we 
        //have i nodes.
        int[] tree = new int[n + 1];
        
        tree[0] = 1;//empty tree null
        tree[1] = 1;//root only tree.
        
        for(int i = 2; i < n + 1; i++){
            for(int j = 0; j < i; j++)
                tree[i] += tree[j] * tree[i - j - 1];
        }
        return tree[n];
    }
}





/**
 * HARD TO THINK
 * DO THIS AGAIN.
 * 
 * O(n^2)
 * O(n)
 * 171 ms
 */
public class Solution {
    public int numTrees(int n) {
        if(n <= 1) return 1;
        
        int[] trees = new int[n + 1];
        trees[0] = 1;
        trees[1] = 1;
        
        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= i - 1; j++){
                trees[i] += trees[j] * trees[i - j - 1];
            }
        }
        
        return trees[n];
        
    }
}