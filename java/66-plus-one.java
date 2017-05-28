import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 5});
        test(2, new int[]{1, 9, 9, 9}, new int[]{2, 0, 0, 0});
        test(3, new int[]{9, 9, 9, 9}, new int[]{1, 0, 0, 0, 0});
        test(4, new int[]{0}, new int[]{1});
    }

    public static void test(int testNo, int[] nums, int[] expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        int[] res = plusOne(nums);

//        if(res != null){
//            for (String x : res.levelOrderSerialization()) {
//                System.out.print(x + " ");
//            }
//        }
//        else{
//            System.out.print("[]");
//        }
//        System.out.println("");
        if (Arrays.equals(res, expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + Arrays.toString(expectValue) + ", Return " + Arrays.toString(res));
        }
    }
    public static int[] plusOne(int[] digits) {
        int carryon = 1;
        for(int i = digits.length - 1; i >= 0 && carryon > 0; i--) {
            carryon += digits[i];
            digits[i] = carryon % 10;
            carryon /= 10;
        }
        if(carryon != 0) {
            int[] newdigits = new int[digits.length + 1];
            newdigits[0] = 1;
            return newdigits;
        }
        else{
            return digits;
        }
    }
}