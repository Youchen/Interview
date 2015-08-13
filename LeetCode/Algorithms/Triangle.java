/**
 * Round 3
 *
 * O(n ^ 2) where n is the total row of the triangle.
 * O(n) - since only 2 rows.
 *  
 * proficient the technique for converting the space.
 *      - just % 2 to form a "turn-around array"(滚动数组)
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //2015-08-03 19:25:16 - 2015-08-03 19:36:11 (11 min)
        int size = triangle.size();
        if(triangle == null || size == 0)
            return 0;
            
        int[][] memo = new int[2][size];
        
        //initialize the last row
        for(int i = 0; i < size; i++){
            memo[(size - 1) % 2][i] = triangle.get(size - 1).get(i);
        }
        
        List<Integer> lastRow;
        for(int j = size - 2; j >= 0; j--){
            lastRow = triangle.get(j);
            
            for(int k = 0; k <= j; k++){
                memo[j % 2][k] = Math.min(memo[(j + 1) % 2][k], memo[(j + 1) % 2][k + 1]) + lastRow.get(k);
            }
        }
        return memo[0 % 2][0];
    }
}






/**
 * Round 2
 * Nice done!
 * Top down cost much more time.
 * 
 * Note:
 *      Don't get dissy!
 *      Pay attention to the triangle list and the 2D array!!
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //2015-05-22 15:54:22 - 2015-05-22 16:13:13 (19 min)
        //top down
        if(triangle == null)
            return 0;

        int size = triangle.size();
        int[][] memo = new int[size][size];

        //initialization
        memo[0][0] = triangle.get(0).get(0);

        //function
        for(int i = 1; i < size; i++){
            List<Integer> rowList = triangle.get(i);
            for(int j = 0; j <= i; j++){
                int leftParent = Integer.MAX_VALUE, rightParent = Integer.MAX_VALUE;

                if(j == 0){//only has right parent
                // leftParent = Integer.MAX_VALUE;
                    rightParent = memo[i - 1][j];
                }
                else if(j == rowList.size() - 1){
                    leftParent = memo[i - 1][j - 1];
                // rightParent = Integer.MAX_VALUE;
                }
                else{
                    leftParent = memo[i - 1][j - 1];
                    rightParent = memo[i - 1][j];
                }

                memo[i][j] = Math.min(leftParent, rightParent) + rowList.get(j);

            }
        }

        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < memo.length; i++){
            if(memo[memo.length - 1][i] < minValue)
                minValue = memo[memo.length - 1][i];
        }

        return minValue;
    }
}





/**
 * Round 2
 * Nice done!
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 2015-05-22 15:40:47 - 2015-05-22 15:53:51 (13 min)
        // bottom up
        if(triangle == null)
            return 0;

        int size = triangle.size();
        int[][] memo = new int[size][size];

        //initialization
        List<Integer> lastRow = triangle.get(size - 1);
        for(int i = 0; i < lastRow.size(); i++){
            memo[size - 1][i] = lastRow.get(i);
        }

        for(int i = size - 2; i >= 0; i--){
            lastRow = triangle.get(i);
            for(int j = 0; j <= i; j++){
                memo[i][j] = Math.min(memo[i + 1][j], memo[i + 1][j + 1]) + lastRow.get(j);
            }
        }

        return memo[0][0];
    }
}







public class Solution {
    /**
     * O(n)
     * O(n)
     * 268 ms
     * 
     * Try to use 2 DP arrays if one array is not enough or will messed up the procedure.
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.get(0) == null) return 0;

		ArrayList<Integer> al = new ArrayList<Integer>();
		ArrayList<Integer> al0 = new ArrayList<Integer>();

		al0.add( triangle.get(0).get(0) );
		al.add( triangle.get(0).get(0) );

//		System.out.println(al.toString());

		for(int i = 1; i < triangle.size(); i++){
			List<Integer> cur = triangle.get(i);
			al.add(0);

			for(int j = 1; j < cur.size() - 1; j++){
				al.set(j, Math.min(  al0.get(j - 1) + cur.get(j),   al0.get(j) + cur.get(j)   ));
			}

			//set 1st and last index
			al.set(0, al0.get(0) + cur.get(0));
			al.set(al.size() - 1, al0.get(al.size() - 2) + cur.get(cur.size() - 1));

			//append al0 to the size of al.
			al0.add(0);
			for(int k = 0; k < al.size(); k++)
				al0.set(k, al.get(k));
			
//			System.out.println(al.toString());
		}

		int min = al.get(0);
		for(int i = 1; i < al.size(); i++){
			if(al.get(i) < min)
				min = al.get(i);
		}

		return min;
		
		
		
		
		
        /**
         * 2nd Trial - fail
         * the modification of the list al is messed up.
         */
        // if(triangle == null || triangle.get(0) == null) return 0;
        
        // ArrayList<Integer> al = new ArrayList<Integer>();
        // al.add( triangle.get(0).get(0) );
        // // int min = al.get(0);//keep a min all the time.
        
        // for(int i = 1; i < triangle.size(); i++){
        //     List<Integer> cur = triangle.get(i);
        //     al.add(0);
            
        //     al.set(al.size() - 1, al.get(al.size() - 2) + cur.get(cur.size() - 1));
            
        //     //from index 1 to the index prior to the last index.
        //     for(int j = 1; j < cur.size() - 1; j++){
                
        //         al.set(j, Math.min(  al.get(j - 1) + cur.get(j),   al.get(j) + cur.get(j)   ) );
                
        //     }
            
        //     //set 1st and last index
        //     al.set(0, al.get(0) + cur.get(0));
        //     // al.set(al.size() - 1, al.get(al.size() - 2) + cur.get(cur.size() - 1));
        // }
        
        // int min = al.get(0);
        // for(int i = 1; i < al.size(); i++){
        //     if(al.get(i) < min)
        //         min = al.get(i);
        // }
        
        // return min;
        
        
        
        /**
         * 1st trial - Fail
         * This solution is going based on the min value that the path can touch,
         *      Does not consider the entire triangle case.
         */
        // if(triangle == null || triangle.get(0) == null) return 0;
        
        // int sum = triangle.get(0).get(0), index = 0;
        // for(int i = 1; i < triangle.size(); i++){
        //     List<Integer> cur = triangle.get(i);
            
        //     if(cur.get(index) < cur.get(index + 1) ){
        //         sum += cur.get(index);
        //     }
        //     else {
        //         sum += cur.get(index + 1);
        //         index = index + 1;
        //     }
        // }
        // return sum;
    }
}