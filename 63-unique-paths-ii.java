import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[][]{{0,0,0}, {0,1,0},{0,0,0}}, 2);
    }

    public static void test(int testNo, int[][] obstacleGrid, int expectValue) {
        int res = uniquePathsWithObstacles(obstacleGrid);

//        for(int[] row : matrix) {
//            for(int i : row) {
//                System.out.print(i + " ");
//            }
//            System.out.println("");
//        }
//        System.out.println("");
        if (res == expectValue) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = m == 0? 0 : obstacleGrid[0].length;
        if(m == 0 || n == 0) return 0;
        int[][] uniquePaths = new int[m][n];
        for(int i = 0; i < m && obstacleGrid[i][n - 1] != 1; i++) {
            uniquePaths[i][n - 1] = 1;
        }
        for(int i = 0; i < n && obstacleGrid[m - 1][i] != 1; i++ ) {
            uniquePaths[m - 1][i] = 1;
        }
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                uniquePaths[i][j] = obstacleGrid[i][j] == 0? uniquePaths[i + 1][j] + uniquePaths[i][j + 1] : 0;
            }
        }
        return uniquePaths[0][0];
    }
}