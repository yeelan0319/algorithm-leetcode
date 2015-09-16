import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[]{1,2,3,4,5}, 0);
        test(2, new int[]{1,2,3,0,5}, 4);
        test(3, new int[]{1,2,0,3,4,6}, 5);
    }

    public static void test(int testNo, int[] nums, int expectValue) {
        int res = missingNumber(nums);

//        System.out.println(res);
//        System.out.println("");
        if (res == expectValue) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return n * (n + 1) / 2 - sum;
    }
}