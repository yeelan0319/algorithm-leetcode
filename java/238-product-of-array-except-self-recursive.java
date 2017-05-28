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
        if(nums.length < 2) return new int[nums.length];
        productHelper(nums, 1, 0);
        return nums;
    }
    public static int productHelper(int[] nums, int leftProd, int index) {
        int rightProd = 1;
        if(index < nums.length) {
            rightProd = productHelper(nums, leftProd * nums[index], index + 1);
            int tmp = nums[index];
            nums[index] = leftProd * rightProd;
            rightProd *= tmp;
        }
        return rightProd;
    }
}