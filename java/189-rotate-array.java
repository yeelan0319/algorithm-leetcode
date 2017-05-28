import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[]{1,2,3,4,5,6,7}, 2, 6);
        test(2, new int[]{1,2,3,4,5,6,7}, 10, 6);
        test(3, new int[]{1}, 3, 6);
        test(4, new int[]{}, 5, 6);
        test(5, new int[]{1,2,3,4,5,6}, 2, 6);
    }

    public static void test(int testNo, int[] nums, int k, int expectValue) {
        rotate(nums, k);

        for(int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println("");
//        if (res == expectValue) {
//            System.out.println(testNo + ": Pass");
//        } else {
//            System.out.println(testNo + ": Fail");
//            System.out.println("Expect " + expectValue + ", Return " + res);
//        }
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return;
        int count = n;
        int start = 0;
        while(count > 0) {
            int curr = start;
            int tmp = nums[curr];
            do {
                int next = (curr + k) % n;
                int nextval = nums[next];
                nums[next] = tmp;
                curr = next;
                tmp = nextval;
                count--;
            } while(start != curr);
            start++;
        }
    }
}