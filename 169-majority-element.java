import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[]{1,2,5,1,6,1,1}, 1);
    }

    public static void test(int testNo, int[] nums, int expectValue) {
        int res = majorityElement(nums);

//        System.out.println(res);
//        System.out.println("");
        if (res == expectValue) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }

    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                candidate = nums[i];
            }
            if(candidate == nums[i]) {
                count++;
            }
            else {
                count--;
            }
        }
        return candidate;
    }
}