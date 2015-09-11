import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, 2, 2, 2);
        test(2, 1, 5, 1);
        test(3, 3, 4, 10);
    }

    public static void test(int testNo, int m, int n, int expectValue) {
        int res = uniquePaths(m, n);

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

    public static int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 0;
        int[][] uniquePaths = new int[m][n];
        for(int i = 0; i < m; i++) {
            uniquePaths[i][n - 1] = 1;
        }
        for(int i = 0; i < n; i++ ) {
            uniquePaths[m - 1][i] = 1;
        }
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                uniquePaths[i][j] = uniquePaths[i + 1][j] + uniquePaths[i][j + 1];
            }
        }
        return uniquePaths[0][0];
    }
}