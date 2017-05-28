import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[]{1, 2, 3, 4}, new int[]{1, 2, 4, 3});
        test(2, new int[]{1, 2, 4, 3}, new int[]{1, 3, 2, 4});
        test(3, new int[]{4, 3, 2, 1}, new int[]{1, 2, 3, 4});
        test(4, new int[]{1, 2, 3}, new int[]{1, 3, 2});
        test(5, new int[]{1, 1, 5}, new int[]{1, 5, 1});
        test(6, new int[]{1, 1, 5, 1, 1}, new int[]{1, 5, 1, 1, 1});
    }

    public static void test(int testNo, int[] nums, int[] expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        nextPermutation(nums);

//        if(res != null){
//            for (String x : res.levelOrderSerialization()) {
//                System.out.print(x + " ");
//            }
//        }
//        else{
//            System.out.print("[]");
//        }
//        System.out.println("");
        if (Arrays.equals(nums, expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + Arrays.toString(expectValue) + ", Return " + Arrays.toString(nums));
        }
    }
    public static void nextPermutation(int[] nums) {
        int x = nums.length - 2;
        while(x >= 0 && nums[x] >= nums[x + 1]) x--;
        if(x != -1) {
            int y = x + 1;
            while(y < nums.length - 1 && nums[y + 1] > nums[x]) y++;
            int tmp = nums[y];
            nums[y] = nums[x];
            nums[x] = tmp;
        }
        int start = x + 1;
        int end = nums.length - 1;
        while(start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }
}