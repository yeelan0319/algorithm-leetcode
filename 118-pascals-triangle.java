import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, 0, 0);
        test(2, 1, 1);
        test(3, 2, 2);
        test(4, 5, 5);
    }

    public static void test(int testNo, int numRows, int expectValue) {
        List<List<Integer>> res = generate(numRows);

        for(List l : res) {
            System.out.println(l.toString());
        }
        System.out.println("");
//        if (Arrays.equals(res,expectValue)) {
//            System.out.println(testNo + ": Pass");
//        } else {
//            System.out.println(testNo + ": Fail");
//            System.out.println("Expect " + expectValue + ", Return " + res);
//        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> row;
            if(i == 0) {
                row = new ArrayList<Integer>() {
                    {
                        add(1);
                    }
                };
            }
            else {
                row = new ArrayList<Integer>(res.get(res.size() - 1));
                row.add(0, 1);
                for(int j = 1; j < row.size() - 1; j++) {
                    row.set(j, row.get(j) + row.get(j + 1));
                }
            }
            res.add(row);
        }
        return res;
    }
}