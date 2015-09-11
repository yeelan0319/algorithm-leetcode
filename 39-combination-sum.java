import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[]{2,3,6,7}, 7, 1);
    }

    public static void test(int testNo, int[] candidates, int target, int expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        List<List<Integer>> res = combinationSum(candidates, target);

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
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> combination = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, combination, res, 0);
        return res;
    }
    public static void combinationSumHelper(int[] nums, int target, List<Integer> combination, List<List<Integer>> res, int begin) {
        if(target == 0) {
            res.add(new ArrayList<Integer>(combination));
            return;
        }
        for(int i = begin; i < nums.length && nums[i] <= target; i++) {
            combination.add(nums[i]);
            combinationSumHelper(nums, target - nums[i], combination, res, i);
            combination.remove(combination.size() - 1);
        }
    }
}