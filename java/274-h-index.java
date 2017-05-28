import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new int[]{3, 0, 6, 1, 5}, 3);
        test(2, new int[]{0, 1, 1, 1, 1, 1}, 1);
        test(3, new int[]{0, 0}, 0);
        test(4, new int[]{}, 0);
    }

    public static void test(int testNo, int[] citations, int expectValue) {
        int res = hIndex(citations);

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

    public static int hIndex(int[] citations) {
        int[] citedMoreThan = new int[citations.length + 1];
        for(int i = 0; i < citations.length; i++) {
            if(citations[i] > citations.length) {
                citedMoreThan[citations.length]++;
            }
            else {
                citedMoreThan[citations[i]]++;
            }
        }
        int total = 0;
        for(int i = citations.length; i >= 0; i--) {
            total += citedMoreThan[i];
            //此处不需要检查另一半是因为另一半的条件是，有至少N-h篇文章的引用次数小于h。
            //实际在i处有N-total篇文章小于i，也就是 N-i <= N-total => total >= i 所以是同一个条件。
            if(total >= i) {
                return i;
            }
        }
        return 0;
    }
}