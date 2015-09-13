/**
 * Hard to think.
 * Review.
 * 
 * 
 * Reference:
 *      https://leetcode.com/discuss/56983/simple-java-dp-solution
 */
public class Solution{
	public int numSquares(int n){
		int[] f = new int[n + 1];
		Arrays.fill(f, Integer.MAX_VALUE);

		f[0] = 0;
		
		for(int i = 0; i <= n; i++){
			for(int j = 1; i + j*j <= n; j++){
				f[i + j*j] = Math.min(f[i + j*j], f[i] + 1);
			}
		}
		return f[n];
	}
}