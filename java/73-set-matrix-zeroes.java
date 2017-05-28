import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[][]{{1,1},{1,1}}, 6);
        test(2, new int[][]{{1,0,3},{0,1,2}}, 0);
        test(3, new int[][]{{1,1,0},{2,2,1}}, 3);
    }

    public static void test(int testNo, int[][] matrix, int expectValue) {
        setZeroes(matrix);

        for(int[] row : matrix) {
            for(int i : row) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
        System.out.println("");
//        if (res == expectValue) {
//            System.out.println(testNo + ": Pass");
//        } else {
//            System.out.println(testNo + ": Fail");
//            System.out.println("Expect " + expectValue + ", Return " + res);
//        }
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = m == 0? 0 : matrix[0].length;
        if(m == 0 || n == 0) return;
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        for(int i = 0; i < m; i++) {
            firstColHasZero = matrix[i][0] == 0? true : firstColHasZero;
        }
        for(int j = 0; j < n; j++) {
            firstRowHasZero = matrix[0][j] == 0? true : firstRowHasZero;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstColHasZero) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if(firstRowHasZero) {
            for(int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}