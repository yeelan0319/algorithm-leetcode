import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        test(2, new int[]{1, 2, 3, 4}, 1);
    }

    public static void test(int testNo, int[] nums, int expectValue) {
        int res = findMin(nums);

//        System.out.println(res.toString());
//        System.out.println("");
        if (res == expectValue) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }

    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int center = (start + end) / 2;
            if(nums[center] > nums[end]) {
                start = center + 1;
            }
            else {
                end = center;
            }
        }
        return nums[start];
    }
}