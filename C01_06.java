/**
 * O(n^2)
 * 
 * Array
 */
public class C01_06 {
	//rotate counter-clock wise 90 degree.
	public static void rotate(int[][] matrix, int n) {

		int temp, layerIndex, layer;
		//for outer to inner
		for(layer = 0; layer <= n / 2 - 1; layer++) {
			//for this layer
			for(layerIndex = layer; layerIndex < n - 1 - layer; layerIndex++) {
				
				temp = matrix[layer][layerIndex];

				//right -> top
				matrix[layer][layerIndex] = matrix[layerIndex][n - 1 - layer];
				//bottom -> right
				matrix[layerIndex][n - 1 - layer] = matrix[n - 1 - layer][n - 1 - layerIndex];
				//left -> bottom
				matrix[n - 1 - layer][n - 1 - layerIndex] =  matrix[n - 1 - layerIndex][layer];
				//top -> left
				matrix[n - 1 - layerIndex][layer] = temp;
			}//for
		}//for
		/**
		 * for Testing purpose
		 * print modified matrix
		 */
		for(int[] i : matrix) {
			for(int j : i) 
				System.out.print(j + " ");
			System.out.println();
		}
	}
}
