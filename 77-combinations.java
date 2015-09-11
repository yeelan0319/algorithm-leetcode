import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, 4, 2, 1);
        test(2, 5, 1, 1);
        test(3, 5, 5, 1);
        test(4, 5, 6, 1);
    }

    public static void test(int testNo, int n, int k, int expectValue) {
        List<List<Integer>> res = combine(n, k);

        for(List l : res) {
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

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> combination = new ArrayList<Integer>();
        if(n >= k && n > 0) {
            combinationHelper(n, k, combination, res, 1);
        }
        return res;
    }
    public static void combinationHelper(int n, int k, List<Integer> combination, List<List<Integer>> res, int begin) {
        if(k == 0) {
            res.add(new ArrayList<Integer>(combination));
            return;
        }
        for(int i = begin; i < n + 1; i++) {
            combination.add(i);
            combinationHelper(n, k - 1, combination, res, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}