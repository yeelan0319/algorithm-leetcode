import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, 3, 5);
        test(2, 2, 2);
        test(3, 1, 1);
    }

    public static void test(int testNo, int n, int expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        int res = numTrees(n);

//        if(head != null){
//            for(String x : head.levelOrderSerialization()) {
//                System.out.print(x + " ");
//            }
//        }
//        else {
//            System.out.print("null");
//        }
//        System.out.println("");
        if (res == expectValue) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }
    public static int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for(int i = 1; i < n + 1; i++) {
            int nums = 0;
            for(int j = 1; j < i + 1; j++) {
                nums += res[j - 1] * res[i - j];
            }
            res[i] = nums;
        }
        return res[n];
    }
}