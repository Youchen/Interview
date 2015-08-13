public class Solution {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        //2015-05-28 02:23:58 - 2015-05-28 02:33:11 (10 min)
        if(n <= 1)
            return 1;
        /**
         *  0 - 1 null tree
            1 - 1 root only tree
            
            2 - c[0] * c[1] + c[1] * c[0]
            3 - c[0] * c[2] + c[1] * c[1] + c[2] * c[0]
        */
        int[] treeCount = new int[n + 1];
        treeCount[0] = 1;
        treeCount[1] = 1;
        
        for(int i = 2; i < n + 1; i++){
            for(int j = 0, k = i - 1; j <= i - 1; j++, k--)
                treeCount[i] += treeCount[j] * treeCount[k];
        }
        
        return treeCount[n];
    }
}

