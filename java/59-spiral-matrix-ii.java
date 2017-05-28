import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, 1, 1);
        test(2, 2, 4);
        test(3, 3, 9);
    }

    public static void test(int testNo, int n, int expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
       int[][] res = generateMatrix(n);

        for(int[] row : res) {
            for(int i : row) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
        System.out.println("");
//        if (res.equals(expectValue)) {
//            System.out.println(testNo + ": Pass");
//        } else {
//            System.out.println(testNo + ": Fail");
//            System.out.println("Expect " + expectValue.toString() + ", Return " + res.toString());
//        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i = 0;
        int el = 1;
        while(i < (n + 1) / 2) {
            for(int j = i; j < n - i; j++) {
                matrix[i][j] = el++;
            }
            for(int j = i + 1; j < n - i; j++) {
                matrix[j][n - i - 1] = el++;
            }
            if(n - i - 1 > i) {
                for(int j = n - i - 2; j >= i; j--) {
                    matrix[n - i - 1][j] = el++;
                }
                for(int j = n - i - 2; j >= i + 1; j--) {
                    matrix[j][i] = el++;
                }
            }
            i++;
        }
        return matrix;
    }
}