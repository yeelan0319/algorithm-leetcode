import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, 7, new int[]{2,3,1,2,4,3}, 2);
        test(2, 1000, new int[]{2,3,1,2,4,3}, 0);

    }

    public static void test(int testNo, int s, int[] nums, int expectValue) {
        int res = minSubArrayLen(s, nums);

//        System.out.println(res);
//        System.out.println("");
        if (res == expectValue) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int end = 0;
        int min = nums.length + 1;
        while(end < nums.length) {
            s -= nums[end];
            if(s <= 0) {
                while(s + nums[start] <= 0) {
                    s += nums[start];
                    start++;
                }
                min = Math.min(end - start + 1, min);
            }
            end++;
        }
        return min > nums.length? 0 : min;
    }
}