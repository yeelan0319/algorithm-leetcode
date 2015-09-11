import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[]{1, 1, 1, 1}, 3);
        test(2, new int[]{2, 1, 3, 1}, 4);
        test(3, new int[]{5, 4, 3, 2, 1}, 6);
    }

    public static void test(int testNo, int[] height, int expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        int res = maxArea(height);

//        if(res != null){
//            for (String x : res.levelOrderSerialization()) {
//                System.out.print(x + " ");
//            }
//        }
//        else{
//            System.out.print("[]");
//        }
//        System.out.println("");
        if (res == expectValue) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int low = 0;
        int high = height.length - 1;
        while(low < high) {
            maxArea = Math.max((high - low) * Math.min(height[high], height[low]), maxArea);
            if(height[low] < height[high]) {
                low++;
            }
            else {
                high--;
            }
        }
        return maxArea;
    }
}