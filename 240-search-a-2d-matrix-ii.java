public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0) {
			return false;
		}
		int m = matrix.length - 1;
		int n = matrix[0].length - 1;
		int startrow = 0;
		int endrow = m;
		int startcol = 0;
		int endcol = n;
		return searchMatrixHelper(matrix, startrow, endrow, startcol, endcol, target);
	}

	public boolean searchMatrixHelper(int[][] matrix, int startrow, int endrow, int startcol, int endcol, int target) {
		if(startcol > endcol || startrow > endrow) {
			return false;
		}
		int centerrow = (startrow + endrow) / 2;
		int centercol = (startcol + endcol) / 2;
		if(matrix[centerrow][centercol] == target) {
			return true;
		}
		else if(matrix[centerrow][centercol] > target) {
			return searchMatrixHelper(matrix, startrow, centerrow - 1, startcol, centercol - 1, target) ||
		    searchMatrixHelper(matrix, centerrow, endrow, startcol, centercol - 1, target) ||
		    searchMatrixHelper(matrix, startrow, centerrow - 1, centercol, endcol, target);
		}
		else {
			return searchMatrixHelper(matrix, centerrow + 1, endrow, centercol + 1, endcol, target) ||
			  searchMatrixHelper(matrix, startrow, centerrow, centercol + 1, endcol, target) ||
			  searchMatrixHelper(matrix, centerrow + 1, endrow, startcol, centercol, target);
		}
	}
}