import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[]{1,2,5,2,6,1,6}, 0);
    }

    public static void test(int testNo, int[] nums, int expectValue) {
        int res = findPeakElement(nums);

        System.out.println(res);
//        System.out.println("");
//        if (res == expectValue) {
//            System.out.println(testNo + ": Pass");
//        } else {
//            System.out.println(testNo + ": Fail");
//            System.out.println("Expect " + expectValue + ", Return " + res);
//        }
    }

    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int center = start + (end - start) / 2;
            if(nums[center] < nums[center + 1]) {
                start = center + 1;
            }
            else {
                end = center;
            }
        }
        return start;
    }
}