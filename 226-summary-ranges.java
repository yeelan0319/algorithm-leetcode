import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[]{0,1,2,4,5,7}, new ArrayList<String>(Arrays.asList("0->2","4->5", "7")));
        test(2, new int[]{0,1,1,1,1,7}, new ArrayList<String>(Arrays.asList("0->1", "7")));
        test(3, new int[]{1,1,1}, new ArrayList<String>(Arrays.asList("1")));
        test(4, new int[]{-2147483648,-2147483647,2147483647}, new ArrayList<String>(Arrays.asList("-2147483648->-2147483647", "2147483647")));
    }

    public static void test(int testNo, int[] nums, List<String> expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        List<String> res = summaryRanges(nums);

//        if(res != null){
//            for (String x : res.levelOrderSerialization()) {
//                System.out.print(x + " ");
//            }
//        }
//        else{
//            System.out.print("[]");
//        }
//        System.out.println("");
        if (res.equals(expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue.toString() + ", Return " +res.toString());
        }
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        int i = 0;
        while(i < nums.length) {
            long start = nums[i];
            long prev = nums[i];
            while(i < nums.length && nums[i] <= prev + 1) {
                prev = nums[i];
                i++;
            }
            if(start == nums[i - 1]) {
                res.add(start + "");
            }
            else {
                res.add(start + "->" + nums[i - 1]);
            }
        }
        return res;
    }
}