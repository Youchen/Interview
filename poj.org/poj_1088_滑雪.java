import java.util.Scanner;

public class Main {
    public static int longestIncreasingContinuousSubsequenceII(int[][] A) {
        if(A == null || A.length == 0)
            return 0;
        
        int row = A.length, col = A[0].length;
        int[][] memo = new int[row][col];
        
        int max = 0;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(memo[i][j] == 0){
                    max = Math.max(max, find(A, i, j, memo) );
                }
            }
        }
        
        return max;
    }
    
    private static int find(int[][] A, int row, int col, int[][] memo){
        if(memo[row][col] != 0)
            return memo[row][col];

        int left = 0, right = 0, up = 0, down = 0;

        if(col + 1 < memo[0].length && A[row][col] < A[row][col + 1]){
            right = find(A, row, col + 1, memo);
        }
            
        if(row + 1 < memo.length && A[row][col] < A[row + 1][col]){
            down = find(A, row + 1, col, memo);
        }
        
        if(col - 1 >= 0 && A[row][col] < A[row][col - 1]){
            left = find(A, row, col - 1, memo);
        }
        
        if(row - 1 >= 0 && A[row][col] < A[row - 1][col]){
            up = find(A, row - 1, col, memo);
        }
        
        memo[row][col] = Math.max(Math.max(up, down), Math.max(left, right)) + 1;

        return memo[row][col];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int r = in.nextInt();
        int c = in.nextInt();

        int[][] A = new int[r][c];

        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
                A[i][j] = in.nextInt();

        System.out.println(longestIncreasingContinuousSubsequenceII(A));
    
    }
}