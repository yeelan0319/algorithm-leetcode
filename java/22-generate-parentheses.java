import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, 1, true);
        test(2, 2, false);
        test(3, 3, true);
        test(4, 4, true);
    }

    public static void test(int testNo, int n, boolean expectValue) {
        //System.out.print(l1.toString() + ", " + l2.toString());
       List<String> res = generateParenthesis(n);

//        for(String s : res) {
            System.out.println(res.toString());
//        }
//        System.out.println("");
//        if (res == expectValue) {
//            System.out.println(testNo + ": Pass");
//        } else {
//            System.out.println(testNo + ": Fail");
//            System.out.println("Expect " + expectValue + ", Return " + res);
//        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        if(n > 0) {
            generateParenthesisHelper(n, sb, res);
        }
        return res;
    }
    public static void generateParenthesisHelper(int n, StringBuilder sb, List<String> res) {
        if(n == 0) {
            res.add(sb.toString());
            return;
        }
        int count = 0;
        sb.insert(0, '(');
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '(') {
                count++;
            }
            else {
                count--;
            }
            if(count == 1) {
                sb.insert(i + 1, ')');
                generateParenthesisHelper(n - 1, sb, res);
                sb.deleteCharAt(i + 1);
            }
        }
        sb.deleteCharAt(0);
    }
}