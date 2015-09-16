import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[]{1,2,3}, 8);
        test(2, new int[]{}, 0);
        test(3, new int[]{1}, 1);
    }

    public static void test(int testNo, int[] nums, int expectValue) {
        List<List<Integer>> res = subsets(nums);

        for(List<Integer> l : res) {
            System.out.println(l.toString());
        }
        System.out.println("");
//        if (res == expectValue) {
//            System.out.println(testNo + ": Pass");
//        } else {
//            System.out.println(testNo + ": Fail");
//            System.out.println("Expect " + expectValue + ", Return " + res);
//        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
    		Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        List<Integer> subset = new ArrayList<Integer>();
        subsetsHelper(nums, subset, res, 0);
        return res;
    }
    public static void subsetsHelper(int[] nums, List<Integer> subset, List<List<Integer>> res, int begin) {
        if(begin == nums.length) return;
        for(int i = begin; i < nums.length; i++) {
            subset.add(nums[i]);
            res.add(new ArrayList<Integer>(subset));
            subsetsHelper(nums, subset, res, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}