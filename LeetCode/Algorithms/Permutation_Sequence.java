/**
 * Round 3
 * Review!
 * 
 * Reference:
 *      http://www.cnblogs.com/springfor/p/3896201.html
 * 发现数学规律。
 * 
 * 首先先捋捋这道题要干啥，给了我们n还有k，在数列 1，2，3，... , n构建的全排列中，返回第k个排列。
 * 
 * 题目告诉我们：对于n个数可以有n!种排列；那么n-1个数就有(n-1)!种排列。
 * 
 * 那么对于n位数来说，如果除去最高位不看，后面的n-1位就有 (n-1)!种排列。
 * 
 * 所以，还是对于n位数来说，每一个不同的最高位数，后面可以拼接(n-1)!种排列。
 * 
 * 所以你就可以看成是按照每组(n-1)!个这样分组。 
 * 
 * 利用 k/(n-1)! 可以取得最高位在数列中的index。这样第k个排列的最高位就能从数列中的index位取得，此时还要把这个数从数列中删除。
 * 
 * 然后，新的k就可以有k%(n-1)!获得。循环n次即可。
 * 
 * 同时，为了可以跟数组坐标对其，令k先--。
 * 
 */
public class Solution {
    public String getPermutation(int n, int k) {
        if(k <= 0)
            return "";

        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++)
            nums.add(i);

        //compute for (n - 1)!
        int factorial = 1;
        for(int i = 2; i <= n - 1; i++)
            factorial *= i;

        //for the index of nums, ex: 1 will be at index 0 instead of index 1
        k--;
        
        StringBuilder res = new StringBuilder();
        int time = n - 1;
        
        while(time >= 0){
            int leftMostNumIndex = k / factorial;
            res.append(nums.get(leftMostNumIndex));
            nums.remove(leftMostNumIndex);
            
            //next round k
            k %= factorial;
            
            //next round factorial
            if(time != 0)
                factorial /= time;
            
            time--;
        }
        return res.toString();
    }
}

/**
 * Round 2 - Math way
 * DO THIS AGAIN
 */
public class Solution {
    public String getPermutation(int n, int k) {//2015-05-06 23:39:36 -  2015-05-06 23:48:50 (9 min)
        if(k <= 0)
            return "";
            
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }
        
        //compute for (n - 1)!;
        int factorial = 1;
        for(int i = 2; i <= n - 1; i++){
            factorial *= i;
        }
        
        k--;
        StringBuilder res = new StringBuilder();
        int time = n - 1;
        while(time >= 0){
            int leftNumIndex = k / factorial;
            res.append(nums.get(leftNumIndex));
            nums.remove(leftNumIndex);
            
            //next round k
            k = k % factorial;
            
            //next round factorial
            if(time != 0)
                factorial /= time;
            
            time--;
        }
        return res.toString();
    }
}





/**
 * Round 2 - template needs to be proficient
 * THIS SOLUTION IS TLE. Math way is the best solution.
 * 
 * DO THIS AGAIN.
 * 
 * Note:
 *      for the template, try to avoid use the wiered data structures like stringbuilder.
 *      key structure of the template is
 *          ArrayList<T> res, T list, (parameter in solution function), boolean[] visited / int pos
 *          
 *          for the visited array
 *              if you cannot control the visited position, use boolean array.
 *              else, just use int type pos.
 */
public class Solution {
    public String getPermutation(int n, int k) {//2015-05-06 18:25:57 - 2015-05-06 18:40:15 (15 min)
        if(k <= 0)
            return "";
            
        ArrayList<String> res = new ArrayList<String>();
        boolean[] visited = new boolean[n + 1];
        
        helper(n, k, res, new StringBuilder(), visited);
        return res.get(k - 1);
    }
    private void helper(int n, int k, ArrayList<String> res, StringBuilder list, boolean[] visited){
        if(list.length() == n){
            res.add(list.toString());
            return;
        }
        
        for(int i = 1; i <= n; i++){
            if(! visited[i]){
                
                list.append(i);
                visited[i] = true;
                
                helper(n, k, res, list, visited);
                
                list.deleteCharAt(list.length() - 1);
                visited[i] = false;
            }
        }
    }
}





/**
 * O(n)
 * O(n)
 * 213 ms
 * 
 * Note:
 *      This problem is kinda Math one. Not using the backtracking algorithm.
 * 
 * Reference:
 *      http://www.cnblogs.com/springfor/p/3896201.html
 */
public class Solution {
    public String getPermutation(int n, int k) {
        //Given n will be between 1 and 9 inclusive.
        //      So no need for check the possibility of n.
        
        //Make a interger sequence list.
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++)
            list.add(i);
            
        //calculate (n - 1)!
        int factorial = 1;
        for(int i = 2; i <= n - 1; i++)
            factorial *= i;
         
        //In order to determine the INDEX of the 1st number in the kth sequence, 
        //      calculate the k / (n - 1)!   
        k--;
        // int FirstNumIndex = k / factorial;
    
        //Use StringBuilder to make the sequence.
        StringBuilder sb = new StringBuilder();
        int time = n - 1;
        while(time >= 0){
            int FirstNumIndex = k / factorial;
            sb.append(list.get(FirstNumIndex));
            list.remove(FirstNumIndex);
            
            //for the next round.
            k = k % factorial;//the new k;
            
            if(time != 0)
                factorial /= time;//the new (n - 1)!
            
            time--;
        }
        return sb.toString();
    }
}