import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, 100, 25);
        test(2, 5, 2);
        test(3, 3, 1);
        test(4, 2, 0);
    }

    public static void test(int testNo, int n, int expectValue) {
        int res = countPrimes(n);

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

    public static int countPrimes(int n) {
        if(n <= 2) return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int count = n - 2;
        int sqrt = (int)Math.sqrt(n);
        for(int i = 2; i <= sqrt; i++) {  //注意此处是<=，因为可能会有test(2, 5, 2);这样无法正好开方而取floor的情况出现
            if(isPrime[i]) {
                for(int j = i * i; j < n; j+=i) {
                    if(isPrime[j]) {
                        isPrime[j] = false;
                        count--;
                    }
                }
            }
        }
        return count;
    }
}