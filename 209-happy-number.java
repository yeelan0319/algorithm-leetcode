import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, 19, true);
        test(2, 10, true);
        test(3, 68, true);
        test(4, 0, false);
        test(5, Integer.MAX_VALUE, false);
    }

    public static void test(int testNo, int n, boolean expectValue) {
        boolean res = isHappy(n);

//        for(char[] row : board) {
//            for(char c : row) {
//                System.out.print(c + " ");
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

    public static boolean isHappy(int n) {
        HashSet<Long> hs = new HashSet<Long>();
        long sum = 0;
        long num = n;
        while(sum != 1) {
            sum = 0;
            while(num != 0) {
                long digit = num % 10;
                sum += digit * digit;
                num /= 10;
            }
            if(hs.contains(sum)) {
                return false;
            }
            else {
                hs.add(sum);
            }
            num = sum;
        }
        return true;
    }
}