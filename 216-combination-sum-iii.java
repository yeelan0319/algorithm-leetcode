import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, 3, 7, 1);
        test(1, 3, 9, 1);
    }

    public static void test(int testNo, int k, int n, int expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
        List<List<Integer>> res = combinationSum3(k, n);

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
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> combination = new ArrayList<Integer>();
        combinationSumHelper(k, n, combination, res, 1);
        return res;
    }
    public static void combinationSumHelper(int k, int target, List<Integer> combination, List<List<Integer>> res, int begin) {
        //这里必须满足两个条件，target == 0表示加和为0，k == 0表示到达深度了
        if(k == 0 && target == 0) {
            res.add(new ArrayList<Integer>(combination));
            return;
        }
        for(int i = begin; i < 10 && i <= target; i++) {
            combination.add(i);
            //注意这里是i + 1
            combinationSumHelper(k - 1, target - i, combination, res, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}