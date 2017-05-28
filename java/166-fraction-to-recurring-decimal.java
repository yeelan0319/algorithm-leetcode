import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, 1, 2, "0.5");
        test(2, 2, 1, "2");
        test(3, 2, 3, "0.(6)");
        test(4, 1, -2, "-0.5");
        //test(5, 2147483646, 2147483647, "0.999999999534338");
        test(6, 10, 0, "");
        test(7, 1, 6, "0.1(6)");
        test(8, 0, 3, "0");
        test(9, 0, -5, "0");
        test(10, -1, -2147483648, "0.0000000004656612873077392578125");
    }

    public static void test(int testNo, int numerator, int denominator, String expectValue) {
        String res = fractionToDecimal(numerator, denominator);

//        for(char[] row : board) {
//            for(char c : row) {
//                System.out.print(c + " ");
//            }
//            System.out.println("");
//        }
//        System.out.println("");
        if (res.equals(expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) return "";
        if(numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int sign = numerator > 0? 1 : -1;
        sign = sign * (denominator > 0? 1 : - 1);
        if(sign < 0) sb.append("-");
        //此处要先cast类型，然后再取abs，否则没有办法取到正确的值
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        sb.append(n / d);
        n %= d;
        if(n == 0) {
            return sb.toString();
        }
        else {
            HashMap<Long, Integer> occurence = new HashMap<Long, Integer>();
            sb.append(".");
            int pos = sb.length();
            while(!occurence.containsKey(n)) {
                occurence.put(n, pos++);
                n *= 10;
                sb.append(n / d);
                n %= d;
                if(n == 0) return sb.toString();
            }
            sb.insert(occurence.get(n), "(");
            sb.append(")");
            return sb.toString();
        }
    }
}