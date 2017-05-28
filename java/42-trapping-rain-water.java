import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[]{0,1,0,2,1,0,1,3,2,1,2,1}, 6);
        test(2, new int[]{1,1,1,1,1,1,1}, 0);
    }

    public static void test(int testNo, int[] height, int expectValue) {
        int res = trap(height);

//        for(int[] row : matrix) {
//            for(int i : row) {
//                System.out.print(i + " ");
//            }
//            System.out.println("");
//        }
//        System.out.println("");
        if (res == expectValue) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }

    public static int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int maxtmp = 0;
        int trap = 0;
        for(int i = 0; i < height.length; i++) {
            left[i] = maxtmp;
            maxtmp = Math.max(height[i], maxtmp);
        }
        maxtmp = 0;
        for(int i = height.length - 1; i >= 0; i--) {
            right[i] = maxtmp;
            maxtmp = Math.max(height[i], maxtmp);
        }
        for(int i = 0; i < height.length - 1; i++) {
            if(height[i] < left[i] && height[i] < right[i]) {
                trap += Math.min(left[i], right[i]) - height[i];
            }
        }
        return trap;
    }
}