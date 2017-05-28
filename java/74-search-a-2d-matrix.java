public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length == 0) {
    	return false;
    }		
    int m = matrix.length;
    int n = matrix[0].length;
    int start = 0;
    int end = m * n - 1;

    while(start <= end) {
    	int center = (start + end) / 2;
    	int row = center / n;
    	int col = center % n;
    	if(matrix[row][col] == target) {
    		return true;
    	}
    	else if(matrix[row][col] < target) {
    		start = center + 1;
    	}
    	else {
    		end = center - 1;
    	}
    }
    return false;
	}
}