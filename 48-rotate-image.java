public class Solution {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int i = 0;
		while(i < n / 2) {
			for(j = i; j < n - i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = matrix[n - i][n - j - 1];
				matrix[n - i][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = tmp;
			}
		}
	}
}