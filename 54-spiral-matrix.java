import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 1);
        test(2, new int[][]{{1,2},{3, 4}}, 4);
        test(3, new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}, 9);
    }

    public static void test(int testNo, int[][] matrix, int expectValue) {
        rotate(matrix);

        for(int[] row : matrix) {
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

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int i = 0;
        while(i < n / 2) {
            int start = i;
            int end = n - i - 1;
            for(int j = 0; j < end - start; j++) {
                int tmp = matrix[start][start + j];
                matrix[start][start + j] = matrix[end - j][start];
                //System.out.println("(" + start + "," + (start + j) + ")<-(" + (end - j) + "," + start + ")");
                matrix[end - j][start] = matrix[end][end - j];
                //System.out.println("(" + (end - j) + "," + start + ")<-(" + end + "," + (end - j) + ")");
                matrix[end][end - j] = matrix[start + j][end];
                //System.out.println("(" + end + "," + (end - j) + ")<-(" + (start + j) + "," + end + ")");
                matrix[start + j][end] = tmp;
                //System.out.println("(" + (start + j) + "," + end + ")<-(" + start + "," + (start + j) + ")");
            }
            i++;
        }
    }
}