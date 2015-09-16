import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[]{1,2,3,4}, new int[]{24, 12, 8, 6});
    }

    public static void test(int testNo, int[] nums, int[] expectValue) {
        int[] res = productExceptSelf(nums);

//        for(int i : res) {
//            System.out.print(i + " ");
//        }
//        System.out.println("");
        if (Arrays.equals(res,expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        if(n < 2) return res;
        res[0] = 1;
        for(int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for(int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}