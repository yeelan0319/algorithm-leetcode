import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new ArrayList<List<Integer>>(){
            {
                add(new ArrayList<Integer>(Arrays.asList(2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4)));
                add(new ArrayList<Integer>(Arrays.asList(6, 5, 7)));
                add(new ArrayList<Integer>(Arrays.asList(4, 1, 8, 3)));
            }
        }, 11);
    }

    public static void test(int testNo, List<List<Integer>> triangle, int expectValue) {
        int res = minimumTotal(triangle);

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

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] min = new int[n];
        for(int i = 0; i < n; i++) {
            min[i] = triangle.get(n - 1).get(i);
        }
        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j < i + 1; j++) {
                min[j] = Math.min(min[j], min[j + 1]) + triangle.get(i).get(j);
            }
        }
        return min[0];
    }
}